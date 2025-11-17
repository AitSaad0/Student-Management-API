CREATE TABLE IF NOT EXISTS students
(
    student_id  BIGINT AUTO_INCREMENT PRIMARY KEY,
    apogee          VARCHAR(8)                            NOT NULL,
    first_name      VARCHAR(250)                          NOT NULL,
    last_name       VARCHAR(500)                          NOT NULL,
    age             INT                                   NOT NULL,
    phone_number    INT                                   NOT NULL,
    email           VARCHAR(100),
    field           VARCHAR(30)                           NOT NULL,
    created_at      TIMESTAMP   DEFAULT CURRENT_TIMESTAMP NOT NULL,
    created_by      VARCHAR(20)                           NOT NULL,
    updated_at      TIMESTAMP   DEFAULT NULL,
    updated_by      VARCHAR(20) DEFAULT NULL
    );