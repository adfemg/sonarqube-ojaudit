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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}location"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}message"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}values"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}transforms-applied"/>
 *       &lt;/sequence>
 *       &lt;attribute name="rule" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;attribute name="parent" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;attribute name="over-threshold" default="false">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="false"/>
 *             &lt;enumeration value="true"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "location", "message", "values", "transformsApplied" })
@XmlRootElement(name = "violation")
public class Violation {

    @XmlElement(required = true)
    protected Location location;
    @XmlElement(required = true)
    protected String message;
    @XmlElement(required = true)
    protected Values values;
    @XmlElement(name = "transforms-applied", required = true)
    protected TransformsApplied transformsApplied;
    @XmlAttribute(name = "rule", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object rule;
    @XmlAttribute(name = "parent", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object parent;
    @XmlAttribute(name = "over-threshold")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String overThreshold;

    /**
     * Gets the value of the location property.
     *
     * @return
     *     possible object is
     *     {@link Location }
     *
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     *
     * @param value
     *     allowed object is
     *     {@link Location }
     *
     */
    public void setLocation(Location value) {
        this.location = value;
    }

    /**
     * Gets the value of the message property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the values property.
     *
     * @return
     *     possible object is
     *     {@link Values }
     *
     */
    public Values getValues() {
        return values;
    }

    /**
     * Sets the value of the values property.
     *
     * @param value
     *     allowed object is
     *     {@link Values }
     *
     */
    public void setValues(Values value) {
        this.values = value;
    }

    /**
     * Gets the value of the transformsApplied property.
     *
     * @return
     *     possible object is
     *     {@link TransformsApplied }
     *
     */
    public TransformsApplied getTransformsApplied() {
        return transformsApplied;
    }

    /**
     * Sets the value of the transformsApplied property.
     *
     * @param value
     *     allowed object is
     *     {@link TransformsApplied }
     *
     */
    public void setTransformsApplied(TransformsApplied value) {
        this.transformsApplied = value;
    }

    /**
     * Gets the value of the rule property.
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    public Object getRule() {
        return rule;
    }

    /**
     * Sets the value of the rule property.
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setRule(Object value) {
        this.rule = value;
    }

    /**
     * Gets the value of the parent property.
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    public Object getParent() {
        return parent;
    }

    /**
     * Sets the value of the parent property.
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setParent(Object value) {
        this.parent = value;
    }

    /**
     * Gets the value of the overThreshold property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOverThreshold() {
        if (overThreshold == null) {
            return "false";
        } else {
            return overThreshold;
        }
    }

    /**
     * Sets the value of the overThreshold property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOverThreshold(String value) {
        this.overThreshold = value;
    }

}
