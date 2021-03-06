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

import java.util.List;

import org.sonar.api.profiles.ProfileDefinition;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.rules.Rule;
import org.sonar.api.utils.ValidationMessages;

/**
 * Defines a default profile which is automatically registered during sonar startup.
 * @author Wilfred van der Deijl
 */
public final class DefaultProfile extends ProfileDefinition {

    private final RulesRepository repos;

    /**
     * Constructor.
     * @param repos Our RulesRepository which contains all rules to activate
     */
    public DefaultProfile(RulesRepository repos) {
        this.repos = repos;
    }

    /**
     * Creates the profile by simply adding all rules from the repository.
     * @param validationMessages not really sure that this is
     * @return created default RulesProfile
     */
    @Override
    public RulesProfile createProfile(ValidationMessages validationMessages) {
        RulesProfile retval = RulesProfile.create(OJAuditPlugin.SONAR_PROFILE_KEY, OJAuditPlugin.LANGUAGE_KEY);
        // activate all rules from our Repository for our Profile
        List<Rule> rules = repos.createRules();
        for (Rule rule : rules) {
            retval.activateRule(rule, null /* use default priority */);
        }
        return retval;
    }

}
