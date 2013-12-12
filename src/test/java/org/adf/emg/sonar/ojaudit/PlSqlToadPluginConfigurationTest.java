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


public class PlSqlToadPluginConfigurationTest {

//  @Rule
//  public TemporaryFolder temporaryFolder = new TemporaryFolder();
//
//  @Rule
//  public ExpectedException thrown = ExpectedException.none();
//
//  @Test
//  public void getToadOutputDirectoryWithNullProject() throws Exception {
//    thrown.expect(NullPointerException.class);
//    thrown.expectMessage("This method is not available from the server side");
//
//    new PlSqlToadPluginConfiguration(new Settings(), null).getToadOutputDirectory();
//  }
//
//  @Test
//  public void getToadOutputDirectory() throws Exception {
//    Project project = mock(Project.class);
//    ProjectFileSystem projectFileSystem = mock(ProjectFileSystem.class);
//    when(project.getFileSystem()).thenReturn(projectFileSystem);
//    when(projectFileSystem.getSonarWorkingDirectory()).thenReturn(temporaryFolder.getRoot());
//
//    File expectedToadOutputDirectory = new File(temporaryFolder.getRoot(), "toad");
//
//    PlSqlToadPluginConfiguration pluginConf = new PlSqlToadPluginConfiguration(new Settings(), project);
//    assertThat(pluginConf.getToadOutputDirectory()).isEqualTo(expectedToadOutputDirectory);
//    assertThat(pluginConf.getToadOutputDirectory()).isEqualTo(expectedToadOutputDirectory);
//  }
//
//  @Test
//  public void getToadExePath() throws Exception {
//    String toad1ExePath = new File(PlSqlToadPluginConfigurationTest.class.getResource("/PlSqlToadPluginConfiguration/toad1.txt").toURI()).getAbsolutePath();
//    String toad2ExePath = new File(PlSqlToadPluginConfigurationTest.class.getResource("/PlSqlToadPluginConfiguration/toad2.txt").toURI()).getAbsolutePath();
//
//    Settings settings = new Settings();
//    assertThat(new PlSqlToadPluginConfiguration(settings).getToadExePath()).isEqualTo("");
//
//    settings = new Settings();
//    settings.setProperty("sonar.plsql.toad.exePath", toad1ExePath);
//    assertThat(new PlSqlToadPluginConfiguration(settings).getToadExePath()).isEqualTo(toad1ExePath);
//
//    settings = new Settings();
//    settings.setProperty("sonar.toad.exe", toad2ExePath);
//    assertThat(new PlSqlToadPluginConfiguration(settings).getToadExePath()).isEqualTo(toad2ExePath);
//
//    settings = new Settings();
//    settings.setProperty("sonar.plsql.toad.exePath", toad2ExePath);
//    settings.setProperty("sonar.toad.exe", toad1ExePath);
//    assertThat(new PlSqlToadPluginConfiguration(settings).getToadExePath()).isEqualTo(toad2ExePath);
//  }
//
//  @Test
//  public void getToadExePathInvalidFile() throws Exception {
//    String invalidFile = new File(PlSqlToadPluginConfigurationTest.class.getResource("/PlSqlToadPluginConfiguration/").toURI()).getAbsolutePath();
//
//    thrown.expect(IllegalArgumentException.class);
//    thrown.expectMessage("The Toad executable path property \"" + invalidFile + "\" does not point to a valid file");
//
//    Settings settings = new Settings();
//    settings.setProperty("sonar.plsql.toad.exePath", invalidFile);
//    new PlSqlToadPluginConfiguration(settings).getToadExePath();
//  }
//
//  @Test
//  public void getToad10Login() {
//    Settings settings = new Settings();
//    assertThat(new PlSqlToadPluginConfiguration(settings).getToad10Login()).isEqualTo("");
//
//    settings = new Settings();
//    settings.setProperty("sonar.plsql.toad.login", "foo");
//    assertThat(new PlSqlToadPluginConfiguration(settings).getToad10Login()).isEqualTo("foo");
//
//    settings = new Settings();
//    settings.setProperty("sonar.toad.login", "bar");
//    assertThat(new PlSqlToadPluginConfiguration(settings).getToad10Login()).isEqualTo("bar");
//
//    settings = new Settings();
//    settings.setProperty("sonar.plsql.toad.login", "foobar");
//    settings.setProperty("sonar.toad.login", "bar");
//    assertThat(new PlSqlToadPluginConfiguration(settings).getToad10Login()).isEqualTo("foobar");
//  }
//
//  @Test
//  public void getToad10Password() {
//    Settings settings = new Settings();
//    assertThat(new PlSqlToadPluginConfiguration(settings).getToad10Password()).isEqualTo("");
//
//    settings = new Settings();
//    settings.setProperty("sonar.plsql.toad.password", "foo");
//    assertThat(new PlSqlToadPluginConfiguration(settings).getToad10Password()).isEqualTo("foo");
//
//    settings = new Settings();
//    settings.setProperty("sonar.toad.password", "bar");
//    assertThat(new PlSqlToadPluginConfiguration(settings).getToad10Password()).isEqualTo("bar");
//
//    settings = new Settings();
//    settings.setProperty("sonar.plsql.toad.password", "foobar");
//    settings.setProperty("sonar.toad.password", "bar");
//    assertThat(new PlSqlToadPluginConfiguration(settings).getToad10Password()).isEqualTo("foobar");
//  }
//
//  @Test
//  public void hasToad10Credentials() {
//    Settings settings = new Settings();
//    assertThat(new PlSqlToadPluginConfiguration(settings).hasToad10Credentials()).isEqualTo(false);
//
//    settings = new Settings();
//    settings.setProperty("sonar.plsql.toad.login", "foo");
//    assertThat(new PlSqlToadPluginConfiguration(settings).hasToad10Credentials()).isEqualTo(true);
//
//    settings = new Settings();
//    settings.setProperty("sonar.toad.login", "foo");
//    assertThat(new PlSqlToadPluginConfiguration(settings).hasToad10Credentials()).isEqualTo(true);
//  }
//
//  @Test
//  public void getToadTimeout() {
//    Settings settings = new Settings();
//    assertThat(new PlSqlToadPluginConfiguration(settings).getToadTimeout()).isEqualTo(0);
//
//    settings = new Settings();
//    settings.setProperty("sonar.plsql.toad.timeout", "1");
//    assertThat(new PlSqlToadPluginConfiguration(settings).getToadTimeout()).isEqualTo(1);
//
//    settings = new Settings();
//    settings.setProperty("sonarsource.plsql.toadTimeoutSeconds", "2");
//    assertThat(new PlSqlToadPluginConfiguration(settings).getToadTimeout()).isEqualTo(2);
//
//    settings = new Settings();
//    settings.setProperty("sonar.plsql.toad.timeout", "42");
//    settings.setProperty("sonarsource.plsql.toadTimeoutSeconds", "0");
//    assertThat(new PlSqlToadPluginConfiguration(settings).getToadTimeout()).isEqualTo(42);
//  }
//
//  @Test
//  public void getToadLimit() {
//    Settings settings = new Settings();
//    assertThat(new PlSqlToadPluginConfiguration(settings).getToadLimit()).isEqualTo(0);
//
//    settings = new Settings();
//    settings.setProperty("sonar.plsql.toad.limit", "1");
//    assertThat(new PlSqlToadPluginConfiguration(settings).getToadLimit()).isEqualTo(1);
//
//    settings = new Settings();
//    settings.setProperty("sonar.toad.limit", "2");
//    assertThat(new PlSqlToadPluginConfiguration(settings).getToadLimit()).isEqualTo(2);
//
//    settings = new Settings();
//    settings.setProperty("sonar.plsql.toad.limit", "42");
//    settings.setProperty("sonar.toad.limit", "0");
//    assertThat(new PlSqlToadPluginConfiguration(settings).getToadLimit()).isEqualTo(42);
//  }

}
