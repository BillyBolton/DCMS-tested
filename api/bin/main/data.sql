INSERT INTO PROFILE(
        username,
        password,
        firstname,
        middlename,
        lastname,
        dob
    )
VALUES (
        'admin',
        'adminpass',
        'admin',
        'admin',
        'admin',
        'June 23, 1912'
    );
-- APPOINTMENT_TYPE
INSERT INTO APPOINTMENT_TYPE(type)
VALUES('CLEANING'),
    ('FILLING'),
    ('EXTRACTION');
-- APPOINTMENT_STATUS
INSERT INTO APPOINTMENT_STATUS(status)
VALUES ('NO SHOW'),
    ('CANCELLED'),
    ('COMPLETED'),
    ('UNSCHEDULED');
-- ADDRESS
INSERT INTO ADDRESS(
        building_number,
        street,
        city,
        province,
        postal_code
    )
VALUES ('50', 'Main Street', 'Toronto', 'ON', 'M5H 2J2');
-- BRANCH
INSERT INTO BRANCH(address_id)
VALUES (1);