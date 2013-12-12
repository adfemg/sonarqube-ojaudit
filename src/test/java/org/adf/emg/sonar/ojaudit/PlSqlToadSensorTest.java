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


public class PlSqlToadSensorTest {

//  @Test
//  public void testExecuteToadTimeout10Secs() throws Throwable {
//    assertThat(launchToadWithTimeoutAndWait(1, 6), is(true));
//    assertThat(launchToadWithTimeoutAndWait(3, 8), is(true));
//    assertThat(launchToadWithTimeoutAndWait(6, 1), is(false));
//  }
//
//  private class ToadRunnerThread extends Thread {
//
//    private final int timeoutSeconds;
//    private final Object lock = new Object();
//    private Throwable caughtThrowable = null;
//
//    public ToadRunnerThread(int timeoutSeconds) {
//      this.timeoutSeconds = timeoutSeconds;
//    }
//
//    public boolean didCatchThrowable() {
//      synchronized (lock) {
//        return caughtThrowable != null;
//      }
//    }
//
//    public Throwable getCaughtThrowable() {
//      synchronized (lock) {
//        return caughtThrowable;
//      }
//    }
//
//    @Override
//    public void run() {
//      PlSqlToadPluginConfiguration pluginConf = mock(PlSqlToadPluginConfiguration.class);
//      when(pluginConf.getToadTimeout()).thenReturn(timeoutSeconds);
//      when(pluginConf.getToadExePath()).thenReturn(getInfiniteLoopExecutableFile().getAbsolutePath());
//
//      File toadIniFile = mock(File.class);
//      when(toadIniFile.getAbsolutePath()).thenReturn("mockIniFile.ini");
//
//      PlSqlToadPage toadPage = mock(PlSqlToadPage.class);
//      when(toadPage.getIniFile()).thenReturn(toadIniFile);
//
//      PlSqlToadSensor sensor = new PlSqlToadSensor(pluginConf, mock(RulesProfile.class));
//
//      try {
//        sensor.executeToad(toadPage);
//      } catch (Throwable t) {
//        if (!(t instanceof CommandException) || !t.getMessage().startsWith("Timeout exceeded")) {
//          synchronized (lock) {
//            caughtThrowable = t;
//          }
//        }
//      }
//    }
//  }
//
//  private boolean launchToadWithTimeoutAndWait(int timeoutSeconds, int waitSeconds) throws Throwable {
//    ToadRunnerThread thread = new ToadRunnerThread(timeoutSeconds);
//
//    thread.start();
//    thread.join(waitSeconds * 1000L);
//    boolean isStopped = !thread.isAlive();
//    if (!isStopped) {
//      thread.stop(); // NOSONAR There is no global state which needs to stay consistent, so this call is fine
//    } else {
//      if (thread.didCatchThrowable()) {
//        throw thread.getCaughtThrowable();
//      }
//    }
//
//    return isStopped;
//  }
//
//  private File getInfiniteLoopExecutableFile() {
//    String extension;
//    if (SystemUtils.IS_OS_WINDOWS) {
//      extension = "bat";
//    } else {
//      extension = "sh";
//    }
//
//    return new File("src/test/resources/PlSqlToadSensor/forever." + extension);
//  }

}
