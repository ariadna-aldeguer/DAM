===============================================================================
**1. És un sistema que ens permet accedir des d’una base de dades relacional,**
**a un programa fet en Java.**                        
===============================================================================
AFIRMATIU. 
Normalment s'accedeix a una base de dades relacional però no es exclusiu 
d'aquestes.
===============================================================================
**2. Per a poder accedir a un SGBD concret, ens caldrà una implementació**
**adequada del JDBC, doncs JDBC per si sol només defineix interfaces i poc més.**
===============================================================================
AFIRMATIU. Si está ben implementada, será el controlador. 
===============================================================================
**3. Si els nostres programes fan servir les interfícies definides per JDBC en**
**comptes de les classes concretes dels drivers, hauria de ser raonablement** 
**fàcil canviar de SGBD sense haver de modificar els nostres programes..**
===============================================================================
JDBC és un conjunt de classes definidides per JAVA, que el driver implementa, i
si aquestes interficies están implemenetades correctament, no hi haura problema
en altres fonts de dades. 
===============================================================================
**4. Donada una implementació concreta de JDBC, coneguda com a driver, podríem **
**accedir a diverses fonts de dades, no només bases de dades.**
===============================================================================
AFIRMATIU. Sempre que les fonts de dades implementin JDBC.
===============================================================================
**5.  Amb el driver adequat, el nostre programa hauria de poder accedir a un full**
**de càlcul fent servir JDBC.**
===============================================================================
AFIRMATIU. 
