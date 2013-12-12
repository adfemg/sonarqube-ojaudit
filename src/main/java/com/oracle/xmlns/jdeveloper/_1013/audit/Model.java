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
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}file" minOccurs="0"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}package" minOccurs="0"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}project" minOccurs="0"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}workspace" minOccurs="0"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}label"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "file", "_package", "project", "workspace", "label" })
@XmlRootElement(name = "model")
public class Model {

    protected File file;
    @XmlElement(name = "package")
    protected String _package;
    protected Project project;
    protected Workspace workspace;
    @XmlElement(required = true)
    protected String label;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Gets the value of the file property.
     *
     * @return
     *     possible object is
     *     {@link File }
     *
     */
    public File getFile() {
        return file;
    }

    /**
     * Sets the value of the file property.
     *
     * @param value
     *     allowed object is
     *     {@link File }
     *
     */
    public void setFile(File value) {
        this.file = value;
    }

    /**
     * Gets the value of the package property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPackage() {
        return _package;
    }

    /**
     * Sets the value of the package property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPackage(String value) {
        this._package = value;
    }

    /**
     * Gets the value of the project property.
     *
     * @return
     *     possible object is
     *     {@link Project }
     *
     */
    public Project getProject() {
        return project;
    }

    /**
     * Sets the value of the project property.
     *
     * @param value
     *     allowed object is
     *     {@link Project }
     *
     */
    public void setProject(Project value) {
        this.project = value;
    }

    /**
     * Gets the value of the workspace property.
     *
     * @return
     *     possible object is
     *     {@link Workspace }
     *
     */
    public Workspace getWorkspace() {
        return workspace;
    }

    /**
     * Sets the value of the workspace property.
     *
     * @param value
     *     allowed object is
     *     {@link Workspace }
     *
     */
    public void setWorkspace(Workspace value) {
        this.workspace = value;
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

}
