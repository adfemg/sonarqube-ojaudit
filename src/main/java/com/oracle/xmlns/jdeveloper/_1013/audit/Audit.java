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
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}title"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}model-count"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}violation-count"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}exception-count"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}error-count"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}warning-count"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}advisory-count"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}incomplete-count"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}locations"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}profile"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}columns"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}models"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}categories"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}rules"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}transforms"/>
 *         &lt;element ref="{http://xmlns.oracle.com/jdeveloper/1013/audit}construct"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
         "title", "modelCount", "violationCount", "exceptionCount", "errorCount", "warningCount", "advisoryCount",
         "incompleteCount", "locations", "profile", "columns", "models", "categories", "rules", "transforms",
         "construct"
    })
@XmlRootElement(name = "audit")
public class Audit {

    @XmlElement(required = true)
    protected String title;
    @XmlElement(name = "model-count", required = true)
    protected String modelCount;
    @XmlElement(name = "violation-count", required = true)
    protected String violationCount;
    @XmlElement(name = "exception-count", required = true)
    protected String exceptionCount;
    @XmlElement(name = "error-count", required = true)
    protected String errorCount;
    @XmlElement(name = "warning-count", required = true)
    protected String warningCount;
    @XmlElement(name = "advisory-count", required = true)
    protected String advisoryCount;
    @XmlElement(name = "incomplete-count", required = true)
    protected String incompleteCount;
    @XmlElement(required = true)
    protected Locations locations;
    @XmlElement(required = true)
    protected Profile profile;
    @XmlElement(required = true)
    protected Columns columns;
    @XmlElement(required = true)
    protected Models models;
    @XmlElement(required = true)
    protected Categories categories;
    @XmlElement(required = true)
    protected Rules rules;
    @XmlElement(required = true)
    protected Transforms transforms;
    @XmlElement(required = true)
    protected Construct construct;

    /**
     * Gets the value of the title property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the modelCount property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getModelCount() {
        return modelCount;
    }

    /**
     * Sets the value of the modelCount property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setModelCount(String value) {
        this.modelCount = value;
    }

    /**
     * Gets the value of the violationCount property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getViolationCount() {
        return violationCount;
    }

    /**
     * Sets the value of the violationCount property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setViolationCount(String value) {
        this.violationCount = value;
    }

    /**
     * Gets the value of the exceptionCount property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getExceptionCount() {
        return exceptionCount;
    }

    /**
     * Sets the value of the exceptionCount property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setExceptionCount(String value) {
        this.exceptionCount = value;
    }

    /**
     * Gets the value of the errorCount property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getErrorCount() {
        return errorCount;
    }

    /**
     * Sets the value of the errorCount property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setErrorCount(String value) {
        this.errorCount = value;
    }

    /**
     * Gets the value of the warningCount property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWarningCount() {
        return warningCount;
    }

    /**
     * Sets the value of the warningCount property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWarningCount(String value) {
        this.warningCount = value;
    }

    /**
     * Gets the value of the advisoryCount property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAdvisoryCount() {
        return advisoryCount;
    }

    /**
     * Sets the value of the advisoryCount property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAdvisoryCount(String value) {
        this.advisoryCount = value;
    }

    /**
     * Gets the value of the incompleteCount property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIncompleteCount() {
        return incompleteCount;
    }

    /**
     * Sets the value of the incompleteCount property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIncompleteCount(String value) {
        this.incompleteCount = value;
    }

    /**
     * Gets the value of the locations property.
     *
     * @return
     *     possible object is
     *     {@link Locations }
     *
     */
    public Locations getLocations() {
        return locations;
    }

    /**
     * Sets the value of the locations property.
     *
     * @param value
     *     allowed object is
     *     {@link Locations }
     *
     */
    public void setLocations(Locations value) {
        this.locations = value;
    }

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
     * Gets the value of the columns property.
     *
     * @return
     *     possible object is
     *     {@link Columns }
     *
     */
    public Columns getColumns() {
        return columns;
    }

    /**
     * Sets the value of the columns property.
     *
     * @param value
     *     allowed object is
     *     {@link Columns }
     *
     */
    public void setColumns(Columns value) {
        this.columns = value;
    }

    /**
     * Gets the value of the models property.
     *
     * @return
     *     possible object is
     *     {@link Models }
     *
     */
    public Models getModels() {
        return models;
    }

    /**
     * Sets the value of the models property.
     *
     * @param value
     *     allowed object is
     *     {@link Models }
     *
     */
    public void setModels(Models value) {
        this.models = value;
    }

    /**
     * Gets the value of the categories property.
     *
     * @return
     *     possible object is
     *     {@link Categories }
     *
     */
    public Categories getCategories() {
        return categories;
    }

    /**
     * Sets the value of the categories property.
     *
     * @param value
     *     allowed object is
     *     {@link Categories }
     *
     */
    public void setCategories(Categories value) {
        this.categories = value;
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

    /**
     * Gets the value of the transforms property.
     *
     * @return
     *     possible object is
     *     {@link Transforms }
     *
     */
    public Transforms getTransforms() {
        return transforms;
    }

    /**
     * Sets the value of the transforms property.
     *
     * @param value
     *     allowed object is
     *     {@link Transforms }
     *
     */
    public void setTransforms(Transforms value) {
        this.transforms = value;
    }

    /**
     * Gets the value of the construct property.
     *
     * @return
     *     possible object is
     *     {@link Construct }
     *
     */
    public Construct getConstruct() {
        return construct;
    }

    /**
     * Sets the value of the construct property.
     *
     * @param value
     *     allowed object is
     *     {@link Construct }
     *
     */
    public void setConstruct(Construct value) {
        this.construct = value;
    }

}
