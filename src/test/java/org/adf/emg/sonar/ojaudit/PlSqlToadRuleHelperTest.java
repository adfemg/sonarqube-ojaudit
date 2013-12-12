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


public class PlSqlToadRuleHelperTest {

//  @Test
//  public void getToadKeyReturnsNullForCustomToadRuleKey() {
//    ActiveRule activeRule = mock(ActiveRule.class);
//    when(activeRule.getRuleKey()).thenReturn("CustomToadCheck");
//
//    assertThat(PlSqlToadRuleHelper.getToadKey(activeRule), nullValue());
//  }
//
//  @Test
//  public void getToadKeyReturnsToadKeyForCustomToadRuleKey() {
//    ActiveRule activeRule = mock(ActiveRule.class);
//    when(activeRule.getRuleKey()).thenReturn("CustomToadCheck_12345");
//    when(activeRule.getParameter("toadRuleID")).thenReturn("42");
//
//    assertThat(PlSqlToadRuleHelper.getToadKey(activeRule), is("42"));
//  }
//
//  @Test
//  public void getToadKeyNotCustomRule() {
//    ActiveRule activeRule = mock(ActiveRule.class);
//    when(activeRule.getRuleKey()).thenReturn("foobar");
//
//    assertThat(PlSqlToadRuleHelper.getToadKey(activeRule), is("foobar"));
//  }
//
//  @Test
//  public void getActiveRuleLoadFromToad10() {
//    RulesProfile profile = mock(RulesProfile.class);
//    ActiveRule activeRule = mock(ActiveRule.class);
//
//    when(profile.getActiveRule(PlSqlToadPlugin.KEY_REPOSITORY_TOAD, "1000")).thenReturn(activeRule);
//
//    assertThat(PlSqlToadRuleHelper.getActiveRule(profile, "1000"), is(activeRule));
//  }
//
//  @Test
//  public void getActiveRuleLoadFromToad11() {
//    RulesProfile profile = mock(RulesProfile.class);
//    ActiveRule activeRule = mock(ActiveRule.class);
//
//    when(profile.getActiveRule(PlSqlToadPlugin.KEY_REPOSITORY_TOAD_11, "2000")).thenReturn(activeRule);
//
//    assertThat(PlSqlToadRuleHelper.getActiveRule(profile, "2000"), is(activeRule));
//  }
//
//  @Test
//  public void getActiveRuleLoadFromCustomRule() {
//    RulesProfile profile = mock(RulesProfile.class);
//
//    ActiveRule activeRuleMismatch = mock(ActiveRule.class);
//    when(activeRuleMismatch.getRuleKey()).thenReturn("CustomToadCheck_12345");
//    when(activeRuleMismatch.getParameter("toadRuleID")).thenReturn("7001");
//
//    ActiveRule activeRuleMatch = mock(ActiveRule.class);
//    when(activeRuleMatch.getRuleKey()).thenReturn("CustomToadCheck_12345");
//    when(activeRuleMatch.getParameter("toadRuleID")).thenReturn("7000");
//
//    when(profile.getActiveRules()).thenReturn(Lists.newArrayList(activeRuleMismatch, activeRuleMatch));
//
//    assertThat(PlSqlToadRuleHelper.getActiveRule(profile, "7000"), is(activeRuleMatch));
//  }

}
