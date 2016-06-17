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
 * Repository containing all the rules that can be reported by this ojaudit sonar plugin.
 * @author Wilfred van der Deijl
 */
public class RulesRepository /*extends RuleRepository*/ {

//    private static final Logger LOG = Loggers.get(RulesRepository.class);
//
//    private final Configuration config;
//
//    // cached as static class variable
//    private static List<Rule> rules = null;
//    private static Object mutex = new Object();
//
//    /**
//     * Constructor.
//     * @param config Plugin configuration
//     */
//    public RulesRepository(Configuration config) {
//        super(OJAuditPlugin.SONAR_REPOS_KEY, OJAuditPlugin.LANGUAGE_KEY);
//        setName(OJAuditPlugin.SONAR_REPOS_NAME);
//        this.config = config;
//    }
//
//    /**
//     * Reads the rulehelp.txt file specified in the sonar plugin properties and converts it
//     * to Sonar Rule definitions.
//     * @return List of Rules which is cached after the first invocation at class level so any
//     *         subsequent calls on this object or any other object will return the same list.
//     */
//    @Override
//    public List<Rule> createRules() {
//        // only parse rulehelp.txt the first time
//        if (rules == null) {
//            synchronized (mutex) {
//                // be sure no other thread created rules while we waited for lock
//                if (rules == null) {
//                    rules = parseRuleHelp(config.getRuleHelp());
//                }
//                return Collections.unmodifiableList(rules);
//            }
//        }
//        return Collections.unmodifiableList(rules);
//    }
//
//    /**
//     * Parses the rulehelp.txt output file and converts it to sonar Rules
//     * @param file
//     * @return list of Rules
//     * @see ParsedRule12
//     */
//    private List<Rule> parseRuleHelp(File file) {
//        if (file == null || !file.canRead()) {
//            LOG.warn("Unable to read rulehelp (specify " + OJAuditPlugin.OJAUDIT_RULEHELP_KEY + " setting)");
//            return Collections.emptyList();
//        }
//        LOG.info("Reading rulehelp file at {}", file.getAbsolutePath());
//
//        // try to open reader on file
//        BufferedReader br = null;
//        try {
//            br = new BufferedReader(new FileReader(file));
//            return parseRuleHelpLines(br);
//        } catch (IOException e) {
//            LOG.warn("Unable to read rulehelp (specify " + OJAuditPlugin.OJAUDIT_RULEHELP_KEY + " setting)", e);
//            return Collections.emptyList();
//        } finally {
//            if (br != null) {
//                try {
//                    br.close();
//                } catch (IOException e) {
//                    LOG.warn("error closing rulehelp file", e);
//                }
//            }
//        }
//    }
//
//    /**
//     * Parses the rulehelp.txt output file and converts it to sonar Rules
//     * @param reader BufferedReader to read rulehelp.txt. This reader is not closed by this
//     * method and should be closed by the caller.
//     * @return list of Rules
//     * @see ParsedRule12
//     */
//    private List<Rule> parseRuleHelpLines(BufferedReader reader) throws IOException {
//        // read file line-by-line and use ParsedRule to build rules
//        List<Rule> retval = new ArrayList<Rule>();
//        boolean version11 = false;
//        ParsedRule rule = null;
//        while (true) {
//            String line = reader.readLine();
//            if (line == null) {
//                break;
//            }
//            if ("Defined rules:".equals(line)) {
//                version11 = true;
//                continue;
//            }
//            if (line.startsWith("----") && (rule != null)) {
//                // process finished rule
//                retval.add(rule.toRule(this.getKey()));
//                rule = null;
//            } else if (line.startsWith("Rule:")) {
//                // start new rule
//                rule = version11 ? new ParsedRule11() : new ParsedRule12();
//            }
//            if (rule != null) {
//                rule.digest(line);
//            }
//        }
//        return retval;
//    }

}
