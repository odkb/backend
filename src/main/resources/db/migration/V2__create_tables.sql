create TABLE ${flyway:defaultSchema}.employees
(
    employee_id BIGINT       NOT NULL,
    username    VARCHAR(255) NOT NULL,
    password    VARCHAR(256) NOT NULL,
    first_name  VARCHAR(255) NOT NULL,
    last_name   VARCHAR(255) NOT NULL,
    second_name VARCHAR(255),
    CONSTRAINT pk_employees PRIMARY KEY (employee_id)
);