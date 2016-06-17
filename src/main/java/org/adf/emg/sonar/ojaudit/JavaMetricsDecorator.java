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

//import org.sonar.api.resources.ProjectFileSystem;

public class JavaMetricsDecorator /*implements Decorator*/ {

//    private static final Logger LOG = Loggers.get(XmlMetricsDecorator.class);
//
//    private static final String START_COMMENT = "/*";
//    private static final String END_COMMENT = "*/";
//
//    private static final Pattern SINGLE_LINE_COMMENT = Pattern.compile("(.*?)/\\*.*?\\*/(.*)");
//
//
//    public JavaMetricsDecorator() {
//        super();
//    }
//
//    @Override
//    public void decorate(Resource resource, DecoratorContext context) {
//        if (!(Qualifiers.isFile(resource) && resource.getName().endsWith(".java"))) {
//            // only process .java files
//            return;
//        }
//        ProjectFileSystem fileSystem = context.getProject().getFileSystem();
//        File file = lookup(resource, fileSystem);
//
//        LineIterator iterator = null;
//        int numLines = 0;
//        int numBlankLines = 0;
//        int numCommentLines = 0;
//        try {
//            Charset charset = fileSystem.getSourceCharset();
//            iterator = charset == null ? FileUtils.lineIterator(file) : FileUtils.lineIterator(file, charset.name());
//            boolean inComment = false;
//            while (iterator.hasNext()) {
//                String trimmedLine = iterator.nextLine().trim();
//                numLines++;
//                boolean lineHasCode = false;
//                boolean lineHasComment = false;
//                while (!trimmedLine.isEmpty()) {
//                    if (inComment) { // in a comment. try to find end marker
//                        int endIndex = trimmedLine.indexOf(END_COMMENT);
//                        if (endIndex == -1) { // (rest of) line is comment
//                            lineHasComment = true;
//                            trimmedLine = ""; // remove comment
//                        } else { // remove comment to see if there is code after it
//                            lineHasComment = true;
//                            trimmedLine = trimmedLine.substring(endIndex + END_COMMENT.length());
//                            inComment = false;
//                        }
//                    } else { // not in a comment
//                        if (trimmedLine.startsWith("//")) {
//                            trimmedLine = "";
//                            continue;
//                        }
//                         // try to find begin comment marker
//                        int startIndex = trimmedLine.indexOf(START_COMMENT);
//                        if (startIndex == -1) { // (rest of) line is non-comment
//                            lineHasCode = true;
//                            trimmedLine = ""; // remove non-comment
//                        } else if (startIndex == 0) { // line starts with start marker
//                            inComment = true;
//                            trimmedLine = trimmedLine.substring(startIndex + START_COMMENT.length());
//                        } else { // line contains start marker
//                            lineHasCode = true;
//                            inComment = true;
//                            trimmedLine = trimmedLine.substring(startIndex + START_COMMENT.length());
//                        }
//                    }
//                    trimmedLine = trimmedLine.trim();
//                }
//                if (!lineHasCode) {
//                    if (lineHasComment) {
//                        numCommentLines++;
//                    } else {
//                        numBlankLines++;
//                    }
//                }
//            }
//        } catch (IOException e) {
//            LOG.warn("error reading " + file + " to collect metrics", e);
//        } finally {
//            LineIterator.closeQuietly(iterator);
//        }
//
//        context.saveMeasure(CoreMetrics.LINES, (double) numLines); // Lines
//        context.saveMeasure(CoreMetrics.COMMENT_LINES, (double) numCommentLines); // Non Commenting Lines of Code
//        context.saveMeasure(CoreMetrics.NCLOC, (double) numLines - numBlankLines - numCommentLines); // Comment Lines
//    }
//
//    private File lookup(Resource resource, ProjectFileSystem filesys) {
//        return filesys.resolvePath(resource.getLongName());
//    }
//
//    /**
//     * Determines if this Sensor should run for a given project.
//     * @param project Project
//     * @return <code>true</code> if the supplied project uses ojaudit as language, otherwise <code>false</code>
//     * @see OJAuditPlugin#LANGUAGE_KEY
//     */
//    @Override
//    public boolean shouldExecuteOnProject(Project project) {
//        boolean retval = OJAuditPlugin.LANGUAGE_KEY.equals(project.getLanguageKey());
//        if (!retval) {
//            LOG.debug(this.getClass().getName() + " not executing on project with language " +
//                      project.getLanguageKey());
//        }
//        return retval;
//    }

}
