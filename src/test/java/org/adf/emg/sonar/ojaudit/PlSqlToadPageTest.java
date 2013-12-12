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


public class PlSqlToadPageTest {

//  private static final String TARGET_FOLDER = "target/tmp-tests/toad/PlSqlToadPageTest/";
//
//  private RulesProfile profile;
//  private PlSqlToadPluginConfiguration pluginConf;
//
//  @Before
//  public void initMock() throws IOException {
//    pluginConf = mock(PlSqlToadPluginConfiguration.class);
//    File tmpFolder = new File(TARGET_FOLDER);
//    FileUtils.forceMkdir(tmpFolder);
//    FileUtils.cleanDirectory(tmpFolder);
//    when(pluginConf.getToadOutputDirectory()).thenReturn(tmpFolder);
//    when(pluginConf.getToad10Login()).thenReturn("myUsername@myHostname");
//    when(pluginConf.getToad10Password()).thenReturn("myPassword");
//
//    profile = mock(RulesProfile.class);
//    when(profile.getName()).thenReturn("myProfileName");
//
//    ArrayList<ActiveRule> toad10ActiveRules = new ArrayList<ActiveRule>();
//    toad10ActiveRules.add(getMockedActiveRule("1000"));
//    toad10ActiveRules.add(getMockedActiveRule("1001"));
//    when(profile.getActiveRulesByRepository(PlSqlToadPlugin.KEY_REPOSITORY_TOAD)).thenReturn(toad10ActiveRules);
//
//    ArrayList<ActiveRule> toad11ActiveRules = new ArrayList<ActiveRule>();
//    toad11ActiveRules.add(getMockedActiveRule("2000"));
//    toad11ActiveRules.add(getMockedActiveRule("2001"));
//    toad11ActiveRules.add(getMockedActiveRule("2002"));
//    toad11ActiveRules.add(getMockedActiveRule("2003"));
//    when(profile.getActiveRulesByRepository(PlSqlToadPlugin.KEY_REPOSITORY_TOAD_11)).thenReturn(toad11ActiveRules);
//  }
//
//  private static ActiveRule getMockedActiveRule(String ruleKey) {
//    ActiveRule activeRule = mock(ActiveRule.class);
//    when(activeRule.getRuleKey()).thenReturn(ruleKey);
//    return activeRule;
//  }
//
//  @Test(expected = IllegalStateException.class)
//  public void getIniFileFailsIfNotGeneratedFirstTest() {
//    PlSqlToadPage page = new PlSqlToadPage(new File[] {}, pluginConf, profile, 2);
//    page.getIniFile();
//  }
//
//  @Test
//  public void getIniFileAfterGenerateTest() {
//    PlSqlToadPage page = new PlSqlToadPage(new File[] {}, pluginConf, profile, 2);
//    page.generate();
//    assertThat(page.getIniFile(), is(new File(TARGET_FOLDER, "CodeXpert-2.ini")));
//  }
//
//  @Test
//  public void getReportFileTest() {
//    PlSqlToadPage page = new PlSqlToadPage(new File[] {}, pluginConf, profile, 5);
//    assertThat(page.getReportFile(), is(new File(TARGET_FOLDER, "CodeXpert-5.xml")));
//  }
//
//  @Test
//  public void generateIniWithCredentialsTest() throws IOException {
//    when(pluginConf.hasToad10Credentials()).thenReturn(true);
//
//    File file1 = new File("file1.sql");
//    File file2 = new File("file2.sql");
//    PlSqlToadPage page = new PlSqlToadPage(new File[] {file1, file2}, pluginConf, profile, 8);
//    page.generate();
//    InputStream in = getClass().getResourceAsStream("/PlSqlToadPage/WithCredentialsTestIni.ini");
//    try {
//      String expected = IOUtils.toString(in);
//
//      // Inject the canonical paths into the expected ini file
//      expected = StringUtils.replace(expected, "$ruleset", PlSqlToadPage.getPath(new File(pluginConf.getToadOutputDirectory(), "Sonar-8.rst")));
//      expected = StringUtils.replace(expected, "$outputDir", PlSqlToadPage.getPath(pluginConf.getToadOutputDirectory()));
//      expected = StringUtils.replace(expected, "$files", "FILE1=" + PlSqlToadPage.getPath(file1) + IOUtils.LINE_SEPARATOR_WINDOWS + "FILE2=" + PlSqlToadPage.getPath(file2)
//        + IOUtils.LINE_SEPARATOR_WINDOWS);
//
//      String actual = FileUtils.readFileToString(page.getIniFile());
//
//      assertThat(actual, is(expected));
//    } finally {
//      IOUtils.closeQuietly(in);
//    }
//  }
//
//  @Test
//  public void generateIniWithoutCredentialsTest() throws IOException {
//    when(pluginConf.hasToad10Credentials()).thenReturn(false);
//
//    File file1 = new File("file1.sql");
//    File file2 = new File("file2.sql");
//    PlSqlToadPage page = new PlSqlToadPage(new File[] {file1, file2}, pluginConf, profile, 8);
//    page.generate();
//    InputStream in = getClass().getResourceAsStream("/PlSqlToadPage/WithoutCredentialsTestIni.ini");
//    try {
//      String expected = IOUtils.toString(in);
//
//      // Inject the canonical paths into the expected ini file
//      expected = StringUtils.replace(expected, "$ruleset", PlSqlToadPage.getPath(new File(pluginConf.getToadOutputDirectory(), "Sonar-8.rst")));
//      expected = StringUtils.replace(expected, "$outputDir", PlSqlToadPage.getPath(pluginConf.getToadOutputDirectory()));
//      expected = StringUtils.replace(expected, "$files", "FILE1=" + PlSqlToadPage.getPath(file1) + IOUtils.LINE_SEPARATOR_WINDOWS + "FILE2=" + PlSqlToadPage.getPath(file2)
//        + IOUtils.LINE_SEPARATOR_WINDOWS);
//
//      String actual = FileUtils.readFileToString(page.getIniFile());
//
//      assertThat(actual, is(expected));
//    } finally {
//      IOUtils.closeQuietly(in);
//    }
//  }
//
//  @Test
//  public void generateRstTest() throws IOException {
//    PlSqlToadPage page = new PlSqlToadPage(new File[] {}, pluginConf, profile, 11);
//    page.generate();
//    InputStream in = getClass().getResourceAsStream("/PlSqlToadPage/Rst.xml");
//    try {
//      String expected = IOUtils.toString(in);
//      String actual = FileUtils.readFileToString(new File(pluginConf.getToadOutputDirectory(), "Sonar-11.rst"));
//
//      assertThat(actual, is(expected));
//    } finally {
//      IOUtils.closeQuietly(in);
//    }
//  }

}
