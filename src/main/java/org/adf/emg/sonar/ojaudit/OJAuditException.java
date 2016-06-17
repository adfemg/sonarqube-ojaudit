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
 * Simple RuntimeException used in the ojaudit sonar plugin.
 * @author Wilfred van der Deijl
 */
public class OJAuditException extends RuntimeException {

    @SuppressWarnings("compatibility:-288391578662576620")
    private static final long serialVersionUID = 3L;

    /**
     * Creates an exception with a message and wrapping another exception.
     * @param s Message for this exception
     * @param throwable cause of this exception
     */
    public OJAuditException(String s, Throwable throwable) {
        super(s, throwable);
    }

}
