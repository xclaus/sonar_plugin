/*
 * Copyright (C) 2009-2016 SonarSource SA
 * All rights reserved
 * mailto:contact AT sonarsource DOT com
 */
package com.everis.cobol.bcoestado.programas.nuevos;

import java.io.File;

import org.junit.Test;

import com.sonarsource.cobol.testing.checks.CobolCheckVerifier;

public class HandleIgnoreRuleTest {

  @Test
  public void testVisitNode() {
	HandleIgnoreRule check = new HandleIgnoreRule();
    CobolCheckVerifier.verify(
      new File("src/test/resources/checks/SRC/HandleIgnoreRule.cbl"),
      check);
  }

}
