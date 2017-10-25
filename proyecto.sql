/**
*Juan Diego Ordonnez --1630494
*/

DROP TABLE if exists administrador CASCADE;
CREATE TABLE administrador(
nombre varchar(50) NOT NULL,
apellido varchar(50) NOT NULL,
cedula varchar(40) PRIMARY KEY,
contrasenna varchar(50) NOT NULL,
telefono varchar(30) NOT NULL,
email varchar(50) NOT NULL);

DROP TABLE if exists usuario CASCADE;
CREATE TABLE usuario(
nombre varchar(50) NOT NULL,
apellido varchar(50) NOT NULL,
cedula varchar(40) PRIMARY KEY,
contrasenna varchar(50) NOT NULL,
telefono varchar(30) NOT NULL,
tipo varchar(30) NOT NULL,
estado varchar(30) NOT NULL,
email varchar(50) NOT NULL);

DROP TABLE if exists sede CASCADE;
CREATE TABLE sede(
nombre varchar(50) NOT NULL,
direccion varchar(50) NOT NULL,
numero_sede integer NOT NULL,
ciudad varchar(40) NOT NULL,
PRIMARY KEY (direccion, numero_sede));

DROP TABLE if exists evento CASCADE;
CREATE TABLE evento(
nombre varchar(50) NOT NULL;
fecha date NOT NULL,
ciudad varchar(40) NOT NULL,
costo integer NOT NULL,
estado varchar(40) NOT NULL,
PRIMARY KEY (nombre, fecha));

DROP TABLE if exists pre_inscripcion CASCADE;
CREATE TABLE pre_inscripcion(
nombre_evento varchar(50) NOT NULL,
nombre_participante varchar(50) NOT NULL,
cedula varchar (30) NOT NULL,
fecha date NOT NULL,
PRIMARY KEY (nombre_evento, cedula, fecha),
FOREIGN KEY (nombre_evento) REFERENCES evento (nombre));

DROP TABLE if exists inscripcion CASCADE;
CREATE TABLE inscripcion(
nombre_evento varchar(50) NOT NULL,
nombre_participante varchar(50) NOT NULL,
cedula varchar(30) NOT NULL,
fecha date NOT NULL,
forma_pago varchar(30) NOT NULL,
valor integer NOT NULL,
PRIMARY KEY (nombre_evento, cedula, fecha),
FOREIGN KEY (nombre_evento) REFERENCES evento (nombre));

DROP TABLE if exists diploma CASCADE;
CREATE TABLE diploma(
nombre_participante varchar(50) NOT NULL,
cedula varchar(30) NOT NULL,
fecha date NOT NULL,
nombre_evento varchar(50) NOT NULL,
horas integer NOT NULL,
tipo varchar(30) NOT NULL,
PRIMARY KEY (nombre_participante, cedula, fecha),
FOREIGN KEY (nombre_evento) REFERENCES evento (nombre));

DROP TABLE if exists escarapela CASCADE;
CREATE TABLE escarapela(
nombre_participante varchar(50) NOT NULL,
cedula varchar(30) NOT NULL,
fecha date NOT NULL,
nombre_evento varchar(50) NOT NULL,
PRIMARY KEY (nombre_participante, cedula, fecha),
FOREIGN KEY (nombre_evento) REFERENCES evento (nombre));

/** para darle el formato a la fecha, para cuando se vaya insertar ese dato*/
set datestyle to 'European';

-----------------DATOS DEL SISTEMA--------------------------

/**Datos de administradores*/
INSERT INTO administrador VALUES ('juan', 'ordonnez', '1144061858', 'prueba123', '5512050', 'juan@gmail.com');

/**Datos de gerente*/
INSERT INTO usuario VALUES ('jose', 'torres', 'nuevo123', '5531417', 'gerente', 'activo', 'jose@gmail.com');

/**Datos de operador*/
INSERT INTO usuario VALUES ('ana', 'silva', 'nueva123', '5540112', 'operador', 'activo', 'ana@gmail.com');

