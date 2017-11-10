CREATE DATABASE aerolinea;
USE aerolinea;

CREATE TABLE aerolinea(
	id integer auto_increment not null,
	nombre varchar(30) not null,

	PRIMARY KEY (id)
);

CREATE TABLE vuelo(
	id integer auto_increment not null,
	destino varchar(15) not null,
	fecha date not null,
	cantidad integer not null,
	promo integer not null,
	econo integer not null,
	flexi integer not null,
	id_aerolinea integer not  null,
	img varchar(30),

	PRIMARY KEY(id),
	FOREIGN KEY(id_aerolinea) REFERENCES aerolinea (id)
);

CREATE TABLE pasaje(
	id integer auto_increment not null,
	valor double not null,
	pasajero varchar(30) not null,
	tipo integer not null,
	id_vuelo integer not null,

	PRIMARY KEY (id),
	FOREIGN KEY (id_vuelo) REFERENCES vuelo (id)
);

INSERT INTO aerolinea (nombre) VALUE ('JEAV´s Airways');
INSERT INTO vuelo(destino,fecha, cantidad, promo, econo, flexi, id_aerolinea,img) VALUES ('Londres',curdate(), 50, 15, 15, 20,1,'images/lndn.jpg'),('Maldivas',curdate(), 80, 28, 20, 40,1,'images/mdv.jpg'),('Venecia','2016-06-5', 20, 6, 6, 8,1,'images/vnca.jpg'),('Barcelona','2016-06-15', 40, 8, 10, 22,1,'images/ban_img1.jpg'),('Goa','2016-06-20', 30, 6, 7, 27,1,'images/ban_img2.jpg'),('Moscu','2016-07-5', 50, 12, 15, 23,1,'images/page3_img2.jpg'),('Nueva Zelanda','2016-07-15', 20, 5, 6, 9,1,'images/page2_img1.jpg'),('Francia','2016-06-25', 60, 15, 10, 35,1,'images/page2_img3.jpg'),('Canada','2016-06-2', 20, 4, 4, 12,1,'images/page2_img4.jpg'),('Turquia','2016-06-9', 30, 5, 10, 15,1,'images/page2_img5.jpg'),('Egipto','2016-06-10', 20, 6, 6, 8,1,'images/page2_img6.jpg'); 

INSERT INTO pasaje (valor,pasajero,tipo,id_vuelo) VALUES (1000,'Andres M',1,1),(1500,'Carla A.',2,1),(1000,'Miguel S',1,1),(2000,'Santiago R',3,1),(2100,'Diana P',3,1);

INSERT INTO pasaje (valor,pasajero,tipo,id_vuelo) VALUES (1100,'Sara L',1,2),(2500,'Andres M',2,2),(1100,'Pedro I',1,2),(2500,'Karen B',3,2),(2700,'Diana P',3,2);

select vuelo.id,destino,fecha,promo,econo,flexi from vuelo;
select id_vuelo,pasajero,tipo from pasaje ;

select count(pasajero) from pasaje group by tipo;
select sum(valor),tipo from pasaje group by tipo;

select vuelo.id, sum(valor) from pasaje join vuelo on (vuelo.id=pasaje.id_vuelo) group by vuelo.id;


select * from vuelo;


