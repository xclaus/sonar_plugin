       IDENTIFICATION DIVISION.
       PROGRAM-ID. HELLO.
       
       DATA DIVISION.
          WORKING-STORAGE SECTION.
          01 WS-A PIC 9 VALUE 2.
          
       PROCEDURE DIVISION.
          A-PARA.
          DISPLAY 'IN A-PARA'
          GO TO B-PARA.  *> Noncompliant {{Existe un GO TO en el codigo.}}
          
          B-PARA.
          DISPLAY 'IN B-PARA '.
          GO TO C-PARA D-PARA DEPENDING ON WS-A. *> Noncompliant {{Existe un GO TO en el codigo.}}
          
          C-PARA.
          DISPLAY 'IN C-PARA '.
          
          D-PARA.
          DISPLAY 'IN D-PARA '.
          STOP RUN.