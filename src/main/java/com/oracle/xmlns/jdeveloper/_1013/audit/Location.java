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
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}offset"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}length"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}line-number"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}column-offset"/>
 *       &lt;/sequence>
 *       &lt;attribute name="model" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "offset", "length", "lineNumber", "columnOffset" })
@XmlRootElement(name = "location")
public class Location {

    @XmlElement(required = true)
    protected String offset;
    @XmlElement(required = true)
    protected String length;
    @XmlElement(name = "line-number", required = true)
    protected String lineNumber;
    @XmlElement(name = "column-offset", required = true)
    protected String columnOffset;
    @XmlAttribute(name = "model", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object model;

    /**
     * Gets the value of the offset property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOffset() {
        return offset;
    }

    /**
     * Sets the value of the offset property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOffset(String value) {
        this.offset = value;
    }

    /**
     * Gets the value of the length property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLength(String value) {
        this.length = value;
    }

    /**
     * Gets the value of the lineNumber property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLineNumber() {
        return lineNumber;
    }

    /**
     * Sets the value of the lineNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLineNumber(String value) {
        this.lineNumber = value;
    }

    /**
     * Gets the value of the columnOffset property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getColumnOffset() {
        return columnOffset;
    }

    /**
     * Sets the value of the columnOffset property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setColumnOffset(String value) {
        this.columnOffset = value;
    }

    /**
     * Gets the value of the model property.
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    public Object getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setModel(Object value) {
        this.model = value;
    }

}
