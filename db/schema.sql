CREATE DATABASE wallet;
USE wallet;
CREATE TABLE expenses (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          title VARCHAR(255) NOT NULL,
                          amount DECIMAL(10,2) NOT NULL,
                          creationTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
