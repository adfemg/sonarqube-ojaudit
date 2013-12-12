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

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.oracle.xmlns.jdeveloper._1013.audit package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Package_QNAME = new QName("http://xmlns.oracle.com/jdeveloper/1013/audit", "package");
    private final static QName _LineNumber_QNAME =
        new QName("http://xmlns.oracle.com/jdeveloper/1013/audit", "line-number");
    private final static QName _ColumnOffset_QNAME =
        new QName("http://xmlns.oracle.com/jdeveloper/1013/audit", "column-offset");
    private final static QName _Severity_QNAME = new QName("http://xmlns.oracle.com/jdeveloper/1013/audit", "severity");
    private final static QName _Label_QNAME = new QName("http://xmlns.oracle.com/jdeveloper/1013/audit", "label");
    private final static QName _ExceptionCount_QNAME =
        new QName("http://xmlns.oracle.com/jdeveloper/1013/audit", "exception-count");
    private final static QName _ModelCount_QNAME =
        new QName("http://xmlns.oracle.com/jdeveloper/1013/audit", "model-count");
    private final static QName _Type_QNAME = new QName("http://xmlns.oracle.com/jdeveloper/1013/audit", "type");
    private final static QName _Kind_QNAME = new QName("http://xmlns.oracle.com/jdeveloper/1013/audit", "kind");
    private final static QName _Url_QNAME = new QName("http://xmlns.oracle.com/jdeveloper/1013/audit", "url");
    private final static QName _ViolationCount_QNAME =
        new QName("http://xmlns.oracle.com/jdeveloper/1013/audit", "violation-count");
    private final static QName _Threshold_QNAME =
        new QName("http://xmlns.oracle.com/jdeveloper/1013/audit", "threshold");
    private final static QName _WarningCount_QNAME =
        new QName("http://xmlns.oracle.com/jdeveloper/1013/audit", "warning-count");
    private final static QName _AdvisoryCount_QNAME =
        new QName("http://xmlns.oracle.com/jdeveloper/1013/audit", "advisory-count");
    private final static QName _Path_QNAME = new QName("http://xmlns.oracle.com/jdeveloper/1013/audit", "path");
    private final static QName _Length_QNAME = new QName("http://xmlns.oracle.com/jdeveloper/1013/audit", "length");
    private final static QName _IncompleteCount_QNAME =
        new QName("http://xmlns.oracle.com/jdeveloper/1013/audit", "incomplete-count");
    private final static QName _Offset_QNAME = new QName("http://xmlns.oracle.com/jdeveloper/1013/audit", "offset");
    private final static QName _Message_QNAME = new QName("http://xmlns.oracle.com/jdeveloper/1013/audit", "message");
    private final static QName _Title_QNAME = new QName("http://xmlns.oracle.com/jdeveloper/1013/audit", "title");
    private final static QName _ErrorCount_QNAME =
        new QName("http://xmlns.oracle.com/jdeveloper/1013/audit", "error-count");
    private final static QName _Description_QNAME =
        new QName("http://xmlns.oracle.com/jdeveloper/1013/audit", "description");
    private final static QName _Name_QNAME = new QName("http://xmlns.oracle.com/jdeveloper/1013/audit", "name");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.jdeveloper._1013.audit
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Model }
     *
     */
    public Model createModel() {
        return new Model();
    }

    /**
     * Create an instance of {@link File }
     *
     */
    public File createFile() {
        return new File();
    }

    /**
     * Create an instance of {@link Project }
     *
     */
    public Project createProject() {
        return new Project();
    }

    /**
     * Create an instance of {@link Workspace }
     *
     */
    public Workspace createWorkspace() {
        return new Workspace();
    }

    /**
     * Create an instance of {@link Location }
     *
     */
    public Location createLocation() {
        return new Location();
    }

    /**
     * Create an instance of {@link Columns }
     *
     */
    public Columns createColumns() {
        return new Columns();
    }

    /**
     * Create an instance of {@link Column }
     *
     */
    public Column createColumn() {
        return new Column();
    }

    /**
     * Create an instance of {@link Children }
     *
     */
    public Children createChildren() {
        return new Children();
    }

    /**
     * Create an instance of {@link Construct }
     *
     */
    public Construct createConstruct() {
        return new Construct();
    }

    /**
     * Create an instance of {@link Values }
     *
     */
    public Values createValues() {
        return new Values();
    }

    /**
     * Create an instance of {@link Value }
     *
     */
    public Value createValue() {
        return new Value();
    }

    /**
     * Create an instance of {@link Violation }
     *
     */
    public Violation createViolation() {
        return new Violation();
    }

    /**
     * Create an instance of {@link TransformsApplied }
     *
     */
    public TransformsApplied createTransformsApplied() {
        return new TransformsApplied();
    }

    /**
     * Create an instance of {@link TransformApplied }
     *
     */
    public TransformApplied createTransformApplied() {
        return new TransformApplied();
    }

    /**
     * Create an instance of {@link Transform }
     *
     */
    public Transform createTransform() {
        return new Transform();
    }

    /**
     * Create an instance of {@link Locations }
     *
     */
    public Locations createLocations() {
        return new Locations();
    }

    /**
     * Create an instance of {@link Rule }
     *
     */
    public Rule createRule() {
        return new Rule();
    }

    /**
     * Create an instance of {@link Profile }
     *
     */
    public Profile createProfile() {
        return new Profile();
    }

    /**
     * Create an instance of {@link Audit }
     *
     */
    public Audit createAudit() {
        return new Audit();
    }

    /**
     * Create an instance of {@link Models }
     *
     */
    public Models createModels() {
        return new Models();
    }

    /**
     * Create an instance of {@link Categories }
     *
     */
    public Categories createCategories() {
        return new Categories();
    }

    /**
     * Create an instance of {@link Category }
     *
     */
    public Category createCategory() {
        return new Category();
    }

    /**
     * Create an instance of {@link Rules }
     *
     */
    public Rules createRules() {
        return new Rules();
    }

    /**
     * Create an instance of {@link Transforms }
     *
     */
    public Transforms createTransforms() {
        return new Transforms();
    }

    /**
     * Create an instance of {@link AuditPrettyPrint }
     *
     */
    public AuditPrettyPrint createAuditPrettyPrint() {
        return new AuditPrettyPrint();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/jdeveloper/1013/audit", name = "package")
    public JAXBElement<String> createPackage(String value) {
        return new JAXBElement<String>(_Package_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/jdeveloper/1013/audit", name = "line-number")
    public JAXBElement<String> createLineNumber(String value) {
        return new JAXBElement<String>(_LineNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/jdeveloper/1013/audit", name = "column-offset")
    public JAXBElement<String> createColumnOffset(String value) {
        return new JAXBElement<String>(_ColumnOffset_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/jdeveloper/1013/audit", name = "severity")
    public JAXBElement<String> createSeverity(String value) {
        return new JAXBElement<String>(_Severity_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/jdeveloper/1013/audit", name = "label")
    public JAXBElement<String> createLabel(String value) {
        return new JAXBElement<String>(_Label_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/jdeveloper/1013/audit", name = "exception-count")
    public JAXBElement<String> createExceptionCount(String value) {
        return new JAXBElement<String>(_ExceptionCount_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/jdeveloper/1013/audit", name = "model-count")
    public JAXBElement<String> createModelCount(String value) {
        return new JAXBElement<String>(_ModelCount_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/jdeveloper/1013/audit", name = "type")
    public JAXBElement<String> createType(String value) {
        return new JAXBElement<String>(_Type_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/jdeveloper/1013/audit", name = "kind")
    public JAXBElement<String> createKind(String value) {
        return new JAXBElement<String>(_Kind_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/jdeveloper/1013/audit", name = "url")
    public JAXBElement<String> createUrl(String value) {
        return new JAXBElement<String>(_Url_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/jdeveloper/1013/audit", name = "violation-count")
    public JAXBElement<String> createViolationCount(String value) {
        return new JAXBElement<String>(_ViolationCount_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/jdeveloper/1013/audit", name = "threshold")
    public JAXBElement<String> createThreshold(String value) {
        return new JAXBElement<String>(_Threshold_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/jdeveloper/1013/audit", name = "warning-count")
    public JAXBElement<String> createWarningCount(String value) {
        return new JAXBElement<String>(_WarningCount_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/jdeveloper/1013/audit", name = "advisory-count")
    public JAXBElement<String> createAdvisoryCount(String value) {
        return new JAXBElement<String>(_AdvisoryCount_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/jdeveloper/1013/audit", name = "path")
    public JAXBElement<String> createPath(String value) {
        return new JAXBElement<String>(_Path_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/jdeveloper/1013/audit", name = "length")
    public JAXBElement<String> createLength(String value) {
        return new JAXBElement<String>(_Length_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/jdeveloper/1013/audit", name = "incomplete-count")
    public JAXBElement<String> createIncompleteCount(String value) {
        return new JAXBElement<String>(_IncompleteCount_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/jdeveloper/1013/audit", name = "offset")
    public JAXBElement<String> createOffset(String value) {
        return new JAXBElement<String>(_Offset_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/jdeveloper/1013/audit", name = "message")
    public JAXBElement<String> createMessage(String value) {
        return new JAXBElement<String>(_Message_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/jdeveloper/1013/audit", name = "title")
    public JAXBElement<String> createTitle(String value) {
        return new JAXBElement<String>(_Title_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/jdeveloper/1013/audit", name = "error-count")
    public JAXBElement<String> createErrorCount(String value) {
        return new JAXBElement<String>(_ErrorCount_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/jdeveloper/1013/audit", name = "description")
    public JAXBElement<String> createDescription(String value) {
        return new JAXBElement<String>(_Description_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/jdeveloper/1013/audit", name = "name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

}
