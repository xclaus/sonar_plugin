/*
 * Copyright (C) 2009-2016 SonarSource SA
 * All rights reserved
 * mailto:contact AT sonarsource DOT com
 */
package com.everis.cobol.bcoestado.programas.nuevos;

import com.everis.cobol.bcoestado.programas.nuevos.GoToCallRule;
import com.sonarsource.cobol.testing.checks.CobolCheckVerifier;

import java.io.File;

import org.junit.Test;

public class GoToCallRuleTest {

  @Test
  public void testVisitNode() {
	GoToCallRule check = new GoToCallRule();
    CobolCheckVerifier.verify(
      new File("src/test/resources/checks/SRC/GoToCallRule.cbl"),
      check);
  }

}
