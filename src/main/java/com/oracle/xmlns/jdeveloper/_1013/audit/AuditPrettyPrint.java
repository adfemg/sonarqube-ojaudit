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
package com.oracle.xmlns.jdeveloper._1013.audit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}profile"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}rules"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "profile", "rules" })
@XmlRootElement(name = "audit-pretty-print")
public class AuditPrettyPrint {

    @XmlElement(required = true)
    protected Profile profile;
    @XmlElement(required = true)
    protected Rules rules;

    /**
     * Gets the value of the profile property.
     *
     * @return
     *     possible object is
     *     {@link Profile }
     *
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     * Sets the value of the profile property.
     *
     * @param value
     *     allowed object is
     *     {@link Profile }
     *
     */
    public void setProfile(Profile value) {
        this.profile = value;
    }

    /**
     * Gets the value of the rules property.
     *
     * @return
     *     possible object is
     *     {@link Rules }
     *
     */
    public Rules getRules() {
        return rules;
    }

    /**
     * Sets the value of the rules property.
     *
     * @param value
     *     allowed object is
     *     {@link Rules }
     *
     */
    public void setRules(Rules value) {
        this.rules = value;
    }

}
