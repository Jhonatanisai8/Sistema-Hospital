CREATE TABLE `paciente` (
	`id_paciente` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	`nombre` VARCHAR(55) NOT NULL,
	`apellido` VARCHAR(55) NOT NULL,
	`genero` CHAR(1) NOT NULL,
	`fechaNacimiento` DATE NOT NULL,
	`ciudad` VARCHAR(55) NOT NULL,
	`id_provincia` INTEGER NOT NULL,
	`alergias` VARCHAR(60) NOT NULL,
	`peso` DOUBLE(8,2) NOT NULL,
	`altura` DOUBLE(8,2) NOT NULL,
	PRIMARY KEY(`id_paciente`)
);
SHOW TABLES;

CREATE TABLE `doctor` (
	`id_doctor` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`nombre` VARCHAR(55) NOT NULL,
	`apellido` VARCHAR(55) NOT NULL,
	`especialidad` VARCHAR(55) NOT NULL,
	PRIMARY KEY(`id_doctor`)
);


CREATE TABLE `provincia` (
	`id_provincia` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`nombre` VARCHAR(55) NOT NULL,
	PRIMARY KEY(`id_provincia`)
);


CREATE TABLE `admision` (
	`id_admision` INTEGER NOT NULL,
	`id_paciente` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`fecha_admision` DATE NOT NULL,
	`fecha_alta` DATE NOT NULL,
	`diagnostico` VARCHAR(255) NOT NULL,
	`id_doctor` INTEGER NOT NULL
);


ALTER TABLE `paciente`
ADD FOREIGN KEY(`id_provincia`) REFERENCES `provincia`(`id_provincia`)
ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE `admision`
ADD FOREIGN KEY(`id_paciente`) REFERENCES `paciente`(`id_paciente`)
ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE `admision`
ADD FOREIGN KEY(`id_doctor`) REFERENCES `doctor`(`id_doctor`)
ON UPDATE NO ACTION ON DELETE NO ACTION;