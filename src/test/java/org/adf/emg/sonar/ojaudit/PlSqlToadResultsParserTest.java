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


public class PlSqlToadResultsParserTest {

//  @Rule
//  public ExpectedException thrown = ExpectedException.none();
//
//  @Test
//  public void reportNoViolationsWhenNoActiveRuleTest() throws Exception {
//    SensorContext context = mock(SensorContext.class);
//    RulesProfile profile = mock(RulesProfile.class);
//
//    PlSqlToadResultsParser resultParser = new PlSqlToadResultsParser(mockProjectWithEncoding("UTF-8"), context, profile);
//
//    resultParser.parse(mockPlSqlToadPage("/PlSqlToadResultsParser/toad11.xml"));
//
//    verify(context, never()).saveViolation(Mockito.any(Violation.class));
//  }
//
//  @Test
//  public void reportToad10ViolationsTest() throws Exception {
//    SensorContext context = mock(SensorContext.class);
//    RulesProfile profile = mock(RulesProfile.class);
//
//    when(profile.getActiveRule(PlSqlToadPlugin.KEY_REPOSITORY_TOAD, "5004")).thenReturn(mock(ActiveRule.class));
//    when(profile.getActiveRule(PlSqlToadPlugin.KEY_REPOSITORY_TOAD, "5603")).thenReturn(mock(ActiveRule.class));
//
//    PlSqlToadResultsParser resultParser = new PlSqlToadResultsParser(mockProjectWithEncoding("UTF-8"), context, profile);
//
//    resultParser.parse(mockPlSqlToadPage("/PlSqlToadResultsParser/toad10.xml"));
//
//    verify(context, times(2)).saveViolation(Mockito.any(Violation.class));
//
//    verify(context).saveViolation(argThat(new IsViolation(null, "Use of NULL statements.", null, 12)));
//    verify(context)
//        .saveViolation(argThat(new IsViolation(null, "Ensure locally defined procedures or functions are referenced.", null, 4)));
//  }
//
//  @Test
//  public void reportToad11ViolationsTest() throws Exception {
//    SensorContext context = mock(SensorContext.class);
//    RulesProfile profile = mock(RulesProfile.class);
//
//    when(profile.getActiveRule(PlSqlToadPlugin.KEY_REPOSITORY_TOAD, "5004")).thenReturn(mock(ActiveRule.class));
//    when(profile.getActiveRule(PlSqlToadPlugin.KEY_REPOSITORY_TOAD, "2007")).thenReturn(mock(ActiveRule.class));
//
//    PlSqlToadResultsParser resultParser = new PlSqlToadResultsParser(mockProjectWithEncoding("UTF-8"), context, profile);
//
//    resultParser.parse(mockPlSqlToadPage("/PlSqlToadResultsParser/toad11.xml"));
//
//    verify(context, times(2)).saveViolation(Mockito.any(Violation.class));
//
//    verify(context).saveViolation(argThat(new IsViolation(null, "Use of NULL statements.", null, 12)));
//    verify(context).saveViolation(argThat(new IsViolation(null, "Avoid direct calls to DBMS_OUTPUT.PUT_LINE.", null, 9)));
//  }
//
//  @Test
//  public void corruptedXmlFileTest() throws Exception {
//    thrown.expect(PlSqlToadException.class);
//    thrown.expectMessage("Unexpected '<' character in element (missing closing '>'?)");
//    thrown.expectMessage("at [row,col {unknown-source}]: [3,1]");
//
//    PlSqlToadResultsParser resultParser = new PlSqlToadResultsParser(mockProjectWithEncoding("UTF-8"), mock(SensorContext.class), mock(RulesProfile.class));
//
//    resultParser.parse(mockPlSqlToadPage("/PlSqlToadResultsParser/corrupted.xml"));
//  }
//
//  @Test
//  public void should_not_fail_with_bad_encoding() throws Exception {
//    PlSqlToadResultsParser resultParser = new PlSqlToadResultsParser(mockProjectWithEncoding("UTF-8"), mock(SensorContext.class), mock(RulesProfile.class));
//
//    resultParser.parse(mockPlSqlToadPage("/PlSqlToadResultsParser/encoding.xml"));
//  }
//
//  @Test
//  public void should_not_set_line_on_0_or_negative_linenum() throws Exception {
//    SensorContext context = mock(SensorContext.class);
//    RulesProfile profile = mock(RulesProfile.class);
//
//    when(profile.getActiveRule(PlSqlToadPlugin.KEY_REPOSITORY_TOAD, "6802")).thenReturn(mock(ActiveRule.class));
//
//    PlSqlToadResultsParser resultParser = new PlSqlToadResultsParser(mockProjectWithEncoding("UTF-8"), context, profile);
//
//    resultParser.parse(mockPlSqlToadPage("/PlSqlToadResultsParser/bad_linenum.xml"));
//
//    verify(context).saveViolation(Mockito.any(Violation.class));
//
//    verify(context).saveViolation(argThat(new IsViolation(null, "Avoid coding program units too long.", null, null)));
//  }
//
//  @Test
//  public void goodEncodingTest() throws Exception {
//    PlSqlToadResultsParser resultParser = new PlSqlToadResultsParser(mockProjectWithEncoding("ISO-8859-15"), mock(SensorContext.class),
//        mock(RulesProfile.class));
//
//    resultParser.parse(mockPlSqlToadPage("/PlSqlToadResultsParser/encoding.xml"));
//  }
//
//  private PlSqlToadPage mockPlSqlToadPage(String resourcePath) throws Exception {
//    PlSqlToadPage page = mock(PlSqlToadPage.class);
//    when(page.getReportFile()).thenReturn(
//        new File(PlSqlToadResultsParserTest.class.getResource(resourcePath).toURI()));
//
//    return page;
//  }
//
//  private Project mockProjectWithEncoding(String charset) {
//    Project project = mock(Project.class);
//    ProjectFileSystem projectFileSystem = mock(ProjectFileSystem.class);
//    when(projectFileSystem.getSourceCharset()).thenReturn(Charset.forName(charset));
//    when(project.getFileSystem()).thenReturn(projectFileSystem);
//
//    return project;
//  }

}
