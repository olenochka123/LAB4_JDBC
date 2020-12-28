CREATE SCHEMA IF NOT EXISTS db_jdbc_lab DEFAULT CHARACTER SET utf8;
USE db_jdbc_lab;


DROP TABLE IF EXISTS tour_has_guide;
DROP TABLE IF EXISTS tour_has_stopping_point;
DROP TABLE IF EXISTS tour_has_guide;
DROP TABLE IF EXISTS guide;
DROP TABLE IF EXISTS start_next_arrival;
DROP TABLE IF EXISTS stopping_point;
DROP TABLE IF EXISTS stopping_point;
DROP TABLE IF EXISTS tourist_destination;
DROP TABLE IF EXISTS tour;
DROP TABLE IF EXISTS hotel;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS land;
DROP TABLE IF EXISTS pedestrian;
DROP TABLE IF EXISTS bus;
DROP TABLE IF EXISTS cruise;
DROP TABLE IF EXISTS tourist;



CREATE TABLE tourist(
  id_tourist INT AUTO_INCREMENT PRIMARY KEY,
  tourist_name VARCHAR(100) NOT NULL,
  tourist_age INT NOT NULL,
  tourist_num_phone VARCHAR(45) NOT NULL UNIQUE
)ENGINE = InnoDB;


CREATE TABLE land (
  land_name VARCHAR(100) NOT NULL PRIMARY KEY
)ENGINE = InnoDB;


CREATE TABLE city (
  id_city INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  city_name VARCHAR(100) NOT NULL,
  land_name VARCHAR(100) NOT NULL,
  CONSTRAINT fk_city_land
    FOREIGN KEY (land_name)
    REFERENCES land (land_name)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)ENGINE = InnoDB;



CREATE TABLE hotel (
  id_hotel INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  hotel_name VARCHAR(100) NOT NULL,
  pay_on_day INT NOT NULL,
  class INT NOT NULL,
  id_city INT NOT NULL,
  CONSTRAINT fk_hotel_city
    FOREIGN KEY (id_city)
    REFERENCES city (id_city)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)ENGINE = InnoDB;


CREATE TABLE pedestrian (
  id_pedestrian INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  distance_KM INT NOT NULL
)ENGINE = InnoDB;


CREATE TABLE bus (
  id_bus INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  bus_name VARCHAR(45) NOT NULL
)ENGINE = InnoDB;


CREATE TABLE cruise (
  id_cruise INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  cruise_liner_name VARCHAR(45) NOT NULL
)ENGINE = InnoDB;


CREATE TABLE tour (
  id_tour INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  tour_name VARCHAR(100) NOT NULL,
  description VARCHAR(1000) NOT NULL,
  duration INT NOT NULL,
  price_one_person INT NOT NULL,
  id_pedestrian INT NULL,
  id_bus INT NULL,
  id_cruise INT NULL
)ENGINE = InnoDB;

ALTER TABLE tour
	ADD CONSTRAINT fk_tour_pedestrian
		FOREIGN KEY (id_pedestrian)
		REFERENCES pedestrian (id_pedestrian)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	ADD CONSTRAINT fk_tour_bus
		FOREIGN KEY (id_bus)
		REFERENCES bus (id_bus)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	ADD CONSTRAINT fk_tour_cruise
		FOREIGN KEY (id_cruise)
		REFERENCES cruise (id_cruise)
		ON DELETE CASCADE
		ON UPDATE CASCADE;


