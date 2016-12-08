/*
 * Sonar ADF EMG ojaudit Plugin
 * Copyright (C) 2013 ADF EMG
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.adf.emg.sonar.ojaudit;

import com.oracle.xmlns.jdeveloper._1013.audit.Audit;
import com.oracle.xmlns.jdeveloper._1013.audit.Children;
import com.oracle.xmlns.jdeveloper._1013.audit.Construct;
import com.oracle.xmlns.jdeveloper._1013.audit.Location;
import com.oracle.xmlns.jdeveloper._1013.audit.Model;
import com.oracle.xmlns.jdeveloper._1013.audit.ObjectFactory;
import com.oracle.xmlns.jdeveloper._1013.audit.Rule;

import java.io.File;

import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.sonar.api.batch.fs.FilePredicate;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.fs.TextRange;
import org.sonar.api.batch.rule.ActiveRule;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.issue.NewIssue;
import org.sonar.api.rule.RuleKey;
import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;


/**
 * Helper class for parsing an ojaudit output file and reporting any violation to a SensorContext.
 * XSD for the parsed rule report can be found at
 * JDEV_HOME/jdev/extensions/oracle.ide.audit.jar!oracle/jdevimpl/audit/report/audit.xsd
 * @author Wilfred van der Deijl
 * @see Analyzer
 */
public class ResultsParser {

    private final Logger log = Loggers.get(ResultsParser.class);

    private final SensorContext context;

    /**
     * Constructor.
     * @param context SensorContext where vioilations should be reported to
     */
    public ResultsParser(SensorContext context) {
        this.context = context;
    }

    /**
     * Parse an ojaudit output file and report any violations to the SensorContext supplied to
     * the constructor.
     * @param output ojaudit output file
     */
    public void parse(File output) {
        log.info("parsing ojaudit's result XML file {}...", output.getAbsolutePath());
        Audit audit = unmarshall(output);
        processConstruct(audit.getConstruct());
    }

    /**
     * Parse an ojaudit output file to java objects.
     * @param file ojaudit result file
     * @return Audit object as that should be the document root of an ojaudit result file
     */
    private Audit unmarshall(File file) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(ObjectFactory.class);
            Unmarshaller unmarshaller = ctx.createUnmarshaller();
            Object obj = unmarshaller.unmarshal(file);
            if (!(obj instanceof Audit)) {
                throw new OJAuditException("Could not parse XML file " + file.getCanonicalPath(), null);
            }
            return (Audit) obj;
        } catch (Exception e) {
            log.error(e.toString());
            throw new OJAuditException("error parsing ojaudit output at " + file, e);
        }
    }

    /**
     * Process a Construct from an ojaudit output file and all of its children. This method
     * recursively calls itself to process nested constructs.
     * @param construct ojaudit Construct being processed
     */
    private void processConstruct(Construct construct) {
        log.debug("processing construct {} {}", new Object[] { construct.getKind(), construct.getLabel() });
        Children children = construct.getChildren();
        if (children == null) {
            return;
        }
        List<Object> list = children.getConstructOrViolation();
        if (list == null) {
            return;
        }
        for (Object o : list) {
            if (o instanceof com.oracle.xmlns.jdeveloper._1013.audit.Violation) {
                processViolation((com.oracle.xmlns.jdeveloper._1013.audit.Violation) o);
            } else if (o instanceof Construct) {
                processConstruct((Construct) o);
            }
        }
    }

    /**
     * Process a single ojaudit Violation by creating a sonar Violation and reporting it to the SensorContext.
     * @param violation ojaudit Violation
     */
    private void processViolation(com.oracle.xmlns.jdeveloper._1013.audit.Violation violation) {
        log.debug("processing violation {}", violation.getMessage());
        // get File with violation
        Location loc = violation.getLocation();
        Model model = (Model) loc.getModel();
        File f = new File(model.getFile().getPath());
        if (!f.canRead()) {
            //Sonar hasn't read the file (source), ignore the violation.
            log.warn("file {} does not exists in sonar, only in the sources, ignoring violation '{}'", f,
                     violation.getMessage());
            return;
        }
        // lookup sonar Resource for the violating file (parsed sonar source, to report violation on inline)
        InputFile inputFile = context.fileSystem().inputFile(new FileFinder(f));
        if (inputFile == null) {
            log.warn("could not find resource {} in sonar project sources, ignoring violation '{}'", f,
                     violation.getMessage());
            return;
        }
        // find ActiveRule for violation
        String ruleKey = ((Rule) violation.getRule()).getName();
        ActiveRule activeRule = getActiveRule(ruleKey);
        if (activeRule == null) {
            log.warn("no active sonar Rule with key {} found. Ignoring violation for {}", ruleKey, f);
            return;
        }
        // get location information of the ojaudit.xml file
        int lineNum = parseInt(loc.getLineNumber()); //line in the file
        int column = parseInt(loc.getColumnOffset()); //Start of the violation within the line.
        int length = parseInt(loc.getLength()); //Amount of characters of violation.

        //The line of the resource in sonar on which to report the violation.
        TextRange line = inputFile.selectLine(lineNum);

        //We do not want to report over multiple lines, so find the minimum length to report the violation on.
        //Either the start (column) plus the length of the violation or the lineEnd.
        int lineEnd = Math.min(column + length, line.end().lineOffset());

        TextRange issueLocation;
        if (lineEnd == column) {
            //Apparently the lineEnd is the same as the start, plus the length.
            //Could be a violation on an empty line.
            log.info("Found an issue location without a lenght, on rule {}.", ruleKey);
            log.debug("min: " + lineEnd + " - column: " + column + " - lineOffset: " + line.end().lineOffset() +
                      " - length: " + length);
            log.debug(ruleKey);
            log.debug(inputFile.absolutePath());
            log.debug(violation.getMessage());
            log.info("We are manipulating the issue location to be reported to the linenum till linenum +1.");
            issueLocation = inputFile.newRange(lineNum, column, (lineNum + 1), lineEnd);
        } else {
            issueLocation = inputFile.newRange(lineNum, column, lineNum, lineEnd);
        }

        // reporting sonar violation
        log.info("creating violation for rule {} in {}", new Object[] { activeRule.ruleKey() /*, resource*/ });
        NewIssue issue = context.newIssue().forRule(activeRule.ruleKey());
        issue.at(issue.newLocation()
                      .on(inputFile)
                      .at(issueLocation)
                      .message(violation.getMessage())).save();
    }

    private int parseInt(String s) {
        return s == null ? 0 : Integer.parseInt(s);
    }

    private ActiveRule getActiveRule(String key) {
        return this.context
                   .activeRules()
                   .find(RuleKey.of(OJAuditPlugin.SONAR_REPOS_KEY, key));
    }

    private static class FileFinder implements FilePredicate {
        private File file;

        private FileFinder(File file) {
            this.file = file;
        }

        @Override
        public boolean apply(InputFile inputFile) {
            return this.file.equals(inputFile.file());
        }
    }
}
