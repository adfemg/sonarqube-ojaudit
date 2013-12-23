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
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.sonar.api.rules.Rule;
import org.sonar.api.rules.RulePriority;

/**
 * Helper class for parsing a rule from the 'ojaudit -rulhelp' output.
 * @author Wilfred van der Deijl
 */
public class ParsedRule12 {

    // regular expressions to parse lines
    private static final Pattern PATTERN_RULE = Pattern.compile("Rule:\\s*(.*\\S)\\s*\\((\\S+)\\)");
    private static final Pattern PATTERN_CATEGORY = Pattern.compile("Category:\\s*(.*\\S)\\s*\\((\\S+)\\)");
    private static final Pattern PATTERN_PROPERTIES = Pattern.compile("Properties:\\s*(.*)");
    private static final Pattern PATTERN_EXTENSION = Pattern.compile("Extension:\\s*(\\S+)\\s*\\((.+):(\\d+)\\)");

    // indices of matching groups in regular expressions
    private static final int GROUP_RULE_NAME = 1;
    private static final int GROUP_RULE_KEY = 2;
    private static final int GROUP_CATEGORY_NAME = 1;
    private static final int GROUP_CATEGORY_KEY = 2;
    private static final int GROUP_PROPERTIES = 1;
    private static final int GROUP_EXTENSION_KEY = 1;
    private static final int GROUP_EXTENSION_FILE = 2;
    private static final int GROUP_EXTENSION_LINE = 3;

    // state being built by parsing lines
    private String key;
    private String name;
    private String categoryKey;
    private String categoryName;
    private Collection<String> properties;
    private String extensionKey;
    private String extensionFile;
    private int extensionLine = -1;

    /**
     * Parsed a line that has been read from the 'ojaudit -rulehelp' output.
     * @param line line to be parsed
     * @return <code>true</code> if the line could be processed by this ParsedRule, or <code>false</code> if it
     *         was ignored
     */
    public boolean digest(String line) {
        return digestRule(line) || digestCategory(line) || digestProperties(line) || digestExtension(line);
    }

    private boolean digestRule(String line) {
        Matcher matcher = PATTERN_RULE.matcher(line);
        if (matcher.matches()) {
            this.key = matcher.group(GROUP_RULE_KEY);
            this.name = matcher.group(GROUP_RULE_NAME);
            return true;
        } else {
            return false;
        }
    }

    private boolean digestCategory(String line) {
        Matcher matcher = PATTERN_CATEGORY.matcher(line);
        if (matcher.matches()) {
            this.categoryKey = matcher.group(GROUP_CATEGORY_KEY);
            this.categoryName = matcher.group(GROUP_CATEGORY_NAME);
            return true;
        } else {
            return false;
        }
    }

    private boolean digestProperties(String line) {
        Matcher matcher = PATTERN_PROPERTIES.matcher(line);
        if (matcher.matches()) {
            this.properties = new ArrayList<String>();
            String props = matcher.group(GROUP_PROPERTIES);
            for (String p : props.split(",")) {
                this.properties.add(p.trim());
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean digestExtension(String line) {
        Matcher matcher = PATTERN_EXTENSION.matcher(line);
        if (matcher.matches()) {
            this.extensionKey = matcher.group(GROUP_EXTENSION_KEY);
            this.extensionFile = matcher.group(GROUP_EXTENSION_FILE);
            this.extensionLine = Integer.parseInt(matcher.group(GROUP_EXTENSION_LINE));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Can be invoked after parsing all lines of a certain rule with {@link #digest} and returns a
     * Sonar Rule.
     * @param reposKey key of the sonar repository the created Rule should belong to
     * @return org.sonar.api.rules.Rule instance
     */
    public Rule toRule(String reposKey) {
        Rule retval = Rule.create(reposKey, getKey(), getFullName());
        retval.setSeverity(getPriority());
        retval.setDescription(getName());
        return retval;
    }

    /**
     * Gets the key of this parsed rule.
     * @return key of the rule, or <code>null</code> if {@link #digest} hasn't been called yet on a line
     *         containing the rule defition
     */
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
     * @return name of the rule prefixed with the name of the category between square brackets, or <code>null</code> if
     * {@link #digest} hasn't been called yet on a line containing the rule defition
     */
    public String getFullName() {
        String name = getName();
        String catName = getCategoryName();
        if (name == null) {
            return null;
        }
        if (catName != null && !catName.isEmpty()) {
            return "[" + catName.trim() + "] " + name;
        } else {
            return name;
        }
    }

    /**
     * Gets the key of the category for this parsed rule.
     * @return key of the category, or <code>null</code> if {@link #digest} hasn't been called yet on a line
     *         containing the category defition
     */
    public String getCategoryKey() {
        return categoryKey;
    }

    /**
     * Gets the name of the category of this parsed rule.
     * @return name of the category, or <code>null</code> if {@link #digest} hasn't been called yet on a line
     *         containing the category defition
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Gets the properties of this parsed rule.
     * @return properties of the rule, or empty collection if {@link #digest} hasn't been called yet on a line
     *         containing the properties
     */
    public Collection<String> getProperties() {
        return properties == null ? Collections.<String>emptyList() : Collections.unmodifiableCollection(properties);
    }

    /**
     * Gets the key of the JDeveloper extension of this parsed rule.
     * @return key of the jdev-extension, or <code>null</code> if {@link #digest} hasn't been called yet on a line
     *         containing the extension definition
     */
    public String getExtensionKey() {
        return extensionKey;
    }

    /**
     * Gets the filename of the JDeveloper extension of this parsed rule.
     * @return filename of the jdev-extension, or <code>null</code> if {@link #digest} hasn't been called yet on a line
     *         containing the extension definition
     */
    public String getExtensionFile() {
        return extensionFile;
    }

    /**
     * Gets the line number of the rule in the JDeveloper extension file.
     * @return line number of the rule in the jdev-extension file, or <code>-1</code> if {@link #digest} hasn't
     *         been called yet on a line containing the extension definition
     */
    public int getExtensionLine() {
        return extensionLine;
    }

    /**
     * Indicates if the rule is enabled in the JDeveloper profile.
     * @return <code>false</code> if the line containing the properties has been digested and it indicated the
     *         rule is disabled, <code>true</code> otherwise
     */
    public boolean isEnabled() {
        return !getProperties().contains("disabled");
    }

    /**
     * Gets the severity of the rule as defined in JDeveloper.
     * @return severy of the rule or <code>null</code> if the line containing the properties hasn't been
     *         digested yet or it did not contain the severity
     */
    public Severity getSeverity() {
        for (Severity s : Severity.values()) {
            if (getProperties().contains(s.jdeveloperSeverity())) {
                return s;
            }
        }
        return null;
    }

    /**
     * Gets the sonar Priority that represents the priority as defined in JDeveloper.
     * @return RulePriority that represents th getPriority() result or MAJOR if the severity is unknown
     * @see #getSeverity
     */
    public RulePriority getPriority() {
        Severity s = getSeverity();
        return s != null ? s.sonarSeverity() : RulePriority.MAJOR;
    }

}
