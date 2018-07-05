       IDENTIFICATION DIVISION.                                         
       PROGRAM-ID. HELLO.                                               
       PROCEDURE DIVISION.
       
       EXEC CICS HANDLE CONDITION  *> Noncompliant {{Existe un HANDLE CONDITION en el codigo.}}
          DUPKEY(X0000-DUPKEY-ERR-PARA)
          NOTFND(X000-NOT-FOUND-PARA)
          ERROR(X0000-GEN-ERR-PARA)
       END-EXEC.
       
       EXEC CICS IGNORE CONDITION LENGERR  *> Noncompliant {{Existe un IGNORE CONDITION en el codigo.}}
          DUPKEY(X0000-DUPKEY-ERR-PARA)
          NOTFND(X000-NOT-FOUND-PARA)
          ERROR(X0000-GEN-ERR-PARA)
       END-EXEC.
       X0000-DUPKEY-ERR-PARA.
       
       DISPLAY 'Duplicate Key Found'.
       X0000-NOT-FOUND-PARA.
       
       DISPLAY 'Record Not Found'.
       X0000-GEN-ERR-PARA.
       
       DISPLAY 'General Error'.