===========================
Trapelleries a Mostrat.java
===========================

Resum de trapelleries al codi de ``Mostrat.java``


Trapelleria 1. Fitxer inexistent
================================

Canvia el nom del fitxer de la línia 8 per ``inexistent.txt``. Compila
i intenta executar el programa.

L'error que genera és: ::

    $ java Mostrat
    Exception in thread "main" java.io.FileNotFoundException: inexistent.java (No such file or directory)
	at java.base/java.io.FileInputStream.open0(Native Method)
	at java.base/java.io.FileInputStream.open(FileInputStream.java:219)
	at java.base/java.io.FileInputStream.<init>(FileInputStream.java:157)
	at java.base/java.io.FileInputStream.<init>(FileInputStream.java:112)
	at java.base/java.io.FileReader.<init>(FileReader.java:60)

    
    No troba el fitxer -->  (No such file or directory)
 
Trapelleria 2. Fitxer protegit
==============================

Crea ara un fitxer anomenat ``existent.txt`` però protegeix-lo perquè
no pugui ser llegit.

Aquí tens unes instruccions que t'ajudaran: ::

    $ touch existent.txt
    $ chmod -r existent.txt


    $ java Mostrat
    
    Exception in thread "main" java.io.FileNotFoundException: existent.txt (Permission denied)
	at java.base/java.io.FileInputStream.open0(Native Method)
	at java.base/java.io.FileInputStream.open(FileInputStream.java:219)
	at java.base/java.io.FileInputStream.<init>(FileInputStream.java:157)
	at java.base/java.io.FileInputStream.<init>(FileInputStream.java:112)
	at java.base/java.io.FileReader.<init>(FileReader.java:60)

	
	Error perquè és només te permissos de llegir --> (Permission denied) 


Trapelleria 3. Un directori en comptes d'un fitxer
==================================================

Canvia el nom de ``inexistent.txt`` per ``/tmp``. Compila i torna a
intentar executar-ho i copia aquí el que et genera: ::

    $ java Mostrat
    Exception in thread "main" java.io.FileNotFoundException: /tmp (Is a directory)
	at java.base/java.io.FileInputStream.open0(Native Method)
	at java.base/java.io.FileInputStream.open(FileInputStream.java:219)
	at java.base/java.io.FileInputStream.<init>(FileInputStream.java:157)
	at java.base/java.io.FileInputStream.<init>(FileInputStream.java:112)
	at java.base/java.io.FileReader.<init>(FileReader.java:60)
	at Mostrat.main(Mostrat.java:12)
	
	Error perquè és un directori, no un fitxer. --> (Is a directory)
 
