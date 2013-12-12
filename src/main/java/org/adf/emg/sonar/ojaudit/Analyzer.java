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

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.resources.Project;
import org.sonar.api.utils.command.Command;
import org.sonar.api.utils.command.CommandExecutor;

/**
 * This Analyzer is invoked once during the analysis of a project. It invokes the command-line ojaudit tool
 * and parses the outcome to Sonar Measures which are reported back to Sonar.
 * @author Wilfred van der Deijl
 */
public class Analyzer implements Sensor {

    private static final Logger LOG = LoggerFactory.getLogger(Analyzer.class);

    private static final Long MSECS_PER_SEC = 1000L;

    // plugin classes received by dependency injection through constructor
    private final Configuration config;
    private final RulesProfile profile;

    /**
     * Constructor.
     * @param config Plugin configuration
     * @param profile Profile being used for this analysis
     */
    public Analyzer(Configuration config, RulesProfile profile) {
        this.config = config;
        this.profile = profile;
    }

    /**
     * Determines if this Sensor should run for a given project.
     * @param project Project
     * @return <code>true</code> if the supplied project uses ojaudit as language, otherwise <code>false</code>
     * @see OJAuditPlugin#LANGUAGE_KEY
     */
    @Override
    public boolean shouldExecuteOnProject(Project project) {
        boolean retval = OJAuditPlugin.LANGUAGE_KEY.equals(project.getLanguageKey());
        if (!retval) {
            LOG.debug(this.getClass().getName() + " not executing on project with language " +
                      project.getLanguageKey());
        }
        return retval;
    }

    /**
     * Performs analysis on a given project and reports measures (violations) to the given context.
     * @param project Project to analyse
     * @param context SensorContext where measures (violations) should be reported to
     */
    @Override
    public void analyse(Project project, SensorContext context) {
        File output = new File(project.getFileSystem().getSonarWorkingDirectory(), "ojaudit.xml");
        LOG.info("ojaudit output will be written to {}", output.getAbsolutePath());
        executeAudit(output);
        collectMeasures(output, project, context);
    }

    /**
     * Runs ojaudit and saves the output to the given file.
     * @param output Location of the output (XML) file to generate
     */
    protected void executeAudit(File output) {
        String cmd = null;
        try {
            long start = System.currentTimeMillis();
            Command command = Command.create(config.getExecutable().getCanonicalPath());
            command = command.addArgument("-profile").addArgument(config.getProfile());
            command = command.addArgument("-output").addArgument(output.getCanonicalPath());
            command = command.addArgument("-encoding").addArgument("UTF-8");
            command = command.addArgument(config.getWorkspaceFile().getCanonicalPath());
            cmd = command.toCommandLine();
            LOG.info("executing {}", cmd);
            CommandExecutor executor = CommandExecutor.create();
            int exitCode = executor.execute(command, config.getTimeoutSecs() * MSECS_PER_SEC);
            if (exitCode != 0) {
                throw new IllegalStateException("The exit code was " + exitCode + " when 0 was expected for command: " +
                                                command);
            }
            LOG.info("ojaudit completed in {} ms", System.currentTimeMillis() - start);
        } catch (Exception e) {
            throw new OJAuditException("error running ojaudit" + (cmd == null ? "" : " (" + cmd + ")"), e);
        }
    }

    /**
     * Parses an ojaudit output file and report all violations as measures to the given context.
     * @param output XML output of ojaudit execution that will be parsed
     * @param project Project being analyzed
     * @param context SensorContext where measures/violations should be reported to
     * @see ResultsParser
     */
    protected void collectMeasures(File output, Project project, SensorContext context) {
        long start = System.currentTimeMillis();
        ResultsParser parser = new ResultsParser(project, profile, context);
        parser.parse(output);
        LOG.info("ojaudit results analysed in {} ms", System.currentTimeMillis() - start);
    }

}
