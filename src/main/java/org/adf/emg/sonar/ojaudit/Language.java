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

import org.sonar.api.resources.AbstractLanguage;


/**
 * ojaudit analysis requires its own language so all files are processed.
 * @author Wilfred van der Deijl
 */
public class Language extends AbstractLanguage {

    /**
     * Default constructor.
     */
    public Language() {
        super(OJAuditPlugin.LANGUAGE_KEY, OJAuditPlugin.LANGUAGE_NAME);
    }

    /**
     * Returns empty list of file-suffixes so all files are included in the analysis.
     * @return empty array
     */
    @Override
    public String[] getFileSuffixes() {
        // consider all files as sources
        String[] allFiles = { "*" };
        return allFiles;
    }
}
