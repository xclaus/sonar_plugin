package com.everis.cobol.bcoestado.programas.nuevos;

import java.util.Iterator;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.sslr.ast.AstSelect;

import com.sonar.sslr.api.AstNode;
import com.sonar.sslr.api.AstNodeType;
import com.sonarsource.cobol.api.ast.CobolCheck;

/**
 * This is an example to demonstrate how to write a custom rule which raises issues on
 * CALL statements which target forbidden programs.
 */
@Rule(
  key = "WriteOperatorRule",
  name = "No debe usar la instrucción EXEC CICS WRITE OPERATOR, para solicitar ejecución de procesos BATCH. ",
  priority = Priority.CRITICAL,
  tags = {"bug"})
public class WriteOperatorRule extends CobolCheck {

  @Override
  public void init() {
	  subscribeTo(new AstNodeType[] { this.A.cics.cicsStatement });
  }

  @Override
  public void visitNode(AstNode nodo) {
	// Capturo el valor de options
	AstSelect option = nodo.getFirstChild().select().children(this.A.cics.cicsOption).children(this.A.cics.cicsOptionName);  
	
	// Itero el mapa obtenido
	Iterator iter = option.iterator();
	
	// recorro las opciones
	while (iter.hasNext()) {
		AstNode localAstNode = (AstNode) iter.next();
		
		// Capturo el String
		String str = localAstNode.getTokenValue();
		// Armo la cadena a validar
		String value = nodo.getTokenValue().concat(" ").concat(str);
		System.out.println(value);
		
		// HANDLE CONDITION
		if (value!= null && "WRITE OPERATOR".equals(value)) {
			reportIssue("Existe un WRITE OPERATOR en el codigo.").on(nodo.getToken());
			
		} 
	} 
	
    
  }

}
