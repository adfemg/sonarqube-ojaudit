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

import org.sonar.api.batch.BatchSide;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.config.Settings;
import org.sonar.api.platform.ServerFileSystem;
import org.sonar.api.server.ServerSide;
import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;


/**
 * Helper class for interpreting the ojaudit plugin settings.
 * @author Wilfred van der Deijl
 */
@ServerSide
@BatchSide
public class Configuration {

    private final Logger log = Loggers.get(Configuration.class);

    private final Settings settings;

    /**
     * Constructor for dependency injection.
     * @param settings Global or project-specific plugin settings
     */
    public Configuration(Settings settings) {
        this.settings = settings;
    }

    /**
     * Gets the workspace (.jws) or project (.jpr) file for the current project.
     * @param fileSystem project fileSystem so we can locate target file
     * @return File object pointing to the jws or jpr file.
     * @throws IllegalArgumentException if sonar plugin property not set
     * @see OJAuditPlugin#TARGET_FILE_KEY
     */
    public File getTargetFile(FileSystem fileSystem) {
        checkKeyExists(OJAuditPlugin.TARGET_FILE_KEY);
        File file = fileSystem.resolvePath(settings.getString(OJAuditPlugin.TARGET_FILE_KEY));

        checkCanRead(file, "workspace or project file");
        return file;
    }

    /**
     * Gets the JDeveloper home directory.
     * @return File object pointing to the JDeveloper home directory.
     * @throws IllegalArgumentException if sonar plugin property not set
     * @see OJAuditPlugin#JDEV_HOME_KEY
     */
    public File getJDevHome() {
        checkKeyExists(OJAuditPlugin.JDEV_HOME_KEY);
        File dir = new File(settings.getString(OJAuditPlugin.JDEV_HOME_KEY));
        checkIsDirectory(dir, "JDeveloper home");
        return dir;
    }

    /**
     * Gets the ojaudit executable.
     * @return File object pointing to the ojaudit executable
     * @throws IllegalArgumentException if sonar plugin property for JDeveloper Home not set
     * @see #getJDevHome
     * @see OJAuditPlugin#OJAUDIT_EXEC_KEY
     */
    public File getExecutable() {
        String exec = settings.getString(OJAuditPlugin.OJAUDIT_EXEC_KEY);
        if (exec == null || exec.trim().isEmpty()) {
            exec = "\\".equals(File.separator) ? "ojaudit.exe" : "ojaudit";
        }
        File file = new File(new File(getJDevHome(), "jdev/bin"), exec);
        checkCanRead(file, "ojaudit executable");
        return file;
    }

    /**
     * Gets the name of the ojaudit profile to execute, which may be the default value if not explicitly set.
     * @return ojaudit profile to execute
     * @see OJAuditPlugin#OJAUDIT_PROFILE_KEY
     */
    public String getProfile() {
        checkKeyExists(OJAuditPlugin.OJAUDIT_PROFILE_KEY);
        return settings.getString(OJAuditPlugin.OJAUDIT_PROFILE_KEY);
    }

    /**
     * Gets the timeout (in seconds) to wait for ojaudit execution to complete, which may be the default value
     * if not explicitly set.
     * @return timeout in seconds
     * @see OJAuditPlugin#OJAUDIT_TIMEOUT_SECS_KEY
     */
    public int getTimeoutSecs() {
        checkKeyExists(OJAuditPlugin.OJAUDIT_TIMEOUT_SECS_KEY);
        return settings.getInt(OJAuditPlugin.OJAUDIT_TIMEOUT_SECS_KEY);
    }

    /**
     * Gets the location of the 'ojaudit -rulehelp' output, which may be the default value if not explicitly set.
     * @param serverFileSystem ServerFileSystem so we can locate target file
     * @return File object pointing to the 'ojaudit -rulehelp' executable
     * @see OJAuditPlugin#OJAUDIT_RULEHELP_KEY
     */
    public File getRuleHelp(ServerFileSystem serverFileSystem) {
        String ruleHelp = settings.getString(OJAuditPlugin.OJAUDIT_RULEHELP_KEY);
        File file;
        if (ruleHelp == null || ruleHelp.trim().isEmpty()) {
            // use default location of rulehelp
            file = new File(new File(serverFileSystem.getHomeDir(), "conf"), "rulehelp.txt");
            log.debug("{} not set, using default location of rulehelp at {}", OJAuditPlugin.OJAUDIT_RULEHELP_KEY, file);
        } else {
            file = new File(ruleHelp);
            if (!file.isAbsolute()) {
                log.debug("{} set to {}, relative to {}",
                          new Object[] { OJAuditPlugin.OJAUDIT_RULEHELP_KEY, ruleHelp, serverFileSystem.getHomeDir() });
                file = new File(serverFileSystem.getHomeDir(), file.toString());
            } else {
                log.debug("{} set to absolute path {}", OJAuditPlugin.OJAUDIT_RULEHELP_KEY, ruleHelp);
            }
        }
        checkCanRead(file, "rulehelp output");
        return file;
    }

    private void checkKeyExists(String key) {
        if (!settings.hasKey(key) && !settings.hasDefaultValue(key)) {
            throw new IllegalArgumentException(key + " not set in sonar-project.properties");
        }
    }

    private boolean checkCanRead(File file, String fileType) {
        if (!file.canRead()) {
            log.warn("unable to read " + fileType + " " + file);
            return false;
        }
        return true;
    }

    private boolean checkIsDirectory(File dir, String dirType) {
        if (!dir.isDirectory()) {
            log.warn("unable to read " + dirType + " " + dir);
            return false;
        }
        return true;
    }

}
