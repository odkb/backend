create TABLE nicu_op.employees
(
    employee_id             VARCHAR(128) NOT NULL PRIMARY KEY,
    password                VARCHAR(256) NOT NULL,
    username                VARCHAR(20)  NOT NULL,
    first_name              VARCHAR(50)  NOT NULL,
    last_name               VARCHAR(50)  NOT NULL,
    second_name             VARCHAR(50)  NOT NULL,
    params                  VARCHAR(50),
    roles_id                VARCHAR(50)  NOT NULL,
    reanimation_id         VARCHAR(50)  NOT NULL,
    specialisation          VARCHAR(50)  NOT NULL,
    is_admin                BOOLEAN      NOT NULL
);