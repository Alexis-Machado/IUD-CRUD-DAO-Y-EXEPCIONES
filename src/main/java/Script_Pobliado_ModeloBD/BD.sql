/*Creción de la Base de Datos */
CREATE database iudrecursoshumanos;

/*Usar Base de Datos*/
USE iudrecursoshumanos;

/*Creación de las Diferentes Tablas de la BD*/

/*Tabla de los Diferentes Tipos de Identificaciones*/
CREATE TABLE tipos_identificaciones(
id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(60) NOT NULL,
descripcion VARCHAR(120),
PRIMARY KEY (id));

/*Tabla Estados Civiles*/
CREATE TABLE estados_civiles(
id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(60) NOT NULL,
descripcion VARCHAR(120),
PRIMARY KEY (id));

/*Tabla Primaria Funcionarios*/
CREATE TABLE funcionarios(
id INT NOT NULL AUTO_INCREMENT,
numero_identificacion VARCHAR(30) NOT NULL UNIQUE,
nombres VARCHAR(120) NOT NULL,
apellidos VARCHAR(120) NOT NULL,
sexo VARCHAR(40),
direccion VARCHAR(120) NOT NULL,
telefono VARCHAR(39),
fecha_nacimiento DATE,
fecha_creacion DATETIME DEFAULT NOW(),
fecha_actualizacion DATETIME DEFAULT NOW(),
estados_civiles_id INT NOT NULL,
tipos_identificaciones_id INT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (estados_civiles_id) REFERENCES estados_civiles(id),
FOREIGN KEY (tipos_identificaciones_id) REFERENCES tipos_identificaciones(id)
);

/*Tabla Niveles Academicos*/
CREATE TABLE niveles_educativos(
id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(120) NOT NULL,
PRIMARY KEY(id));

/*Tabla Universidades¨*/
CREATE TABLE universidades(
id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(150) NOT NULL,
PRIMARY KEY (id));

/*Tabla de Estados*/
CREATE TABLE estados(
id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(60) NOT NULL,
descripcion VARCHAR(120),
PRIMARY KEY(id));

/*Tabla Formaciones Academicas*/
CREATE TABLE formaciones_academicas(
id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(150) NOT NULL,
niveles_educativos_id INT NOT NULL,
universidades_id INT NOT NULL,
estados_id INT NOT NULL,
funcionarios_id INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (funcionarios_id) REFERENCES funcionarios(id),
FOREIGN KEY (estados_id) REFERENCES estados(id),
FOREIGN KEY (universidades_id) REFERENCES universidades(id),
FOREIGN KEY (niveles_educativos_id) REFERENCES niveles_educativos(id));

/*Tabla de Parentescos*/
CREATE TABLE parentescos(
id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(40) NOT NULL,
PRIMARY KEY (id));

/*Tabla de los Grupos Familiares*/
CREATE TABLE grupos_familiares(
id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(100) NOT NULL,
funcionarios_id INT NOT NULL,
parentescos_id INT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (funcionarios_id) REFERENCES funcionarios(id),
FOREIGN KEY (parentescos_id) REFERENCES parentescos(id));

/*Proceso de Insertar Datos "Poblado de las Tablas" */

/*Tabla Tipos de Identificaciones*/
INSERT INTO tipos_identificaciones(nombre, descripcion)
VALUES('CC', 'Cédula De Ciudadanía');
INSERT INTO tipos_identificaciones(nombre, descripcion)
VALUES('RC', 'Registro Civil');
INSERT INTO tipos_identificaciones(nombre, descripcion)
VALUES('TI', 'Tarjeta De Identidad');
INSERT INTO tipos_identificaciones(nombre, descripcion)
VALUES('CE', 'Cédula De Extranjería');
INSERT INTO tipos_identificaciones(nombre, descripcion)
VALUES('PP', 'Pasaporte');

/*Tabla Estados Civiles*/
INSERT INTO estados_civiles(nombre)
VALUES('Solter@');
INSERT INTO estados_civiles(nombre)
VALUES('Casad@');
INSERT INTO estados_civiles(nombre)
VALUES('Comprometid@');
INSERT INTO estados_civiles(nombre)
VALUES('Unión Libre');
INSERT INTO estados_civiles(nombre)
VALUES('Divorciad@');
INSERT INTO estados_civiles(nombre)
VALUES('Separad@');
INSERT INTO estados_civiles(nombre)
VALUES('Viud@');
INSERT INTO estados_civiles(nombre)
VALUES('Prefiero No Decirlo');

/*Tabla Estados*/
INSERT INTO estados(nombre)
VALUES('En Proceso');
INSERT INTO estados(nombre)
VALUES('Finalizado');
INSERT INTO estados(nombre)
VALUES('Suspendido');
INSERT INTO estados(nombre)
VALUES('Cancelado');
INSERT INTO estados(nombre)
VALUES('Pendiente');
INSERT INTO estados(nombre)
VALUES('En proceso de Aprovación');

/*Tabla de Parentescos*/
INSERT INTO parentescos(nombre)
VALUES('Prim@');
INSERT INTO parentescos(nombre)
VALUES('Herman@');
INSERT INTO parentescos(nombre)
VALUES('Madre');
INSERT INTO parentescos(nombre)
VALUES('Padre');
INSERT INTO parentescos(nombre)
VALUES('Ti@');
INSERT INTO parentescos(nombre)
VALUES('Sobrin@');
INSERT INTO parentescos(nombre)
VALUES('Abuel@');

/*Tabla de Niveles Academicos*/
INSERT INTO niveles_educativos(nombre)
VALUES('Educación Primaria');
INSERT INTO niveles_educativos(nombre)
VALUES('Bachiller Académico');
INSERT INTO niveles_educativos(nombre)
VALUES('Estudios Básicos No Culminados');
INSERT INTO niveles_educativos(nombre)
VALUES('Técnica');
INSERT INTO niveles_educativos(nombre)
VALUES('Tecnología');
INSERT INTO niveles_educativos(nombre)
VALUES('Pregrado');
INSERT INTO niveles_educativos(nombre)
VALUES('Posgradro');
INSERT INTO niveles_educativos(nombre)
VALUES('Maestría');
INSERT INTO niveles_educativos(nombre)
VALUES('Doctorado');

/*Tabla Funcionarios*/
INSERT INTO funcionarios(numero_identificacion,nombres,apellidos,sexo,direccion,telefono,fecha_nacimiento,
estados_civiles_id,tipos_identificaciones_id)
VALUES('1017143658','Pablo','Rodríguez','MASCULINO','Calle 10A #13B','3107105737','1999-05-12',3,1);

/*Tabla Universidades*/
INSERT INTO `universidades` (`id`, `nombre`) VALUES (NULL, 'IU Digital de Antioquia');

/*Tabla Formaciones Academicas*/
INSERT INTO `formaciones_academicas` (`id`, `nombre`, `niveles_educativos_id`, `universidades_id`, `estados_id`, `funcionarios_id`) VALUES (NULL, 'Tecnólogo en Desarrollo de Software', '5', '1', '1', '1');

/*Tabla Grupos de Familiares*/
INSERT INTO `grupos_familiares` (`id`, `nombre`, `funcionarios_id`, `parentescos_id`) VALUES (NULL, 'Cesar Arango García ', '1', '4');