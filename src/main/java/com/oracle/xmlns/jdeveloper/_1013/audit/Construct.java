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
import javax.xml.bind.annotation.XmlID;
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
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}type"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}kind"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}name"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}label"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}values"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}children"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="parent" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;attribute name="root" default="false">
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
@XmlType(name = "", propOrder = { "location", "type", "kind", "name", "label", "values", "children" })
@XmlRootElement(name = "construct")
public class Construct {

    @XmlElement(required = true)
    protected Location location;
    @XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
    protected String kind;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String label;
    @XmlElement(required = true)
    protected Values values;
    @XmlElement(required = true)
    protected Children children;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "parent", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object parent;
    @XmlAttribute(name = "root")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String root;

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
     * Gets the value of the type property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the kind property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getKind() {
        return kind;
    }

    /**
     * Sets the value of the kind property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setKind(String value) {
        this.kind = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the label property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLabel(String value) {
        this.label = value;
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
     * Gets the value of the children property.
     *
     * @return
     *     possible object is
     *     {@link Children }
     *
     */
    public Children getChildren() {
        return children;
    }

    /**
     * Sets the value of the children property.
     *
     * @param value
     *     allowed object is
     *     {@link Children }
     *
     */
    public void setChildren(Children value) {
        this.children = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setId(String value) {
        this.id = value;
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
     * Gets the value of the root property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRoot() {
        if (root == null) {
            return "false";
        } else {
            return root;
        }
    }

    /**
     * Sets the value of the root property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRoot(String value) {
        this.root = value;
    }

}
