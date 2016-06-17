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


/**
 * Severity as reported by JDeveloper/ojaudit.
 * @author Wilfred van der Deijl
 */
public enum Severity {
    ERROR("error", org.sonar.api.rule.Severity.BLOCKER),
    WARNING("warning", org.sonar.api.rule.Severity.CRITICAL),
    INCOMPLETE("incomplete", org.sonar.api.rule.Severity.MAJOR),
    ADVISORY("advisory", org.sonar.api.rule.Severity.MINOR),
    ASSIST("assist", org.sonar.api.rule.Severity.INFO);

    private String jdeveloper;
    private String sonar;

    Severity(String jdeveloper, String sonar) {
        this.jdeveloper = jdeveloper;
        this.sonar = sonar;
    }

    /**
     * Returns the name of the severity as it is used by JDeveloper and ojaudit.
     * @return lowercase severity name
     */
    public String jdeveloperSeverity() {
        return jdeveloper;
    }

    /**
     * Returns the Sonar RulePriority that represents this JDeveloper/ojaudit severity.
     * @return Sonar RulePriority
     */
    public String sonarSeverity() {
        return sonar;
    }

}
