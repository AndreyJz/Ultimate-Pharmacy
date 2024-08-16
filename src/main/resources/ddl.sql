DROP DATABASE IF EXISTS newPharmacy;
CREATE DATABASE newPharmacy;

USE newPharmacy;

CREATE TABLE country (
    code varchar(5) PRIMARY KEY,
    name varchar(50) NOT NULL
);

CREATE TABLE region (
    code varchar(5) PRIMARY KEY,
    name varchar(50) NOT NULL,
    codecountry varchar(5) NOT NULL,
    CONSTRAINT fk_codecountry FOREIGN KEY (codecountry) REFERENCES country(code)
);

CREATE TABLE city (
    code varchar(5) PRIMARY KEY,
    name varchar(50) NOT NULL,
    codereg varchar(5) NOT NULL,
    CONSTRAINT fk_codereg FOREIGN KEY (codereg) REFERENCES region(code)
);

CREATE TABLE modeadministration (
   id INT PRIMARY KEY AUTO_INCREMENT,
   description varchar(60) NOT NULL
);

CREATE TABLE unitmeasurement (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(50) NOT NULL
);

CREATE TABLE activeprinciple (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(60) NOT NULL
);

CREATE TABLE labatory (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    codecityreg varchar(5) NOT NULL,
    CONSTRAINT fk_codecityreg FOREIGN KEY (codecityreg) REFERENCES city(code)
);

CREATE TABLE customer (
    id varchar(20) PRIMARY KEY,
    name varchar(50) NOT NULL,
    lastname varchar(50) NOT NULL,
    codecity varchar(5) NOT NULL,
    email varchar(100) NOT NULL,
    birthdate date NOT NULL,
    lon float(8) NOT NULL,
    lat float(8) NOT NULL,
    CONSTRAINT fk_codecity_customer FOREIGN KEY (codecity) REFERENCES city(code)
);

CREATE TABLE farmacy (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(60) NOT NULL,
    address varchar(100) NOT NULL,
    lon float(8) NOT NULL,
    lat float(8) NOT NULL,
    codecity varchar(5) NOT NULL,
    logo varchar(50) NOT NULL,
    CONSTRAINT fk_codecity_farmacy FOREIGN KEY (codecity) REFERENCES city(code)
);

CREATE TABLE medicine (
    id INT PRIMARY KEY AUTO_INCREMENT,
    proceedings varchar(10) NOT NULL,
    name varchar(100) NOT NULL,
    healthregister varchar(50) NOT NULL,
    description text NOT NULL,
    descriptionShort varchar(60),
    codemodeadmin int NOT NULL,
    codepa int NOT NULL,
    codeum int NOT NULL,
    codelab int NOT NULL,
    CONSTRAINT fk_codemodeadmin FOREIGN KEY (codemodeadmin) REFERENCES modeadministration(id),
    CONSTRAINT fk_codepa FOREIGN KEY (codepa) REFERENCES activeprinciple(id),
    CONSTRAINT fk_codeum FOREIGN KEY (codeum) REFERENCES unitmeasurement(id),
    CONSTRAINT fk_codelab FOREIGN KEY (codelab) REFERENCES labatory(id)
);

CREATE TABLE farmacyMedicine (
    id_farmacy int NOT NULL,
    id_medicinefartm int NOT NULL,
    price float(8) NOT NULL,
    CONSTRAINT pk_farmacyMedicine PRIMARY KEY (id_farmacy, id_medicinefartm),
    CONSTRAINT fk_idfarmacy FOREIGN KEY (id_farmacy) REFERENCES farmacy(id),
    CONSTRAINT fk_idmedicinefartm FOREIGN KEY (id_medicinefartm) REFERENCES medicine(id)
);
