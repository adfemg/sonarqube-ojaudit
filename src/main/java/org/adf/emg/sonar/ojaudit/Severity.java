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

import org.sonar.api.rules.RulePriority;

/**
 * Severity as reported by JDeveloper/ojaudit.
 * @author Wilfred van der Deijl
 */
public enum Severity {
    ERROR("error", RulePriority.BLOCKER),
    WARNING("warning", RulePriority.CRITICAL),
    INCOMPLETE("incomplete", RulePriority.MAJOR),
    ADVISORY("advisory", RulePriority.MINOR),
    ASSIST("assist", RulePriority.INFO);

    private String jdeveloper;
    private RulePriority sonar;

    Severity(String jdeveloper, RulePriority sonar) {
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
    public RulePriority sonarSeverity() {
        return sonar;
    }

}
