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

import org.sonar.api.server.rule.RulesDefinition;

/**
 * Helper class for parsing a rule from the 'ojaudit -rulhelp' output.
 * @author Wilfred van der Deijl
 */
public interface ParsedRule {

    /**
     * Parsed a line that has been read from the 'ojaudit -rulehelp' output.
     * @param line line to be parsed
     * @return <code>true</code> if the line could be processed by this ParsedRule, or <code>false</code> if it
     *         was ignored
     */
    boolean digest(String line);

    /**
     * Gets the key of this parsed rule.
     * @return key of the rule, or <code>null</code> if {@link #digest} hasn't been called yet on a line
     *         containing the rule defition
     */
    String getKey();

    /**
     * Can be invoked after parsing all lines of a certain rule with {@link #digest} to register the rule
     * with the given repository.
     * @param repos The repository to register this rule with
     */
    void toRule(RulesDefinition.NewExtendedRepository repos);

}
