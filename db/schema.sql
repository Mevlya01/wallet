CREATE DATABASE wallet;
USE wallet;

CREATE TABLE categories (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(100) NOT NULL UNIQUE,
                            default_category BOOLEAN NOT NULL
);

CREATE TABLE expenses (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          title VARCHAR(255) NOT NULL,
                          amount DECIMAL(10,2) NOT NULL,
                          creation_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          category_id BIGINT NOT NULL,
                          CONSTRAINT fk_expense_category
                             FOREIGN KEY (category_id) REFERENCES categories(id)
);

INSERT INTO categories (name, default_category)
VALUES
    ('Food', TRUE),
    ('Fuel', TRUE),
    ('Bills', TRUE);
