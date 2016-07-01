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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.sonar.api.rule.Severity;
import org.sonar.api.server.rule.RulesDefinition;

/**
 * Helper class for parsing a rule from the 'ojaudit -rulhelp' output.
 * @author Wilfred van der Deijl
 */
public class ParsedRule11 implements ParsedRule {

    // regular expressions to parse lines
    private static final Pattern PATTERN_RULE = Pattern.compile("Rule:\\s*(.*)");
    private static final Pattern PATTERN_ID = Pattern.compile("Id:\\s*(.*)");

    // indices of matching groups in regular expressions
    private static final int GROUP_RULE_NAME = 1;
    private static final int GROUP_ID_KEY = 1;

    // state being built by parsing lines
    private String key;
    private String name;

    /**
     * Parsed a line that has been read from the 'ojaudit -rulehelp' output.
     * @param line line to be parsed
     * @return <code>true</code> if the line could be processed by this ParsedRule, or <code>false</code> if it
     *         was ignored
     */
    @Override
    public boolean digest(String line) {
        return digestRule(line) || digestId(line);
    }

    private boolean digestRule(String line) {
        Matcher matcher = PATTERN_RULE.matcher(line);
        if (matcher.matches()) {
            this.name = matcher.group(GROUP_RULE_NAME);
            return true;
        } else {
            return false;
        }
    }

    private boolean digestId(String line) {
        Matcher matcher = PATTERN_ID.matcher(line);
        if (matcher.matches()) {
            this.key = matcher.group(GROUP_ID_KEY);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Can be invoked after parsing all lines of a certain rule with {@link #digest} to register the rule
     * with the given repository.
     * @param repos The repository to register this rule with
     */
    @Override
    public void toRule(RulesDefinition.NewExtendedRepository repos) {
        repos.createRule(getKey()).setName(getFullName()).setSeverity(getPriority()).setHtmlDescription(getName());
    }

    /**
     * Gets the key of this parsed rule.
     * @return key of the rule, or <code>null</code> if {@link #digest} hasn't been called yet on a line
     *         containing the rule defition
     */
    @Override
    public String getKey() {
        return key;
    }

    /**
     * Gets the name of this parsed rule.
     * @return name of the rule, or <code>null</code> if {@link #digest} hasn't been called yet on a line
     *         containing the rule defition
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the full name of this parsed rule.
     * @return name of the rule, or <code>null</code> if {@link #digest} hasn't been called yet on a line
     *         containing the rule defition
     */
    public String getFullName() {
        return getName();
    }

    /**
     * Gets the sonar Priority that represents the priority as defined in JDeveloper.
     * @return always Severity.MAJOR since version 11 rulehelp files don't contain a severity
     */
    public String getPriority() {
        return Severity.MAJOR;
    }

}
