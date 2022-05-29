/* *****************************************************
//  INS JOAN D'AUSTRIA
//	CFGS DAM
//	M2: Bases de dades. UF2: Llenguatge SQL
//	PRĂ€CTICA UF2. FASE 1
//	AUTOR/A:  Ariadna Aldeguer Ruiz
//	DATA:  15/01/2021
****************************************************** */


/* Esborrar taules existents */

DROP TABLE IF EXISTS Estadisticas;
DROP TABLE IF EXISTS Equipo; 
DROP TABLE IF EXISTS Jugador;  
DROP TABLE IF EXISTS Partido;


/* Creacio taula equipo */

CREATE TABLE Equipo(
	Nombre varchar(20) NOT NULL,
	Ciudad varchar(20) NOT NULL,
	Conferencia enum('East', 'West') NOT NULL,
	Division enum('Atlantic', 'Central', 'SouthEast', 'NorthWest', 'Pacific', 'SouthWest') NOT NULL
);

/* Creacio taula Jugador */

CREATE TABLE Jugador(
	Codigo mediumint NOT NULL, 
	Nombre varchar(30) NOT NULL,
	Procedencia varchar(20),
	Altura varchar(4),
	Peso smallint UNSIGNED,
	Posicion varchar(5),
	Nombre_Equipo varchar(20)
);

/* Creacio taula Estadisticas */

CREATE TABLE Estadisticas(
	Codigo mediumint NOT NULL,
	Temporada char(5) NOT NULL,
	Puntos_por_partido float (3,1) UNSIGNED DEFAULT 0, 
	Asistencias_por_partido float (3,1) UNSIGNED DEFAULT 0, 
	Tapones_por_partido float (3,1) UNSIGNED DEFAULT 0, 
	Rebotes_por_partido float (3,1) UNSIGNED DEFAULT 0
	);
	
/* Creacio taula Partido */

CREATE TABLE Partido(
	Equipo_local varchar(20) NOT NULL,
	Equipo_visitante varchar(20) NOT NULL,
	Codigo mediumint UNSIGNED NOT NULL, 
	Puntos_local mediumint,  
	Puntos_visitante mediumint,
	Temporada char(5)
	);


	
	
