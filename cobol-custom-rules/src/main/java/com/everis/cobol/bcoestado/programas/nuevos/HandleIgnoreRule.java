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
  key = "HandleIgnoreRule",
  name = "HANDLE CONDITION and IGNORE CONDITION statements must not be used in CICS programs.",
  priority = Priority.CRITICAL,
  tags = {"bug"})
public class HandleIgnoreRule extends CobolCheck {

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
		
		// HANDLE CONDITION
		if (value!= null && "HANDLE CONDITION".equals(value)) {
			reportIssue("Existe un HANDLE CONDITION en el codigo.").on(nodo.getToken());
			
		} else if (value != null && "IGNORE CONDITION".equals(value)) {
			reportIssue("Existe un IGNORE CONDITION en el codigo.").on(nodo.getToken());
		
		}
	} 
	
    
  }

}
