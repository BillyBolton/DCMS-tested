-- =============================================================
-- ADDRESS
-- =============================================================
INSERT INTO ADDRESS(
        id,
        building_number,
        street,
        city,
        province,
        postal_code
    )
VALUES (
        'A_1',
        '1',
        'Candy Lane',
        'Toronto',
        'ON',
        'C0C 0P0'
    ),
    (
        'A_2',
        '50',
        'Main Street',
        'Toronto',
        'ON',
        'M5H 2J2'
    );
-- =============================================================
-- PROFILE
-- PROFILE.PASSWORD = username but encrypted using https://www.browserling.com/tools/bcrypt
-- =============================================================
INSERT INTO PROFILE(
        id,
        username,
        password,
        firstname,
        middlename,
        lastname,
        dob,
        address_id
    )
VALUES (
        'P_1',
        'admin',
        '$2a$10$XV91.O5hI4GQIWsUSzDaP.bD.E0IEukeSkjT2SvnNZzG09/eEOzxC',
        'admin',
        'admin',
        'admin',
        'June 23, 1912',
        'A_1'
    ),
    (
        'P_2',
        'chocoman',
        '$2a$10$TSCQFglMPxvhxzk0PbdnwO5G/FKEQsrPjEmPIvXqIaSEsW6pLoIGi',
        'Willy',
        'Bo',
        'Wonka',
        'January 1, 2000',
        'A_1'
    ),
    (
        'P_3',
        'oompsy',
        '$2a$10$BVtGabM8EqyvAI.lLFpI4eEalTZu8.mq3QXUfewOLBZ7FF6ZwFvZa',
        'Oompa',
        'Pa',
        'Wonka',
        'January 20, 1234',
        'A_1'
    ),
    (
        'P_4',
        'cManCan',
        '$2a$10$MCcfwwCamKGGegCvnV1EWOmyRTmxUKeg.na9vWp2ulV79Nvu86upO',
        'The',
        'Candy',
        'Man',
        'March 5, 1960',
        'A_1'
    ),
    (
        'P_5',
        'gummyGramps',
        '$2a$10$jUvtCCH9DAyJorsNq93F9.9NMwoesp0N4Zh0P47F4dBoxVDZf33SW',
        'Grampa',
        '',
        'Joe',
        'January 2, 1950',
        'A_2'
    ),
    (
        'P_6',
        'charlieBitMe',
        '$2a$10$nk5AhFKa4DJZVqm0QDklOeVEv843iQUr8Tszu64UiHAFT.rEr0zfa',
        'Charlie',
        'Lucky',
        'Bucket',
        'January 3, 2010',
        'A_2'
    );
-- =============================================================
-- PATIENT
-- =============================================================
INSERT INTO PATIENT(id, email)
VALUES('P_1', 'admin@wonka.com'),
    ('P_2', 'willy@wonka.com'),
    ('P_3', 'oomps@wonka.com'),
    ('P_4', 'candyman@wonka.ca'),
    ('P_5', 'gpaG@gmail.com'),
    ('P_6', 'charlie@gmail.com');
-- =============================================================
-- RESPONSIBLE_PARTY
-- =============================================================
INSERT INTO RESPONSIBLE_PARTY(responsible_id, patient_id)
VALUES('P_5', 'P_6');
-- =============================================================
-- USER_PHONE
-- =============================================================
INSERT INTO PROFILE_PHONE(profile_id, phone_number)
VALUES('P_1', '613-111-1111'),
    ('P_2', '613-111-1111'),
    ('P_3', '613-111-2222'),
    ('P_4', '613-111-3333'),
    ('P_5', '613-222-1111'),
    ('P_6', '613-222-1111');
-- =============================================================
-- BRANCH
-- =============================================================
INSERT INTO BRANCH(id, manager_id, address_id)
VALUES('B_1', null, 'A_1');
-- =============================================================
-- BRANCH_PHONE
-- =============================================================
INSERT INTO BRANCH_PHONE(branch_id, phone_number)
VALUES('B_1', '613-666-6666');
-- =============================================================
-- EMPLOYEE
-- =============================================================
INSERT INTO EMPLOYEE(
        id,
        SSN,
        role,
        type,
        salary,
        manager_id,
        branch_id
    )
VALUES(
        'P_2',
        111111111,
        'MANAGER',
        'FT',
        300000,
        null,
        'B_1'
    ),
    (
        'P_3',
        222222222,
        'DENTIST',
        'FT',
        300000,
        'P_2',
        'B_1'
    ),
    (
        'P_4',
        333333333,
        'HYGIENIST',
        'FT',
        100000,
        'P_2',
        'B_1'
    );
-- =============================================================
-- UPDATE BRANCH'S MANAGER
-- =============================================================
UPDATE BRANCH
SET manager_id = 'P_2'
WHERE id = 'B_1';
-- =============================================================
-- APPOINTMENT_TYPE
-- =============================================================
INSERT INTO APPOINTMENT_TYPE(type)
VALUES('CLEANING'),
    ('FILLING'),
    ('EXTRACTION');
-- =============================================================
-- APPOINTMENT_STATUS
-- =============================================================
INSERT INTO APPOINTMENT_STATUS(status)
VALUES ('NO SHOW'),
    ('CANCELLED'),
    ('COMPLETED'),
    ('UNSCHEDULED'),
    ('SCHEDULED');
-- =============================================================
-- APPOINTMENT
-- =============================================================
INSERT INTO APPOINTMENT(
        branch_id,
        employee_id,
        patient_id,
        start_time,
        end_time,
        type,
        status,
        room_number
    )
VALUES(
        'B_1',
        'P_2',
        'P_6',
        '2022-10-24 10:00:00',
        '2022-10-24 11:00:00',
        1,
        5,
        'R10'
    );
-- =============================================================
-- INSURANCE
-- =============================================================
INSERT INTO INSURANCE(policy_number, group_number, patient_id)
VALUES('POL123', 'GRP123', 'P_4');
-- =============================================================
-- PROCEDURE_TYPE
-- =============================================================
INSERT INTO PROCEDURE_TYPE(id, type)
VALUES('PT_1', 'NO_CLUE'),
    ('PT_2', 'NO_IDEA');
-- =============================================================
-- FEE
-- =============================================================
INSERT INTO FEE(
        procedure_code,
        procedure_name,
        procedure_type,
        cost
    )
VALUES('F_1', 'FLUORIDE', 'PT_1', 20.00);
-- =============================================================
-- PAYMENT_TYPE
-- =============================================================
INSERT INTO PAYMENT_TYPE(type)
VALUES('DEBIT'),
    ('VISA'),
    ('MASTER_CARD'),
    ('AMEX');
-- ============================================================
-- INVOICE
-- =============================================================
-- 
-- TODO
-- 
-- =============================================================
-- PAYMENT
-- =============================================================
-- 
-- TODO AFTER INVOICE
-- 
-- =============================================================
-- PROCEDURE
-- =============================================================
INSERT INTO PROCEDURE(
        id,
        appointment_id,
        procedure_code,
        invoice_id,
        description,
        tooth,
        procedure_count
    )
VALUES();
-- =============================================================
-- TREATMENT
-- =============================================================
INSERT INTO TREATMENT(
        medication,
        procedure_id,
        teeth,
        symptoms,
        comments
    )
VALUES();
-- =============================================================
-- PATIENT_BILLING
-- =============================================================
INSERT INTO PATIENT_BILLING(card_number, expiry_date, payment_type)
VALUES();
-- =============================================================
-- INSURANCE_CLAIM
-- =============================================================
INSERT INTO INSURANCE_CLAIM(policy_number, group_number)
VALUES();