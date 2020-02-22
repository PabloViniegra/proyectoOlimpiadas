-- CREACION DE TABLAS 
CREATE DATABASE MisOlimpiadas 
USE MisOlimpiadas 
CREATE TABLE Deportistas (IdDeportista int identity (1,1) CONSTRAINT pk_Deportistas PRIMARY KEY,nombre varchar(30) DEFAULT 'vacio', pais varchar (40) DEFAULT 'vacio', numMedallas int DEFAULT 0 CONSTRAINT ck_numeromedallas CHECK (numMedallas >= 0), ); 
CREATE TABLE Medallas (IdMedalla int identity (1,1) CONSTRAINT pk_Medallas PRIMARY KEY, IdDeportista int CONSTRAINT fk_idDeportista FOREIGN KEY REFERENCES Deportistas (IdDeportista), paisOlimpiada varchar (30) DEFAULT 'vacio', anio int DEFAULT 0 CONSTRAINT ck_anio CHECK (anio >1900), tipoMedalla varchar (20) DEFAULT 'vacio' CONSTRAINT ck_tipomedalla CHECK (tipoMedalla='Oro' OR tipoMedalla='Plata' OR tipoMedalla='Bronce')); 
-- FIN CREACION DE TABLAS 
-- COMIENZO DE INSERCIONES PARA Agus
INSERT INTO Deportistas (nombre,pais,numMedallas) VALUES ('Agus', 'Argentina', 2) 
INSERT INTO Medallas (paisOlimpiada,anio,tipoMedalla) VALUES ('España', '2019', 'PLATA' ) 
INSERT INTO Medallas (paisOlimpiada,anio,tipoMedalla) VALUES ('EEUU', '2018', 'BRONCE' ) 
-- FIN DE INSERCIONES PARA Agus
-- COMIENZO DE INSERCIONES PARA Pablo
INSERT INTO Deportistas (nombre,pais,numMedallas) VALUES ('Pablo', 'España', 3) 
INSERT INTO Medallas (paisOlimpiada,anio,tipoMedalla) VALUES ('1', '2010', 'ORO' ) 
INSERT INTO Medallas (paisOlimpiada,anio,tipoMedalla) VALUES ('Tokio', '2019', 'PLATA' ) 
INSERT INTO Medallas (paisOlimpiada,anio,tipoMedalla) VALUES ('EEUU', '2016', 'PLATA' ) 
-- FIN DE INSERCIONES PARA Pablo
-- CREACION DE TABLAS 
CREATE DATABASE MisOlimpiadas 
USE MisOlimpiadas 
CREATE TABLE Deportistas (IdDeportista int identity (1,1) CONSTRAINT pk_Deportistas PRIMARY KEY,nombre varchar(30) DEFAULT 'vacio', pais varchar (40) DEFAULT 'vacio', numMedallas int DEFAULT 0 CONSTRAINT ck_numeromedallas CHECK (numMedallas >= 0), ); 
CREATE TABLE Medallas (IdMedalla int identity (1,1) CONSTRAINT pk_Medallas PRIMARY KEY, IdDeportista int CONSTRAINT fk_idDeportista FOREIGN KEY REFERENCES Deportistas (IdDeportista), paisOlimpiada varchar (30) DEFAULT 'vacio', anio int DEFAULT 0 CONSTRAINT ck_anio CHECK (anio >1900), tipoMedalla varchar (20) DEFAULT 'vacio' CONSTRAINT ck_tipomedalla CHECK (tipoMedalla='Oro' OR tipoMedalla='Plata' OR tipoMedalla='Bronce')); 
-- FIN CREACION DE TABLAS 
-- CREACION DE TABLAS 
CREATE DATABASE MisOlimpiadas 
USE MisOlimpiadas 
CREATE TABLE Deportistas (IdDeportista int identity (1,1) CONSTRAINT pk_Deportistas PRIMARY KEY,nombre varchar(30) DEFAULT 'vacio', pais varchar (40) DEFAULT 'vacio', numMedallas int DEFAULT 0 CONSTRAINT ck_numeromedallas CHECK (numMedallas >= 0), ); 
CREATE TABLE Medallas (IdMedalla int identity (1,1) CONSTRAINT pk_Medallas PRIMARY KEY, IdDeportista int CONSTRAINT fk_idDeportista FOREIGN KEY REFERENCES Deportistas (IdDeportista), paisOlimpiada varchar (30) DEFAULT 'vacio', anio int DEFAULT 0 CONSTRAINT ck_anio CHECK (anio >1900), tipoMedalla varchar (20) DEFAULT 'vacio' CONSTRAINT ck_tipomedalla CHECK (tipoMedalla='Oro' OR tipoMedalla='Plata' OR tipoMedalla='Bronce')); 
-- FIN CREACION DE TABLAS 
