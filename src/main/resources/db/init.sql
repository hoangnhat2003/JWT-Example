
CREATE DATABASE test_db;

-- Table user
CREATE TABLE IF NOT EXISTS tbl_users (
id SERIAL,
username VARCHAR(255),
name VARCHAR(255),
password VARCHAR(255),
email VARCHAR(255),
enabled BOOLEAN,
created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(id)
);

CREATE TYPE E_ROLES AS ENUM ('USER','ADMIN');
-- Table roles
CREATE TABLE IF NOT EXISTS tbl_roles  (
id SERIAL,
name E_ROLES,
created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(id)
);

INSERT INTO tbl_roles (name)
VALUES ('USER');
INSERT INTO roles (name)
VALUES ('ADMIN');

-- Table user_roles
CREATE TABLE IF NOT EXISTS tbl_user_roles (
user_id INT,
role_id INT,
CONSTRAINT user_roles_fk1 FOREIGN KEY (user_id) REFERENCES tbl_users(id),
CONSTRAINT user_roles_fk2 FOREIGN KEY (role_id) REFERENCES tbl_roles(id)
);

-- Table refresh_token
CREATE TABLE IF NOT EXISTS tbl_refresh_token (
id SERIAL,
user_id INT,
token VARCHAR(255),
expiryDate TIMESTAMP,
created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
CONSTRAINT refresh_token_fk1 FOREIGN KEY (user_id) REFERENCES tbl_users(id),
PRIMARY KEY(id)
);