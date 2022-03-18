-- =============================================================
-- Profile
-- =============================================================
DROP SEQUENCE IF EXISTS profile_seq CASCADE;
CREATE SEQUENCE profile_seq START 1;
DROP TABLE IF EXISTS PROFILE CASCADE;
CREATE TABLE PROFILE(
    id VARCHAR(255) NOT NULL DEFAULT 'P_' || nextval('profile_seq')::VARCHAR(255) UNIQUE,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    firstName VARCHAR(255) NOT NULL,
    middleName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    DOB DATE NOT NULL
);
-- =============================================================
-- PATIENT
-- =============================================================
DROP TABLE IF EXISTS PATIENT CASCADE;
CREATE TABLE PATIENT(
    id VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    FOREIGN KEY (id) REFERENCES PROFILE(id)
);
-- =============================================================
-- RESPONSIBLE_PARTY
-- =============================================================
DROP TABLE IF EXISTS RESPONSIBLE_PARTY CASCADE;
CREATE TABLE RESPONSIBLE_PARTY(
    responsible_id VARCHAR(255) NOT NULL,
    patient_id VARCHAR(255) NOT NULL,
    FOREIGN KEY(responsible_id) REFERENCES PROFILE(id),
    FOREIGN KEY(patient_id) REFERENCES PROFILE(id),
    PRIMARY KEY (responsible_id, patient_id)
);
-- =============================================================
-- USER_PHONE
-- =============================================================
DROP TABLE IF EXISTS PROFILE_PHONE CASCADE;
CREATE TABLE PROFILE_PHONE(
    phone_number VARCHAR(255) NOT NULL,
    profile_id VARCHAR(255) NOT NULL,
    FOREIGN KEY(profile_id) REFERENCES PROFILE(id),
    UNIQUE(phone_number, profile_id),
    PRIMARY KEY (phone_number, profile_id)
);
-- =============================================================
-- ADDRESS
-- =============================================================
DROP TABLE IF EXISTS ADDRESS CASCADE;
CREATE TABLE ADDRESS(
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY UNIQUE PRIMARY KEY,
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
    UNIQUE (
        building_number,
        street,
        city,
        province,
        postal_code
    )
);
-- =============================================================
-- BRANCH
-- =============================================================
DROP SEQUENCE IF EXISTS branch_seq CASCADE;
CREATE SEQUENCE branch_seq START 1;
DROP TABLE IF EXISTS BRANCH CASCADE;
CREATE TABLE BRANCH(
    id VARCHAR(255) NOT NULL DEFAULT 'B_' || nextval('branch_seq')::VARCHAR(255) UNIQUE,
    -- manager_id BIGINT NOT NULL,
    address_id BIGINT NOT NULL UNIQUE,
    FOREIGN KEY(address_id) REFERENCES ADDRESS(id),
    -- FOREIGN KEY (manager_id) REFERENCES EMPLOYEE(eId),
    PRIMARY KEY (id)
);
-- =============================================================
-- BRANCH_PHONE
-- =============================================================
DROP TABLE IF EXISTS BRANCH_PHONE CASCADE;
CREATE TABLE BRANCH_PHONE(
    phone_number VARCHAR(255) NOT NULL,
    branch_id VARCHAR(255) NOT NULL,
    FOREIGN KEY(branch_id) REFERENCES Branch(id),
    UNIQUE(phone_number, branch_id),
    PRIMARY KEY (phone_number, branch_id)
);
-- =============================================================
-- EMPLOYEE
-- =============================================================
DROP TABLE IF EXISTS EMPLOYEE CASCADE;
CREATE TABLE EMPLOYEE(
    emp_type BIGINT NOT NULL,
    SSN BIGINT NOT NULL PRIMARY KEY,
    -- FOREIGN KEY(branchId) REFERENCES BRANCH(id),
    -- FOREIGN KEY(managerID) REFERENCES (id)
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
    branch_id VARCHAR(255) NOT NULL,
    FOREIGN KEY(branch_id) REFERENCES BRANCH(id) -- FOREIGN KEY(managerID) REFERENCES (id)
);
-- =============================================================
-- PROCEDURE
-- =============================================================
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
-- =============================================================
-- TREATMENT
-- =============================================================
DROP TABLE IF EXISTS TREATMENT CASCADE;
CREATE TABLE TREATMENT (
    medication VARCHAR(255) PRIMARY KEY,
    procedure_id INT NOT NULL,
    teeth CHAR,
    --?
    symptoms VARCHAR(255),
    comments VARCHAR(255)
);
-- =============================================================
-- APPOINTMENT_TYPE
-- =============================================================
DROP TABLE IF EXISTS APPOINTMENT_TYPE CASCADE;
CREATE TABLE APPOINTMENT_TYPE (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY UNIQUE NOT NULL,
    type VARCHAR(255) UNIQUE NOT NULL
);
-- =============================================================
-- APPOINTMENT_STATUS
-- =============================================================
DROP TABLE IF EXISTS APPOINTMENT_STATUS CASCADE;
CREATE TABLE APPOINTMENT_STATUS (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY UNIQUE NOT NULL,
    status VARCHAR(255) UNIQUE NOT NULL
);
-- =============================================================
-- APPOINTMENT
-- =============================================================
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
-- =============================================================
-- INSURANCE
-- =============================================================
DROP TABLE IF EXISTS INSURANCE CASCADE;
CREATE TABLE INSURANCE (
    policy_number VARCHAR(255) UNIQUE NOT NULL,
    group_number VARCHAR(255) UNIQUE NOT NULL,
    patient_id VARCHAR(255) NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES PATIENT(id),
    PRIMARY KEY (policy_number, group_number, patient_id)
);
-- =============================================================
-- PROCEDURE_TYPE
-- =============================================================
DROP SEQUENCE IF EXISTS procedure_type_seq CASCADE;
CREATE SEQUENCE procedure_type_seq START 1;
DROP TABLE IF EXISTS PROCEDURE_TYPE CASCADE;
CREATE TABLE PROCEDURE_TYPE(
    id VARCHAR(255) NOT NULL DEFAULT 'PT_' || nextval('procedure_type_seq')::VARCHAR(255) UNIQUE,
    type VARCHAR(255) UNIQUE NOT NULL,
    PRIMARY KEY (id)
);
-- =============================================================
-- FEE
-- =============================================================
DROP SEQUENCE IF EXISTS fee_seq CASCADE;
CREATE SEQUENCE fee_seq START 1;
DROP TABLE IF EXISTS FEE CASCADE;
CREATE TABLE FEE(
    procedure_code VARCHAR(255) NOT NULL DEFAULT 'F_' || nextval('fee_seq')::VARCHAR(255) UNIQUE,
    procedure_name VARCHAR(255) NOT NULL UNIQUE,
    procedure_type VARCHAR(255) NOT NULL,
    cost DOUBLE PRECISION NOT NULL CHECK(cost > 0),
    FOREIGN KEY(procedure_type) REFERENCES PROCEDURE_TYPE(id),
    PRIMARY KEY (procedure_code)
);
-- =============================================================
-- INVOICE
-- =============================================================
-- =============================================================
-- PAYMENT
-- =============================================================
DROP TABLE IF EXISTS PAYMENT CASCADE;
CREATE TABLE PAYMENT(
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY UNIQUE PRIMARY KEY,
    amount DOUBLE PRECISION NOT NULL CHECK(amount > 0),
    date Date NOT NULL -- invoice_id BIGINT NOT NULL,
    -- FOREIGN KEY(invoice_id) REFERENCES INVOICE(id)
);
-- =============================================================
-- PAYMENT_TYPE
-- =============================================================
DROP TABLE IF EXISTS PAYMENT_TYPE CASCADE;
CREATE TABLE PAYMENT_TYPE(
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY UNIQUE PRIMARY KEY,
    type VARCHAR(255) UNIQUE NOT NULL
);
-- =============================================================
-- PATIENT_BILLING
-- =============================================================
DROP TABLE IF EXISTS PATIENT_BILLING CASCADE;
CREATE TABLE PATIENT_BILLING(
    card_number BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY UNIQUE CHECK(LENGTH(card_number::TEXT) = 16),
    expiry_date smallint NOT NULL CHECK(
        expiry_date > 0
        AND(LENGTH(expiry_date::TEXT) = 4)
    ),
    payment_type BIGINT NOT NULL,
    FOREIGN KEY (payment_type) REFERENCES PAYMENT_TYPE(id),
    PRIMARY KEY (card_number, expiry_date)
) INHERITS (PAYMENT);
-- =============================================================
-- INSURANCE_CLAIM
-- =============================================================
DROP TABLE IF EXISTS INSURANCE_CLAIM CASCADE;
CREATE TABLE INSURANCE_CLAIM(
    policy_number VARCHAR(255) NOT NULL,
    group_number VARCHAR(255) NOT NULL,
    UNIQUE (policy_number, group_number),
    FOREIGN KEY (policy_number) REFERENCES INSURANCE(policy_number),
    FOREIGN KEY (group_number) REFERENCES INSURANCE(group_number)
) INHERITS (PAYMENT);