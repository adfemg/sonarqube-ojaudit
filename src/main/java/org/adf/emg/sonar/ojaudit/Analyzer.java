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

import org.sonar.api.batch.sensor.Sensor;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.SensorDescriptor;
import org.sonar.api.utils.command.Command;
import org.sonar.api.utils.command.CommandExecutor;
import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;


/**
 * This Analyzer is invoked once during the analysis of a project. It invokes the command-line ojaudit tool
 * and parses the outcome to Sonar Measures which are reported back to Sonar as violationss.
 * @author Wilfred van der Deijl
 */
public class Analyzer implements Sensor {

    private final Logger log = Loggers.get(Analyzer.class);

    private static final Long MSECS_PER_SEC = 1000L;

    // plugin classes received by dependency injection through constructor
    private final Configuration config;

    /**
     * Constructor.
     * @param config Plugin configuration
     */
    public Analyzer(Configuration config) {
        this.config = config;
    }

    /**
     * Determines if this Sensor should run for a given project.
     * @param descriptor Describe what a Sensor is doing
     */
    @Override
    public void describe(SensorDescriptor descriptor) {
        descriptor.name("ojaudit").onlyOnLanguage(OJAuditPlugin.LANGUAGE_KEY);
        //        descriptor.requireProperty(OJAuditPlugin.TARGET_FILE_KEY);
        descriptor.createIssuesForRuleRepository(OJAuditPlugin.SONAR_REPOS_KEY);
    }

    /**
     * Performs analysis on a given project and reports measures (violations) to the given context.
     * @param context SensorContext where measures (violations) should be reported to
     */
    @Override
    public void execute(SensorContext context) {
        File output = new File(context.fileSystem().workDir(), "ojaudit.xml");
        log.info("ojaudit output will be written to {}", output.getAbsolutePath());
        executeAudit(context, output);
        collectMeasures(output, context);
    }

    /**
     * Runs ojaudit and saves the output to the given file.
     * @param context SensorContext where measures (violations) should be reported to
     * @param output Location of the output (XML) file to generate
     */
    protected void executeAudit(SensorContext context, File output) {
        String cmd = null;
        try {
            long start = System.currentTimeMillis();
            Command command = Command.create(config.getExecutable().getCanonicalPath());
            command = command.addArgument("-profile").addArgument(config.getProfile());
            command = command.addArgument("-output").addArgument(output.getCanonicalPath());
            if (context.fileSystem() != null && context.fileSystem().encoding() != null) {
                command = command.addArgument("-encoding").addArgument(context.fileSystem().encoding().name());
            }
            command = command.addArgument(config.getTargetFile(context.fileSystem()).getCanonicalPath());
            command = command.setDirectory(context.fileSystem().baseDir());
            cmd = command.toCommandLine();
            log.info("executing {}", cmd);
            CommandExecutor executor = CommandExecutor.create();
            int exitCode = executor.execute(command, config.getTimeoutSecs() * MSECS_PER_SEC);
            if (exitCode != 0) {
                throw new IllegalStateException("The exit code was " + exitCode + " when 0 was expected for command: " +
                                                command);
            }
            log.info("ojaudit completed in {} ms", System.currentTimeMillis() - start);
        } catch (Exception e) {
            throw new OJAuditException("error running ojaudit" + (cmd == null ? "" : " (" + cmd + ")"), e);
        }
    }

    /**
     * Parses an ojaudit output file and report all violations as measures to the given context.
     * @param output XML output of ojaudit execution that will be parsed
     * @param context SensorContext where measures/violations should be reported to
     * @see ResultsParser
     */
    protected void collectMeasures(File output, SensorContext context) {
        long start = System.currentTimeMillis();
        ResultsParser parser = new ResultsParser(context);
        parser.parse(output);
        log.info("ojaudit results analysed in {} ms", System.currentTimeMillis() - start);
    }
}
