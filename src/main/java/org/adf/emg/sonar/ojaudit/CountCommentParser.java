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


public class CountCommentParser {

//    private static final SAXParserFactory SAX_FACTORY;
//
//    public int countLinesOfComment(InputStream input) {
//        SAXParser parser = newSaxParser();
//        try {
//            XMLReader reader = parser.getXMLReader();
//            CommentHandler handler = new CommentHandler();
//            reader.setProperty("http://xml.org/sax/properties/lexical-handler", handler);
//            parser.parse(input, handler);
//            return handler.getNumCommentLines();
//        } catch (SAXParseException e) {
//            if (e.getLineNumber()==1 && e.getColumnNumber()==1) {
//                // error at very first character. assuming file is not XML
//                return -1;
//            }
//            throw new SonarException(e);
//        } catch (SAXException e) {
//            throw new SonarException(e);
//        } catch (IOException e) {
//            throw new SonarException(e);
//        }
//    }
//
//    private SAXParser newSaxParser() {
//        try {
//            return SAX_FACTORY.newSAXParser();
//        } catch (SAXException e) {
//            throw new SonarException(e);
//        } catch (ParserConfigurationException e) {
//            throw new SonarException(e);
//        }
//    }
//
//    static {
//        SAX_FACTORY = SAXParserFactory.newInstance();
//        SAX_FACTORY.setValidating(false);
//        SAX_FACTORY.setNamespaceAware(false);
//        try {
//            SAX_FACTORY.setFeature("http://xml.org/sax/features/validation", false);
//            SAX_FACTORY.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
//            SAX_FACTORY.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
//            SAX_FACTORY.setFeature("http://xml.org/sax/features/external-general-entities", false);
//            SAX_FACTORY.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
//        } catch (SAXException e) {
//            throw new SonarException(e);
//        } catch (ParserConfigurationException e) {
//            throw new SonarException(e);
//        }
//    }
//
//    private static class CommentHandler extends DefaultHandler2 {
//
//        private int numCommentLines = 0;
//        private Locator locator;
//        private int currentCommentLine = -1;
//
//        @Override
//        public void characters(char[] ch, int start, int length) throws SAXException {
//            super.characters(ch, start, length);
//            checkComment();
//        }
//
//        @Override
//        public void comment(char[] ch, int start, int length) throws SAXException {
//            super.comment(ch, start, length);
//            for (int i = 0; i < length; i++) {
//                if (ch[start + i] == '\n') {
//                    numCommentLines++;
//                }
//                currentCommentLine = locator.getLineNumber();
//            }
//        }
//
//        @Override
//        public void startElement(String uri, String localName, String qName,
//                                 Attributes attributes) throws SAXException {
//            super.startElement(uri, localName, qName, attributes);
//            checkComment();
//        }
//
//        @Override
//        public void setDocumentLocator(Locator locator) {
//            this.locator = locator;
//            super.setDocumentLocator(locator);
//        }
//
//        public int getNumCommentLines() {
//            return numCommentLines;
//        }
//
//        private void checkComment() {
//            if (currentCommentLine >= 0 && locator.getLineNumber() > currentCommentLine) {
//                numCommentLines++;
//                currentCommentLine = -1;
//            }
//        }
//
//    }

}
