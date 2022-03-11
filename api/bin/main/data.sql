-- AUTHENTICATION
DROP TABLE IF EXISTS AUTHENTICATION;
CREATE TABLE AUTHENTICATION (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);
DROP SEQUENCE IF EXISTS auth_seq;
CREATE SEQUENCE auth_seq START 1 INCREMENT 1 OWNED BY AUTHENTICATION.id;
INSERT INTO AUTHENTICATION(username, password)
VALUES ('admin', 'admin');
-- PROCEDURE
DROP TABLE IF EXISTS PROCEDURE;
CREATE TABLE PROCEDURE (
    id SERIAL PRIMARY KEY,
    apointment_id INT NOT NULL,
    procedure_code INT NOT NULL,
    invoice_id INT NOT NULL,
    description VARCHAR(255),
    tooth CHAR,
    procedure_count INT CHECK(procedure_count >= 0)
);
DROP SEQUENCE IF EXISTS procedure_seq;
CREATE SEQUENCE procedure_seq START 1 INCREMENT 1 OWNED BY PROCEDURE.id;
-- TREATMENT
DROP TABLE IF EXISTS TREATMENT;
CREATE TABLE TREATMENT (
    medication VARCHAR(255) UNIQUE NOT NULL PRIMARY KEY,
    procedure_id INT NOT NULL,
    teeth CHAR,
    --?
    symptoms VARCHAR(255),
    comments VARCHAR(255)
);
-- APPOINTMENT_TYPE
DROP TABLE IF EXISTS APPOINTMENT_TYPE;
CREATE TABLE APPOINTMENT_TYPE (
    id SERIAL PRIMARY KEY,
    type VARCHAR(255) UNIQUE NOT NULL
);
DROP SEQUENCE IF EXISTS appointment_type_seq;
CREATE SEQUENCE appointment_type_seq START 1 INCREMENT 1 OWNED BY APPOINTMENT_TYPE.id;
INSERT INTO APPOINTMENT_TYPE(type)
VALUES('CLEANING');
INSERT INTO APPOINTMENT_TYPE(type)
VALUES('FILLING');
INSERT INTO APPOINTMENT_TYPE(type)
VALUES('EXTRACTION');
-- APPOINTMENT_STATUS
DROP TABLE IF EXISTS APPOINTMENT_STATUS;
CREATE TABLE APPOINTMENT_STATUS (
    id SERIAL PRIMARY KEY,
    status VARCHAR(255) UNIQUE NOT NULL
);
DROP SEQUENCE IF EXISTS appointment_status_seq;
CREATE SEQUENCE appointment_status_seq START 1 INCREMENT 1 OWNED BY APPOINTMENT_STATUS.id;
INSERT INTO APPOINTMENT_STATUS(status)
VALUES ('NO SHOW');
INSERT INTO APPOINTMENT_STATUS(status)
VALUES ('CANCELLED');
INSERT INTO APPOINTMENT_STATUS(status)
VALUES ('COMPLETED');
INSERT INTO APPOINTMENT_STATUS(status)
VALUES ('UNSCHEDULED');
-- APPOINTMENT
DROP TABLE IF EXISTS APPOINTMENT;
CREATE TABLE APPOINTMENT (
    id SERIAL PRIMARY KEY,
    branch_id INT NOT NULL,
    employee_id INT NOT NULL,
    patient_if INT NOT NULL,
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    type INT NOT NULL,
    status INT NOT NULL,
    roomNumber VARCHAR
);
DROP SEQUENCE IF EXISTS appointment_seq;
CREATE SEQUENCE appointment_seq START 1 INCREMENT 1 OWNED BY APPOINTMENT.id;