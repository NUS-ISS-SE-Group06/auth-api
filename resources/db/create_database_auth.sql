CREATE DATABASE IF NOT EXISTS auth;

USE auth;

-- Disable foreign key checks
SET foreign_key_checks = 0;

-- Create table group_info
CREATE TABLE IF NOT EXISTS group_info (
    group_id INT NOT NULL AUTO_INCREMENT,
    group_name VARCHAR(255),
    group_description VARCHAR(500),
    created_by VARCHAR(50) NULL,
    created_date TIMESTAMP NULL,
    modified_by VARCHAR(50) NULL,
    modified_date TIMESTAMP NULL,
    delete_flag VARCHAR(50) NULL,
    PRIMARY KEY (group_id)
);

-- Create table user_info
CREATE TABLE IF NOT EXISTS user_info (
    user_id INT NOT NULL AUTO_INCREMENT,
    group_id INT NULL,
    `role` VARCHAR(50),
    name VARCHAR(255),
    username varchar(255),
    email VARCHAR(255),
    password VARCHAR(255),
    password_change_mandatory VARCHAR(50),
    created_by VARCHAR(50) NULL,
    created_date TIMESTAMP NULL,
    modified_by VARCHAR(50) NULL,
    modified_date TIMESTAMP NULL,
    delete_flag VARCHAR(50) NULL,

    PRIMARY KEY (user_id)
);


-- Enable foreign key checks
SET foreign_key_checks = 1;



