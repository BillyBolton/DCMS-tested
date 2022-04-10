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
           '1234',
           'Appletree Lane',
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
       ),
       (
           'A_3',
           '56',
           'Second Avenue',
           'Ottawa',
           'ON',
           'K4A 4L1'
       ),
       (
           'A_4',
           '78',
           'Main Street',
           'Ottawa',
           'ON',
           'K1A 2S5'
       ),
       (
           'A_5',
           '12',
           'Orangetree Road',
           'Ottawa',
           'ON',
           'K1A 8P9'
       ),
       (
           'A_6',
           '376',
           'Poplar Crescent',
           'Ottawa',
           'ON',
           'K1N 6E8'
       ),
       (
           'A_7',
           '247',
           'Carleton Avenue',
           'Ottawa',
           'ON',
           'K2V 4S4'
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
           'mWhite',
           '$2a$10$U3yi7aL5HhJ7fu3M//72teN1ihmPA.ZP5xruo5X/bYDBbLyMni8ti',
           'Maggie',
           'Anne',
           'White',
           'March 12, 1991',
           'A_3'
       ),
       (
           'P_7',
           'jStaples',
           '$2a$10$iOsGG24RvFoki4xwMBEXTOg06N7s/dn.UtmkqNfRDxX.0Ra/Rzru.',
           'Jessica',
           'Marie',
           'Staples',
           'January 16, 1992',
           'A_4'
       ),
       (
           'P_8',
           'gMacdonald',
           '$2a$10$EiguJkSrCIFll4k1nYLche8szlHNiz/28jHkZpFvX1v6ZK12EwxVu',
           'George',
           'Wilson',
           'MacDonald',
           'August 11, 1989',
           'A_5'
       ),
       (
           'P_9',
           'gSticks',
           '$2a$10$fZciA9ZRJNl0R.mNXaJXXOzeP35ViBYibHeU9..rn0hjcp4kxtsOC',
           'Gregory',
           'Adam',
           'Sticks',
           'April 14, 1970',
           'A_6'
       ),
       (
           'P_10',
           'aBaker',
           '$2a$10$ksiuW2MVgse08KJ5LJET2OCI0VeQqz00jaMOQSAs2IbA6SxpypTBy',
           'Adam',
           'Charles',
           'Baker',
           'September 4, 1990',
           'A_7'
       ),
       (
           'P_11',
           'pSharma',
           '$2a$10$F3muI8DviiToCVZELWovTeuUcrQW9eXOl56QBb.bYpD/fPhPULHCC',
           'Priya',
           '',
           'Sharma',
           'March 5, 2001',
           'A_3'
       ),
       (
           'P_12',
           'mLi',
           '$2a$10$gVRBptav8N0I7vRWE4qP7eQNBYcgDaiFW9ci8aq7wG6uvzY/jte7u',
           'Mei',
           '',
           'Li',
           'January 3, 1997',
           'A_4'
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
      ('P_6', 'charlie@gmail.com'),
      ('P_7', 'mWhite@gmail.com'),
      ('P_8', 'gMacdonald@gmail.com'),
      ('P_9', 'gSticks@gmail.com'),
      ('P_10', 'aBaker@gmail.com'),
      ('P_11', 'pSharma@gmail.com'),
      ('P_12', 'mLi@gmail.com');
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
      ('P_6', '613-222-1111'),
      ('P_7', '613-111-2222'),
      ('P_8', '613-111-3333'),
      ('P_9', '613-222-1111'),
      ('P_10', '613-222-1111'),
      ('P_11', '613-111-2222'),
      ('P_12', '613-111-3333');
-- =============================================================
-- BRANCH
-- =============================================================
INSERT INTO BRANCH(id, manager_id, address_id)
VALUES('B_1', null, 'A_1'),
      ('B_2', null, 'A_6'),
      ('B_3', null, 'A_5');
-- =============================================================
-- BRANCH_PHONE
-- =============================================================
INSERT INTO BRANCH_PHONE(branch_id, phone_number)
VALUES('B_1', '613-666-6666'),
      ('B_2', '613-555-5555'),
      ('B_3', '613-444-5555');
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
      ),
      (
          'P_6',
          123123123,
          'MANAGER',
          'FT',
          300000,
          null,
          'B_2'
      ),
      (
          'P_7',
          234234234,
          'DENTIST',
          'FT',
          300000,
          'P_6',
          'B_2'
      ),
      (
          'P_8',
          345345345,
          'DENTIST',
          'FT',
          300000,
          'P_6',
          'B_2'
      ),
      (
          'P_9',
          456456456,
          'MANAGER',
          'FT',
          300000,
          null,
          'B_3'
      ),
      (
          'P_10',
          567567567,
          'DENTIST',
          'FT',
          300000,
          'P_9',
          'B_3'
      ),
      (
          'P_12',
          789789789,
          'DENTIST',
          'FT',
          300000,
          'P_9',
          'B_3'
      ),
      (
          'P_11',
          678678678,
          'DENTIST',
          'FT',
          100000,
          'P_9',
          'B_3'
      );
