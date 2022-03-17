-- Profile
DROP TABLE IF EXISTS PROFILE CASCADE;
CREATE TABLE PROFILE(
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY UNIQUE NOT NULL,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    firstName VARCHAR(255) NOT NULL,
    middleName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    DOB DATE NOT NULL
);
-- Phone
DROP TABLE IF EXISTS PHONE CASCADE;
-- CREATE TABLE PHONE(phoneNumber BIGINT NOT NULL PRIMARY KEY);
-- Province
DROP TABLE IF EXISTS PROVINCE CASCADE;
-- CREATE TABLE PROVINCE(
--     id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY UNIQUE NOT NULL,
--     PROVINCE VARCHAR(20)
-- );
-- Address
DROP TABLE IF EXISTS ADDRESS CASCADE;
CREATE TABLE ADDRESS(
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    building_number INTEGER NOT NULL CHECK(building_number > 0),
    street VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    province VARCHAR(20) NOT NULL CHECK (
        PROVINCE IN(
            'AB',
            'BC',
            'MB',
            'NB',
            'NL',
            'NT',
            'NS',
            'NU',
            'ON',
            'PE',
            'QC',
            'SK',
            'YT'
        )
    ),
    postal_code VARCHAR(7) NOT NULL,
    PRIMARY KEY (
        building_number,
        street,
        city,
        province,
        postal_code
    )
);
-- BRANCH
DROP TABLE IF EXISTS BRANCH CASCADE;
CREATE TABLE BRANCH(
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255) NOT NULL,
    address_building_number INTEGER NOT NULL CHECK(address_building_number > 0),
    address_street VARCHAR(255) NOT NULL,
    address_city VARCHAR(255) NOT NULL,
    address_province VARCHAR(20) NOT NULL CHECK (
        ADDRESS_PROVINCE IN(
            'AB',
            'BC',
            'MB',
            'NB',
            'NL',
            'NT',
            'NS',
            'NU',
            'ON',
            'PE',
            'QC',
            'SK',
            'YT'
        )
    ),
    address_postal_code VARCHAR(7) NOT NULL,
    phone_number BIGINT NOT NULL,
    FOREIGN KEY(
        address_building_number,
        address_street,
        address_city,
        address_province,
        address_postal_code
    ) REFERENCES ADDRESS(
        building_number,
        street,
        city,
        province,
        postal_code
    ),
    PRIMARY KEY (
        name,
        address_building_number,
        address_street,
        address_city,
        address_province,
        address_postal_code,
        phone_number
    )
);
-- EMPLOYEE
DROP TABLE IF EXISTS EMPLOYEE CASCADE;
CREATE TABLE EMPLOYEE(
    eId BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY UNIQUE NOT NULL,
    role VARCHAR(255) NOT NULL NOT NULL CHECK(
        ROLE in (
            'MANAGER',
            'RECEPTIONIST',
            'DENTIST',
            'HYGIENIST'
        )
    ),
    type VARCHAR(7) NOT NULL CHECK(TYPE IN ('FT', 'PT')),
    salary BIGINT NOT NULL CHECK (salary > 0),
    SSN BIGINT NOT NULL UNIQUE -- FOREIGN KEY(branchId) REFERENCES BRANCH(id),
    -- FOREIGN KEY(managerID) REFERENCES (id)
);
-- PROCEDURE
DROP TABLE IF EXISTS PROCEDURE CASCADE;
CREATE TABLE PROCEDURE (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY UNIQUE NOT NULL,
    appointment_id BIGINT NOT NULL,
    procedure_code BIGINT NOT NULL,
    invoice_id BIGINT NOT NULL,
    description VARCHAR(255),
    tooth CHAR,
    procedure_count INT CHECK(procedure_count >= 0)
);
-- -- TREATMENT
DROP TABLE IF EXISTS TREATMENT CASCADE;
CREATE TABLE TREATMENT (
    medication VARCHAR(255) PRIMARY KEY,
    procedure_id INT NOT NULL,
    teeth CHAR,
    --?
    symptoms VARCHAR(255),
    comments VARCHAR(255)
);
-- APPOINTMENT_TYPE
DROP TABLE IF EXISTS APPOINTMENT_TYPE CASCADE;
CREATE TABLE APPOINTMENT_TYPE (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY UNIQUE NOT NULL,
    type VARCHAR(255) UNIQUE NOT NULL
);
-- APPOINTMENT_STATUS
DROP TABLE IF EXISTS APPOINTMENT_STATUS CASCADE;
CREATE TABLE APPOINTMENT_STATUS (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY UNIQUE NOT NULL,
    status VARCHAR(255) UNIQUE NOT NULL
);
-- APPOINTMENT
DROP TABLE IF EXISTS APPOINTMENT CASCADE;
CREATE TABLE APPOINTMENT (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY UNIQUE NOT NULL,
    branch_id INT NOT NULL,
    employee_id INT NOT NULL,
    patient_id INT NOT NULL,
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    type INT NOT NULL,
    status INT NOT NULL,
    room_number VARCHAR
);