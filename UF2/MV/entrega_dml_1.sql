/* *****************************************************
//  INS JOAN D'AUSTRIA
//	CFGS DAM
//	M2: Bases de dades. UF2: Llenguatge SQL
//	LLIURAMENT DML 1
//	AUTOR/A:  Ariadna Aldeguer Ruiz
//	DATA:  08/02/2021
****************************************************** */

/* EXERCICI 26 */

UPDATE Empleats
set Codi_proj=NULL
where Codi_empl=6;

/* EXERCICI 27 */

UPDATE Projectes
set Data_prev_fi='1997-03-15'
where Codi_proj=3;

-- Dona un error de check, la data prevista de fi ha de ser posterior a la d'inici

UPDATE Projectes
set Data_fi='1997-03-15'
where Codi_proj=3;

-- En canvi, si canvio la data-fi, no dona cap error. (Creec que falta una restricció)

/* EXERCICI 28 */

UPDATE Projectes
set Data_prev_fi='1999-03-15'
where Codi_proj=3;

UPDATE Projectes
set Data_fi='1999-03-15'
where Codi_proj=3;

--(No se quines de les dues s'hauria de modificar)

/* EXERCICI 29 */

UPDATE Projectes
set preu= preu+preu*0.1
where Codi_proj=4;


/* EXERCICI 30 */

UPDATE Empleats
set Nom_dpt="DIR", Ciutat_dpt="Lleida"
where Codi_empl=2;

-- No hi ha un dept DIR associat a la ciutat Lleida. Error en la foreign key. 

/* EXERCICI 31 */

SELECT * FROM Empleats;

/* EXERCICI 32 */

SELECT Codi_empl, Nom_empl FROM Empleats;

/* EXERCICI 33 */

SELECT * FROM Empleats where sou>1500;

/* EXERCICI 34 */

SELECT Nom_dpt, Telefon FROM departaments;