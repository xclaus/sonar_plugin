/*
 * Copyright (C) 2009-2016 SonarSource SA
 * All rights reserved
 * mailto:contact AT sonarsource DOT com
 */
package com.everis.cobol.bcoestado.programas.nuevos;

import java.io.File;

import org.junit.Test;

import com.sonarsource.cobol.testing.checks.CobolCheckVerifier;

public class WriteOperatorRuleTest {

  @Test
  public void testVisitNode() {
	WriteOperatorRule check = new WriteOperatorRule();
    CobolCheckVerifier.verify(
      new File("src/test/resources/checks/SRC/WriteOperatorRule.cbl"),
      check);
  }

}
