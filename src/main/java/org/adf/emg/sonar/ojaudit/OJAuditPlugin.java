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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.sonar.api.Extension;
import org.sonar.api.Properties;
import org.sonar.api.Property;
import org.sonar.api.PropertyType;
import org.sonar.api.SonarPlugin;
import org.sonar.api.profiles.RulesProfile;

@Properties({
            @Property(key = OJAuditPlugin.WORKSPACE_FILE_KEY,
                      name = "Relative path to .jws file from sonar project home",
                      description = "Relative path to .jws file from sonar project home", project = true,
                      global = false),
            @Property(key = OJAuditPlugin.JDEV_HOME_KEY, name = "JDeveloper home directory",
                      description = "JDeveloper home directory (that has jdev/bin as subdirectory)", project = true,
                      global = true),
            @Property(key = OJAuditPlugin.OJAUDIT_EXEC_KEY, defaultValue = "", name = "OJAudit executable",
                      description =
                      "ojaudit executable within JDEV_HOME/jdev/bin directory, typically ojaudit.exe on windows or ojaudit on linux. When not specified the default depends on the operating system",
                      project = true, global = true),
            @Property(key = OJAuditPlugin.OJAUDIT_PROFILE_KEY, defaultValue = "All Rules", name = "OJAudit profile",
                      description =
                      "Name of the audit profile to execute. Run 'jdev/bin/ojaudit -profilehelp' to list available profiles",
                      project = true, global = true),
            @Property(key = OJAuditPlugin.OJAUDIT_TIMEOUT_SECS_KEY, defaultValue = "300", name = "Timeout (secs)",
                      description = "Maximum number of seconds to wait for ojaudit to complete", project = true,
                      global = true, type = PropertyType.INTEGER),
            @Property(key = OJAuditPlugin.OJAUDIT_RULEHELP_KEY, defaultValue = "", name = "ojaudit -rulehelp output",
                      description =
                      "Full path to the output of 'ojaudit -rulehelp'. If not specified SONAR_HOME/conf/ojaudit-rulehelp.txt will be used.",
                      project = false, global = true)
    })
/**
 * Main ojaudit plugin class.
 * @author Wilfred van der Deijl
 * @see <a href="http://docs.sonarsource.org/latest/apidocs">Sonar API Documentation</a>
 */
// http://docs.sonarsource.org/latest/apidocs/index.html
public final class OJAuditPlugin extends SonarPlugin {

    public static final String LANGUAGE_KEY = "ojaudit";
    public static final String LANGUAGE_NAME = "OJAudit";

    public static final String SONAR_PROFILE_KEY = RulesProfile.SONAR_WAY_NAME;
    public static final String SONAR_REPOS_KEY = "ojaudit";
    public static final String SONAR_REPOS_NAME = "ojaudit";

    // plugin settings keys
    public static final String WORKSPACE_FILE_KEY = "sonar.ojaudit.jws";
    public static final String JDEV_HOME_KEY = "sonar.ojaudit.jdevhome";
    public static final String OJAUDIT_EXEC_KEY = "sonar.ojaudit.executable";
    public static final String OJAUDIT_PROFILE_KEY = "sonar.ojaudit.profile";
    public static final String OJAUDIT_TIMEOUT_SECS_KEY = "sonar.ojaudit.timeoutsecs";
    public static final String OJAUDIT_RULEHELP_KEY = "sonar.ojaudit.rulehelp";

    /**
     * Returns list of extension classes for this plugin.
     * @return list of extension classes
     */
    @Override
    public List<Class<? extends Extension>> getExtensions() {
        List<Class<? extends Extension>> retval = new ArrayList<Class<? extends Extension>>();
        retval.add(Language.class); // language definition so we can accept all files
        retval.add(SourceImporter.class); // import all raw files
        retval.add(Configuration.class); // parse sonar plugin settings
        retval.add(Analyzer.class); // do the actual analysis by invoking ojaudit
        retval.add(DefaultProfile.class); // default profile enabling all rules
        retval.add(RulesRepository.class); // repository parsing rulehelp.txt and exposing all ojaudit rules to sonar
        return Collections.unmodifiableList(retval);
    }

}
