package com.everis.cobol.bcoestado.programas.nuevos;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.sonar.sslr.api.AstNode;
import com.sonar.sslr.api.AstNodeType;
import com.sonar.sslr.api.Token;
import com.sonarsource.cobol.api.CobolKeyword;
import com.sonarsource.cobol.api.ast.CobolCheck;

/**
 * This is an example to demonstrate how to write a custom rule which raises issues on
 * CALL statements which target forbidden programs.
 */
@Rule(
  key = "GoToCallRule",
  name = "You must not use the GO TO instruction in new developments",
  priority = Priority.CRITICAL,
  tags = {"bug"})
public class GoToCallRule extends CobolCheck {

  @Override
  public void init() {
	  subscribeTo(getCobolGrammar().gotoStatement);
  }

  @Override
  public void visitNode(AstNode nodo) {
	// Se declara el nodo  
	 AstNode localAstNode = nodo.getFirstChild(new AstNodeType[] { CobolKeyword.TO });
	 if (localAstNode != null) {
		 Token go = nodo.getToken();
		 Token to = localAstNode.getToken();
		 
		 String gto = go.getValue().concat(" ").concat(to.getValue());
		 System.out.println(gto);
		 
		 // Verifico que no este declarada la instruccion GOTO
		 if (gto != null && gto.length() > 0) {
			 // lanzo la regla
			 reportIssue("Existe un GO TO en el codigo.").on(nodo.getToken());
		 }
		 
	 }
    
  }

}
