CREATE TABLE t1 (
	dni char(10),
	nom varchar(100),
	edat tinyint UNSIGNED,
    sexe char(1),
	sou float(10,2),
	email varchar(100),
	telefon char(13),  
	es_estudiant tinyint
);

CREATE TABLE t2 (
	num smallint,
	tipus enum('doble','triple','suite')
);
CREATE TABLE t4(
	num smallint primary key,
	tipus enum('doble','triple','suite')
);
CREATE TABLE t5(
	codi int PRIMARY KEY AUTO_INCREMENT,
	model varchar(20) NOT NULL,
	marca varchar(20) NOT NULL,
	matricula char(7) UNIQUE NOT NULL,
	bastidor char(17) UNIQUE, 
	color varchar(20)
);
CREATE TABLE t6(
	nomHotel varchar(20) KEY,
	numHabitacio smallint,
	tipus enum('doble','triple','suite')
);
ALTER TABLE t2 ADD metres int; --añadir columna
ALTER TABLE t2 ADD te_nevera tinyint AFTER tipus;

ALTER TABLE t2 DROP te_nevera; --borrar columna

 
ALTER TABLE t8 MODIFY nombre varchar(50); -- cambiar la definicion de la variable