-- =============================================================
-- UPDATE BRANCH'S MANAGER
-- =============================================================
UPDATE BRANCH
SET manager_id = 'P_2'
WHERE id = 'B_1';

UPDATE BRANCH
SET manager_id = 'P_6'
WHERE id = 'B_2';

UPDATE BRANCH
SET manager_id = 'P_9'
WHERE id = 'B_3';
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
VALUES('PT_1', 'Cleaning'),
    ('PT_2', 'Filling'),
    ('PT_3', 'Extraction'),
    ('PT_4', 'Tooth Whitening');

-- =============================================================
-- BRANCH_PROCEDURES
-- =============================================================
INSERT INTO BRANCH_PROCEDURES(branch_id, procedure_id)
VALUES('B_1', 'PT_1'),
    ('B_1', 'PT_2'),
    ('B_1','PT_3'),
    ('B_1','PT_4'),
    ('B_2', 'PT_1'),
    ('B_2', 'PT_2'),
    ('B_2','PT_3'),
    ('B_3', 'PT_1'),
    ('B_3', 'PT_2'),
    ('B_3','PT_3');
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
-- -- =============================================================
-- -- PROCEDURE
-- -- =============================================================
INSERT INTO PROCEDURE(
        id,
        appointment_id,
        procedure_code,
        -- invoice_id,
        description,
        tooth,
        procedure_count
    )
VALUES('PRO_1', 1, 'PT_1', 'SOME DESCRIPTION', 'c', 1);
-- -- =============================================================
-- -- TREATMENT
-- -- =============================================================
INSERT INTO TREATMENT(
        medication,
        procedure_id,
        -- teeth,
        symptoms,
        comments
    )
VALUES(
        'Acetaminophen 500mg',
        'PRO_1',
        -- 'c',
        'tooth pain',
        'Use every 4 hours as needed'
    );
-- -- ============================================================
-- -- INVOICE
-- -- =============================================================
-- -- 
-- -- TODO
-- -- 
-- -- =============================================================
-- -- PAYMENT
-- -- =============================================================
-- Not needed. Table used for inheritance in PATIENT_BILLING
-- =============================================================
-- PAYMENT_TYPE
-- =============================================================
INSERT INTO PAYMENT_TYPE(type)
VALUES('DEBIT'),
    ('VISA'),
    ('MASTERCARD'),
    ('AMEX');
-- -- =============================================================
-- -- PATIENT_BILLING
-- -- =============================================================
INSERT INTO PATIENT_BILLING(
        card_number,
        expiry_date,
        payment_type,
        amount
    )
VALUES(1234123412341234, '2224', 2, 100.00);
-- -- =============================================================
-- -- INSURANCE_CLAIM
-- -- =============================================================
INSERT INTO INSURANCE_CLAIM(policy_number, group_number, amount)
VALUES('POL123', 'GRP123', 99.99);
-- =============================================================
-- REVIEW
-- =============================================================
INSERT INTO REVIEW(
        date,
        branch_id,
        patient_id,
        professionalism,
        communication,
        cleanliness,
        value,
        comments
    )
VALUES(
        '2022-03-21',
        'B_1',
        'P_9',
        5,
        4,
        5,
        4,
        'Dr. Wonka was incredible!'
    ),
    (
        '2022-04-01',
        'B_1',
        'P_6',
        4,
        4,
        4,
        5,
        'Awesome visit, will come back soon!'
    ),
    (
        '2022-03-21',
        'B_2',
        'P_10',
        5,
        5,
        5,
        5,
        'I had a great experience.'
    ),
    (
        '2022-04-01',
        'B_2',
        'P_11',
        5,
        3,
        3,
        5,
        'Always great to see Dr. MacDonald'
    ),
    (
        '2021-09-14',
        'B_3',
        'P_6',
        1,
        1,
        2,
        3,
        'I need to find a new dentist...'
    ),
    (
        '2021-10-31',
        'B_3',
        'P_7',
        2,
        2,
        1,
        1,
        'Will not be returning.'
    )