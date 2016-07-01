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

import org.sonar.api.Plugin;
import org.sonar.api.PropertyType;
import org.sonar.api.config.PropertyDefinition;
import org.sonar.api.resources.Qualifiers;

/**
 * Main ojaudit plugin class.
 * @author Wilfred van der Deijl
 * @see <a href="http://docs.sonarsource.org/latest/apidocs">Sonar API Documentation</a>
 */
public final class OJAuditPlugin implements Plugin {

    public static final String LANGUAGE_KEY = "ojaudit";
    public static final String LANGUAGE_NAME = "OJAudit (JDeveloper auditing framework)";

    public static final String SONAR_PROFILE_KEY = "Sonar Way";
    public static final String SONAR_REPOS_KEY = "ojaudit";
    public static final String SONAR_REPOS_NAME = "ojaudit";

    // plugin settings keys
    public static final String TARGET_FILE_KEY = "sonar.ojaudit.target";
    public static final String JDEV_HOME_KEY = "sonar.ojaudit.jdevhome";
    public static final String OJAUDIT_EXEC_KEY = "sonar.ojaudit.executable";
    public static final String OJAUDIT_PROFILE_KEY = "sonar.ojaudit.profile";
    public static final String OJAUDIT_TIMEOUT_SECS_KEY = "sonar.ojaudit.timeoutsecs";
    public static final String OJAUDIT_RULEHELP_KEY = "sonar.ojaudit.rulehelp";

    /**
     * Register our sonar extension points at startup.
     * @param context Plugin context
     */
    @Override
    public void define(Plugin.Context context) {
        context.addExtension(Language.class); // language definition so we can accept all files
        context.addExtension(Configuration.class); // parse sonar plugin settings
        context.addExtension(Analyzer.class); // do the actual analysis by invoking ojaudit
        context.addExtension(DefaultProfile.class); // default profile enabling all rules
        context.addExtension(RulesDefinition.class); // repository parsing rulehelp.txt and exposing all ojaudit rules to sonar

        context.addExtension(PropertyDefinition.builder(OJAuditPlugin.TARGET_FILE_KEY).onlyOnQualifiers(Qualifiers.PROJECT,
                                                                                                        Qualifiers.MODULE).name("Relative path to .jws or .jpr file from sonar project home").description("Relative path to .jws or .jpr file from sonar project home").build());
        context.addExtension(PropertyDefinition.builder(OJAuditPlugin.JDEV_HOME_KEY).onQualifiers(Qualifiers.PROJECT,
                                                                                                  Qualifiers.MODULE).name("JDeveloper home directory").description("JDeveloper home directory (that has jdev/bin as subdirectory").build());
        context.addExtension(PropertyDefinition.builder(OJAuditPlugin.OJAUDIT_EXEC_KEY).defaultValue("").onQualifiers(Qualifiers.PROJECT,
                                                                                                                      Qualifiers.MODULE).name("OJAudit executable").description("ojaudit executable within JDEV_HOME/jdev/bin directory, typically ojaudit.exe on windows or ojaudit on linux. When not specified the default depends on the operating system").build());
        context.addExtension(PropertyDefinition.builder(OJAuditPlugin.OJAUDIT_PROFILE_KEY).defaultValue("All Rules").onQualifiers(Qualifiers.PROJECT,
                                                                                                                                  Qualifiers.MODULE).name("OJAudit profile").description("Name of the audit profile to execute. Run 'jdev/bin/ojaudit -profilehelp' to list available profiles").build());
        context.addExtension(PropertyDefinition.builder(OJAuditPlugin.OJAUDIT_TIMEOUT_SECS_KEY).defaultValue("300").type(PropertyType.INTEGER).onQualifiers(Qualifiers.PROJECT,
                                                                                                                                                            Qualifiers.MODULE).name("Timeout (secs)").description("Maximum number of seconds to wait for ojaudit to complete").build());
        context.addExtension(PropertyDefinition.builder(OJAuditPlugin.OJAUDIT_RULEHELP_KEY).defaultValue("").name("ojaudit -rulehelp output").description("\"Path to the output of 'ojaudit -rulehelp'. Can be relative to SONAR_HOME or an absolute path. If not specified SONAR_HOME/conf/ojaudit-rulehelp.txt will be used.").build());
    }
}
