/**
*Juan Diego Ordonnez --1630494
*/


DROP TABLE if exists usuario CASCADE;
CREATE TABLE usuario(
nombre varchar(50) NOT NULL,
apellido varchar(50) NOT NULL,
cedula varchar(40) PRIMARY KEY,
nick varchar(40) NOT NULL,
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
INSERT INTO usuario VALUES ('juan', 'ordonnez', '1144061858', 'juando', 'prueba123', '5512050', 'administrador', 'activo', 'juan@gmail.com');

/**Datos de gerente*/
INSERT INTO usuario VALUES ('jose', 'torres', '124547896', 'joseto', 'nuevo123', '5531417', 'gerente', 'activo', 'jose@gmail.com');

/**Datos de operador*/
INSERT INTO usuario VALUES ('ana', 'silva', '112365478', 'anasi', 'nueva123', '5540112', 'operador', 'activo', 'ana@gmail.com');

/**Datos sede*/
INSERT INTO sede VALUES ('music del sur', 'cra 80 # 15-21', 02, 'Cali');
INSERT INTO sede VALUES ('music del norte', 'cra 25 # 22-41', 03, 'Cali');
INSERT INTO sede VALUES ('music del llano', 'calle 72 # 14-72', 04, 'Villavicencio');
INSERT INTO sede VALUES ('music del prado', 'avenida 14 # 84-10', 05, 'Buenaventura');
INSERT INTO sede VALUES ('music del lago', 'calle 1 # 54-12', 06, 'Villavicencio');
INSERT INTO sede VALUES ('music del tropical', 'avenida 4A # 35-20', 07, 'Cartagena');
INSERT INTO sede VALUES ('music de las palmas', 'cra 8 # 1-71', 08, 'Cali');
INSERT INTO sede VALUES ('music del paramo', 'calle 58 # 4-18', 09, 'Pasto');

/**Datos de evento*/
INSERT INTO evento VALUES ('mega concierto', '15-10-2017', 'Cali', 70000000, 'realizado');
INSERT INTO evento VALUES ('filarmonica', '30-10-2017', 'Bogota', 30000000, 'en proceso');
INSERT INTO evento VALUES ('orquesta', '04-07-2017', 'Manizales', 45000000, 'realizado');
INSERT INTO evento VALUES ('intrumentos de viento', '07-11-2017', 50000000, 'en proceso');

/**Datos de pre-inscripcion*/
INSERT INTO pre_inscripcion VALUES ('mega concierto', 'JULIAN BENITEZ', '31456984', '01-10-2017');
INSERT INTO pre_inscripcion VALUES ('mega concierto', 'SANTIAGO VALENCIA', '78451254', '03-10-2017');
INSERT INTO pre_inscripcion VALUES ('filarmonica', 'CAMILA GONZALES', '21875421', '12-10-2017');
INSERT INTO pre_inscripcion VALUES ('filarmonica', 'ANGIE VASQUES', '56321478', '10-10-2017');
INSERT INTO pre_inscripcion VALUES ('orquesta', 'PEDRO ARROYO', '11852963', '20-06-2017');
INSERT INTO pre_inscripcion VALUES ('orquesta', 'MARCOS TORO', '22654789', '25-06-2017');
INSERT INTO pre_inscripcion VALUES ('intrumentos de viento', 'JHON LIZARASO', '15236874', '18-10-2017');
INSERT INTO pre_inscripcion VALUES ('intrumentos de viento', 'ALEXANDRA PINARES', '12458963', '25-10-2017');