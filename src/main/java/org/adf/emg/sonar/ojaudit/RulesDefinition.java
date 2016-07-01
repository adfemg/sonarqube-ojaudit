package org.adf.emg.sonar.ojaudit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.sonar.api.platform.ServerFileSystem;
import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;

/**
 * Repository containing all the rules that can be reported by this ojaudit sonar plugin.
 * @author Wilfred van der Deijl
 */
public class RulesDefinition implements org.sonar.api.server.rule.RulesDefinition {

    private final Logger log = Loggers.get(RulesDefinition.class);

    private final Configuration config;
    private final ServerFileSystem serverFileSystem;

    public RulesDefinition(Configuration config, ServerFileSystem serverFileSystem) {
        this.config = config;
        this.serverFileSystem = serverFileSystem;
    }

    @Override
    public void define(org.sonar.api.server.rule.RulesDefinition.Context context) {
        NewRepository repos =
            context.createRepository(OJAuditPlugin.SONAR_REPOS_KEY,
                                     OJAuditPlugin.LANGUAGE_KEY).setName(OJAuditPlugin.SONAR_REPOS_NAME);
        this.parseRuleHelp(repos);
        // finalize the definition
        repos.done();
    }

    /**
     * Parses the rulehelp.txt output file and converts it to sonar Rules.
     * @param repos optional repository to register each found rule with
     * @return list of Rules
     * @see ParsedRule12
     */
    public List<ParsedRule> parseRuleHelp(NewRepository repos) {
        File file = config.getRuleHelp(serverFileSystem);
        if (file == null || !file.canRead()) {
            log.warn("Unable to read rulehelp (specify " + OJAuditPlugin.OJAUDIT_RULEHELP_KEY + " setting)");
            return Collections.emptyList();
        }
        log.info("Reading rulehelp file at {}", file.getAbsolutePath());

        // try to open reader on file
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            return parseRuleHelpLines(br, repos);
        } catch (IOException e) {
            log.warn("Unable to read rulehelp (specify " + OJAuditPlugin.OJAUDIT_RULEHELP_KEY + " setting)", e);
            return Collections.emptyList();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    log.warn("error closing rulehelp file", e);
                }
            }
        }
    }

    /**
     * Parses the rulehelp.txt output file and converts it to sonar Rules
     * @param reader BufferedReader to read rulehelp.txt. This reader is not closed by this
     * method and should be closed by the caller.
     * @return list of Rules
     * @see ParsedRule12
     */
    private List<ParsedRule> parseRuleHelpLines(BufferedReader reader, NewRepository repos) throws IOException {
        // read file line-by-line and use ParsedRule to build rules
        List<ParsedRule> retval = new ArrayList<ParsedRule>();
        boolean version11 = false;
        ParsedRule rule = null;
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            if ("Defined rules:".equals(line)) {
                version11 = true;
                continue;
            }
            if (line.startsWith("----") && (rule != null)) {
                // process finished rule
                if (repos != null) {
                    rule.toRule(repos);
                }
                retval.add(rule);
                rule = null;
            } else if (line.startsWith("Rule:")) {
                // start new rule
                rule = version11 ? new ParsedRule11() : new ParsedRule12();
            }
            if (rule != null) {
                rule.digest(line);
            }
        }
        return retval;
    }
}
