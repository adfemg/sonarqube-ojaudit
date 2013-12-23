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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.sonar.api.batch.SensorContext;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.resources.Project;
import org.sonar.api.resources.Resource;
import org.sonar.api.rules.ActiveRule;
import org.sonar.api.rules.Violation;

/**
 * Helper class for parsing an ojaudit output file and reporting any violation to a SensorContext.
 * @author Wilfred van der Deijl
 * @see Analyzer
 */
public class ResultsParser {

    private static final Logger LOG = LoggerFactory.getLogger(ResultsParser.class);

    // xsd can be found in JDEV_HOME/jdev/extensions/oracle.ide.audit.jar!oracle/jdevimpl/audit/report/audit.xsd
    private final Project project;
    private final RulesProfile profile;
    private final SensorContext context;

    /**
     * Constructor.
     * @param project Project being analyzed by sonar
     * @param profile Active rule profile for the current sonar analysis
     * @param context SensorContext where vioilations should be reported to
     */
    public ResultsParser(Project project, RulesProfile profile, SensorContext context) {
        this.project = project;
        this.profile = profile;
        this.context = context;
    }

    /**
     * Parse an ojaudit output file and report any violations to the SensorContext supplied to
     * the constructor.
     * @param output ojaudit output file
     */
    public void parse(File output) {
        LOG.info("parsing ojaudit's result XML file {}...", output.getAbsolutePath());
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
            throw new OJAuditException("error parsing ojaudit output at " + file, e);
        }
    }

    /**
     * Process a Construct from an ojaudit output file and all of its children. This method
     * recursively calls itself to process nested constructs.
     * @param construct ojaudit Construct being processed
     */
    private void processConstruct(Construct construct) {
        LOG.debug("processing construct {} {}", new Object[] { construct.getKind(), construct.getLabel() });
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
        LOG.debug("processing violation {}", violation.getMessage());
        // get File with violation
        Location loc = violation.getLocation();
        Model model = (Model) loc.getModel();
        File f = new File(model.getFile().getPath());
        if (!f.canRead()) {
            LOG.warn("file {} no longer exists, ignoring violation", f);
            return;
        }
        // lookup sonar Resource for the violating file
        Resource resource = project.getFileSystem().toResource(f);
        if (resource == null) {
            LOG.warn("could not find resource {} in sonar project sources", f);
            return;
        }
        // find ActiveRule for violation
        String ruleKey = ((Rule) violation.getRule()).getName();
        ActiveRule activeRule = getActiveRule(profile, ruleKey);
        if (activeRule == null) {
            LOG.warn("no active sonar Rule with key {} found in language {}, profile {}", new Object[] {
                     ruleKey, profile.getLanguage(), profile.getName()
            });
            return;
        }
        // reporting sonar violation
        LOG.info("creating violation for rule {} in {}", new Object[] { activeRule.getRuleKey(), resource });
        Violation v = Violation.create(activeRule, resource);
        v = v.setMessage(violation.getMessage());
        if (violation.getLocation() != null && violation.getLocation().getLineNumber() != null) {
            v.setLineId(Integer.parseInt(violation.getLocation().getLineNumber()));
        }
        context.saveViolation(v);
    }

    private ActiveRule getActiveRule(RulesProfile profile, String key) {
        ActiveRule retval = profile.getActiveRule(OJAuditPlugin.SONAR_REPOS_KEY, key);
        if (retval != null) {
            return retval;
        }
        return null;
    }

}
