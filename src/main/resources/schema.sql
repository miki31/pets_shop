drop database olx_pets_db;
create database olx_pets_db character set utf8;

use olx_pets_db;

CREATE TABLE user
(
    id BIGINT AUTO_INCREMENT,
    first_name VARCHAR(50),
    sur_name VARCHAR(50),
    nick_name VARCHAR(50),
    birthday DATE,
    password VARCHAR(255),
    email VARCHAR(50),
    photo VARCHAR(255),
    PRIMARY KEY (id)
) ENGINE=INNODB CHARACTER SET=utf8;

CREATE TABLE role(
    id BIGINT AUTO_INCREMENT,
    name VARCHAR(50)NOT NULL,
    primary key (id)
) ENGINE=INNODB CHARACTER SET=utf8;

CREATE TABLE user_role
(
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=INNODB;

CREATE TABLE demo_user
(
    id BIGINT AUTO_INCREMENT,
    email VARCHAR(50),
    name VARCHAR(50),
    PRIMARY KEY (id)
) ENGINE=INNODB CHARACTER SET=utf8;

CREATE TABLE category
(
    id BIGINT AUTO_INCREMENT,
    name VARCHAR(255),
    description TEXT,
    PRIMARY KEY (id)
) ENGINE=INNODB CHARACTER SET=utf8;

CREATE TABLE pet
(
    id BIGINT AUTO_INCREMENT,
    name VARCHAR(255),
    price DOUBLE,
    category_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES category (id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=INNODB CHARACTER SET=utf8;

CREATE TABLE pet_user
(
    user_id BIGINT,
    pet_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (pet_id) REFERENCES role (id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=INNODB CHARACTER SET=utf8;

CREATE TABLE hibernate_sequence
(
    next_val INT
) ENGINE=INNODB;
