CREATE DATABASE IF NOT EXISTS parqueadero;
USE parqueadero;

CREATE TABLE IF NOT EXISTS Tarifa(
	id integer auto_increment not null,
	fechaInicio date not null,
	horaInicio time not null,
	fechaExpira date not null,
	horaExpira time not null, 
	valorMinuto double not null,
	tipo varchar(15)not null,

	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS Vehiculo(
	id integer auto_increment not null,
	placa varchar(6) not null,
	
	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS Propietario(
	id integer auto_increment not null,
	nombre varchar(30) not null,
	correo varchar(40) not null,

	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS LugarParqueo(
	id integer auto_increment not null,
	tipo varchar(15) not null,
	estado integer not null,

	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS Servicio(
	id integer auto_increment not null,
	fechaIngreso date not null,
	horaIngreso time not null,
	fechaSalida date,
	horaSalida time,
	valor double,
	placa varchar(6) not null,
	idPropietario integer,
	ubicacion integer not null,

	PRIMARY KEY(id),
	FOREIGN KEY(ubicacion) REFERENCES LugarParqueo(id)
);

INSERT INTO Tarifa(fechaInicio,horaInicio, fechaExpira, horaExpira,valorMinuto,tipo) VALUES (now()- interval 2 day,now()- interval  5 hour, now(),now()- interval 5 minute, 60,'Promo');
INSERT INTO Tarifa(fechaInicio,horaInicio, fechaExpira, horaExpira,valorMinuto,tipo) VALUES (now(),now()- interval 5 minute + interval 1 second, now()+ interval 2 day,now()+ interval 1 hour, 75,'General');
# estados = 3 (1= disponible, 2=ocupado, 3=fueraDeServicio)

INSERT INTO LugarParqueo(tipo, estado) VALUES ('General',1);
INSERT INTO LugarParqueo(tipo, estado) VALUES ('Discapacitados',1);
INSERT INTO LugarParqueo(tipo, estado) VALUES ('General',2);
INSERT INTO LugarParqueo(tipo, estado) VALUES ('General',3);
INSERT INTO LugarParqueo(tipo, estado) VALUES ('General',3);
INSERT INTO LugarParqueo(tipo, estado) VALUES ('General',3);
INSERT INTO LugarParqueo(tipo, estado) VALUES ('General',1);
INSERT INTO LugarParqueo(tipo, estado) VALUES ('General',1);
INSERT INTO LugarParqueo(tipo, estado) VALUES ('General',1);
INSERT INTO LugarParqueo(tipo, estado) VALUES ('General',1);
INSERT INTO LugarParqueo(tipo, estado) VALUES ('Discapacitados',1);
INSERT INTO LugarParqueo(tipo, estado) VALUES ('General',1);
INSERT INTO LugarParqueo(tipo, estado) VALUES ('General',1);
INSERT INTO LugarParqueo(tipo, estado) VALUES ('General',1);
INSERT INTO LugarParqueo(tipo, estado) VALUES ('General',1);
INSERT INTO LugarParqueo(tipo, estado) VALUES ('General',1);
INSERT INTO LugarParqueo(tipo, estado) VALUES ('General',1);
INSERT INTO LugarParqueo(tipo, estado) VALUES ('General',1);
INSERT INTO LugarParqueo(tipo, estado) VALUES ('General',1);
INSERT INTO LugarParqueo(tipo, estado) VALUES ('Discapacitados',1);
INSERT INTO LugarParqueo(tipo, estado) VALUES ('General',1);

INSERT INTO Vehiculo(placa) VALUES('QYZ036');

INSERT INTO Servicio(fechaIngreso, horaIngreso, placa, ubicacion, idPropietario) VALUES (now(), now()- interval 22 minute,'QYZ036',3,-1);

INSERT INTO Propietario(nombre, correo) VALUES ('Pepito Perez','pepito@perez.com');

SELECT * FROM Tarifa;
SELECT * FROM Servicio;
SELECT * FROM Vehiculo;
SELECT * FROM LugarParqueo;
SELECT * FROM Propietario;