CREATE TABLE tourist_destination (
  id_tourist_destination INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  travel_date VARCHAR(100) NOT NULL,
  id_tourist INT NOT NULL,
  id_hotel INT NULL,
  id_tour INT NULL,
  CONSTRAINT fk_tourist_destination_tourist
    FOREIGN KEY (id_tourist)
    REFERENCES tourist (id_tourist)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_tourist_destination_hotel
    FOREIGN KEY (id_hotel)
    REFERENCES hotel (id_hotel)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_tourist_destination_tour
    FOREIGN KEY (id_tour)
    REFERENCES tour (id_tour)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE = InnoDB;



CREATE TABLE guide(
  id_guide INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  guide_name VARCHAR(100) NOT NULL,
  guide_date_work DATE NOT NULL,
  guide_num_phone VARCHAR(45) NULL UNIQUE
) ENGINE = InnoDB;



CREATE TABLE start_next_arrival (
  id_start_next_arrival INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  start_next_arrival_date VARCHAR(100) NOT NULL,
  id_tour INT NOT NULL,
  CONSTRAINT fk_start_next_arrival_tour
    FOREIGN KEY (id_tour)
    REFERENCES tour (id_tour)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)ENGINE = InnoDB;



CREATE TABLE stopping_point (
  id_stopping_point INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  stopping_point_location VARCHAR(100) NOT NULL,
  id_tour INT NOT NULL,
  CONSTRAINT fk_stopping_point_tour
    FOREIGN KEY (id_tour)
    REFERENCES tour (id_tour)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)ENGINE = InnoDB;





CREATE TABLE tour_has_stopping_point (
  id_tour INT NOT NULL,
  id_stopping_point INT NOT NULL,
  PRIMARY KEY ( id_tour, id_stopping_point),
  CONSTRAINT fk_Tour_has_stopping_point_tour
    FOREIGN KEY (id_tour)
    REFERENCES tour(id_tour)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_tour_has_stopping_point_stopping_point
    FOREIGN KEY (id_stopping_point)
    REFERENCES stopping_point (id_stopping_point)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)ENGINE = InnoDB;



CREATE TABLE  tour_has_guide (
   id_tour INT NOT NULL PRIMARY KEY,
  id_guide INT NOT NULL,
  CONSTRAINT fk_tour_has_guide_tour
    FOREIGN KEY (id_tour)
    REFERENCES tour (id_tour)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_tour_has_guide_guide
    FOREIGN KEY (id_guide)
    REFERENCES guide (id_guide)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)ENGINE = InnoDB;


CREATE INDEX index_turist ON tourist (tourist_num_phone,tourist_name ASC);
CREATE INDEX index_guide ON guide (guide_num_phone,guide_name ASC);
CREATE INDEX index_hotel ON hotel (hotel_name,class ASC);
CREATE INDEX index_tour ON tour (tour_name,price_one_person ASC);


INSERT INTO tourist (id_tourist,tourist_name,tourist_age,tourist_num_phone) VALUES
(1,'Andriy Kisa',43,'3806787649'),(2,'Vasya Poluh',54,'38067847433'),(3,'Vova Dubrovisa',32,'380672387433'),
(4,'Maks Speed',24,'380673243431'),(5,'Andriy Mogila',44,'38067187632'),(6,'Sofia Klinova',53,'38061847649'),
(7,'Katya Povich',43,'38067451649'),(8,'Illa Koblevo',59,'3806783764141'),(9,'Andriy Sos',43,'38062784349'),
(10,'Vika Soska',18,'380674334234');

INSERT INTO land VALUES
('Switzerland'),('Canada'),('Japan'),('Germany'),
('Australia'),('United Kingdom'), ('USA'),
('Sweden'),('Russia'),('Ukraine');

INSERT INTO city (id_city,city_name,land_name) VALUES
(1,'Berlin','Germany'),(2,'London','United Kingdom'),(3,'Tokyo','Japan'),
(4,'Ottawa','Canada'),(5,'New-York','USA'),(6,'Moskow','Russia'),
(7,'Odesa','Ukraine'),(8,'Bern','Switzerland'),(9,'Sidney','Australia'),
(10,'Poltava','Ukraine');

INSERT INTO hotel (id_hotel,hotel_name,pay_on_day,class,id_city) VALUES
(1,'Asdasd',1400,5,1),(2,'Bodsod',1400,5,1),(3,'Sasod',1400,5,1),
(4,'Naruto',1400,5,1),(5,'Sunduk',1400,5,1),(6,'Kanoha',1400,5,1),
(7,'Bublick',1400,5,1),(8,'Roshcha',1400,5,1),(9,'Chimigami',1400,5,1),
(10,'Testo',1400,5,1);

INSERT INTO pedestrian (id_pedestrian,distance_KM) VALUES
(1,150),(2,34),(3,45),(4,423),(5,24),(6,23),(7,76),(8,65),(9,23),(10,43);

INSERT INTO bus (id_bus,bus_name) VALUES
(1,'542'),(2,'Rock-shok'),(3,'443'),(4,'434-B'),(5,'12-A'),
(6,'53-C'),(7,'Buldog'),(8,'43-C'),(9,'86-L'),(10,'65-Y');

INSERT INTO cruise (id_cruise,cruise_liner_name) VALUES
(1,'Burgash'),(2,'Ukarsha'),(3,'Margenak'),(4,'Iksad'),
(5,'Bulvar'),(6,'Inkasat'),(7,'Kasatka'),(8,'Sobaka'),
(9,'Mishik'),(10,'Lakus');

INSERT INTO tour(id_tour,tour_name,description,duration,price_one_person,id_pedestrian,id_bus,id_cruise) VALUES
(1,'laconda','Lutsiy curort v sviti',1,343,NULL,1,NULL),
(2,'mayami','chesno chesno lutsiy!',20,1323,NULL,NULL,2),
(3,'vauch','pishki toze norm',30,200,3,NULL,NULL),
(4,'busik karapuzik','pramo v ad',7,500,NULL,4,NULL),
(5,'Ad','scrovorodka dla gresnicov',43,1003,5,NULL,NULL),
(6,'Silent-Hill','horosiy simeyniy ottid',1000000,0,NULL,6,NULL),
(7,'Silent-Hill 2','prodovzenna horosogo simeynogo otdiha',43,1003,7,NULL,NULL),
(8,'POST HUMAN','big tusovka with alkogol and girls',3,5003,NULL,NULL,8),
(9,'BURN MAN','hippi zames',14,5003,NULL,NULL,NULL),
(10,'Lodka-paravoz','',14,5003,NULL,NULL,10);

INSERT INTO tourist_destination (id_tourist_destination,travel_date,id_tourist,id_hotel,id_tour) VALUES
(1,'2020-06-22 14:05:03.000',1,10,5),(2,'2020-06-23 03:20:30.000',2,9,4),(3,'2020-07-24 05:30:30.000',3,8,3),
(4,'2020-05-23 03:20:30.000',4,7,2),(5,'2020-06-24 03:20:30.000',5,6,1),(6,'2020-06-23 12:20:30.000',6,5,6),
(7,'2020-08-23 03:30:30.000',7,4,7),(8,'2020-06-23 04:30:30.000',8,3,8),(9,'2020-06-23 12:50:30.000',9,2,10),
(10,'2020-05-22 14:30:30.000',10,1,9);

INSERT INTO stopping_point (id_stopping_point,stopping_point_location,id_tour) VALUES
(1, '31241.321412 4433.4322 54434.3242',5), (2, '124214.4124 32432.65343 12213.1241',6), (3, '4125342.253523 324253.532523 3263532.52335',7),
(4, '4124124.124421 5454523.32235 2421412.32323',8), (5, '41241242.312321 124124.421124 465434.43543',9),(6,'23142214.412124 3243124.12521 453342.3253243',10),
(7, '41321312.21554 243234234.23241 452355.4324',1), (8, '2421414.42141 3524313.43344 3536435.25242',2),(9, '2443414.42131 3532313.43234 35335.253242',3),
(10, '232144.42141 321313.43344 32335.25242',4);


INSERT INTO guide (id_guide,guide_name,guide_date_work,guide_num_phone) VALUES
(1,'Andriy Kisa','2020-06-21 19:05:03.000','380632787649'),(2,'Vasya Poluh','2020-06-12 14:05:53.000','380678417433'),
(3,'Vova Dubrovisa','2020-03-13 13:05:03.000','380641787433'),(4,'Maks Speed','2020-06-14 15:05:33.000','38063743431'),
(5,'Andriy Mogila','2020-04-12 16:05:03.000','38067287632'),(6,'Sofia Klinova','2020-06-30 13:03:33.000','380436187649'),
(7,'Katya Povich','2020-06-21 13:05:03.000','38061741649'),(8,'Illa Koblevo','2020-06-12 16:05:03.000','38067823764141'),
(9,'Andriy Sos','2020-06-12 15:05:03.000','380678214349'),(10,'Vika Soska','2020-06-15 15:33:03.000','3806742334234');


INSERT INTO tour_has_stopping_point (id_tour,id_stopping_point) VALUES
(1,10),(2,9),(3,8),(4,7),(5,6),(6,5),(7,4),(8,3),(9,2),(10,1);

INSERT INTO tour_has_guide (id_tour,id_guide) VALUES
(1,10),(2,9),(3,8),(4,7),(5,6),(6,5),(7,4),(8,3),(9,2),(10,1);


INSERT INTO start_next_arrival (id_start_next_arrival,start_next_arrival_date,id_tour) VALUES
(1,'2020-06-15 15:33:03.000',10),(2,'2020-06-16 15:33:03.000',9),(3,'2020-06-17 15:33:03.000',8),
(4,'2020-06-18 15:33:03.000',7),(5,'2020-06-19 15:33:03.000',6),(6,'2020-06-20 15:33:03.000',5),
(7,'2020-06-21 15:33:03.000',4),(8,'2020-06-22 15:33:03.000',3),(9,'2020-06-23 15:33:03.000',2),
(10,'2020-06-24 15:33:03.000',1);