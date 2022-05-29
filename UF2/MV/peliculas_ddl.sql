CREATE TABLE pelicula(
	id char(6),
	titulo varchar(70),
	anyo year(4),
	genero varchar(15)
	);
CREATE TABLE actor(
	id smallint UNSIGNED,
	nombre varchar(25)
);
CREATE TABLE participar(
	pelicula_id smallint UNSIGNED,
	actor_id smallint UNSIGNED,
	orden smallint UNSIGNED
);