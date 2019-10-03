drop database olx_pets_db;
create database olx_pets_db character set utf8;

use olx_pets_db;

SET GLOBAL time_zone = '+3:00';

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

CREATE TABLE advertisement
(
    id BIGINT AUTO_INCREMENT,
    seller_id BIGINT,
    buyer_id BIGINT,
    title VARCHAR(50),
    category_id BIGINT,
    description TEXT,
    photo VARCHAR(255),
    price DOUBLE,
    posted_on DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (seller_id) REFERENCES user (id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (buyer_id) REFERENCES user (id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (category_id) REFERENCES category (id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=INNODB CHARACTER SET=utf8;

CREATE TABLE logadvertisement
(
    id BIGINT AUTO_INCREMENT,
    buyer_id BIGINT,
    advertisement_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (buyer_id) REFERENCES user (id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (advertisement_id) REFERENCES advertisement (id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=INNODB CHARACTER SET=utf8;

CREATE TABLE logadvertisement_user
(
    buyer_id BIGINT,
    logadvertisement_id BIGINT,
    FOREIGN KEY (buyer_id) REFERENCES user (id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (logadvertisement_id) REFERENCES logadvertisement (id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=INNODB CHARACTER SET=utf8;

CREATE TABLE logadvertisement_advertisement
(
    advertisement_id BIGINT,
    logadvertisement_id BIGINT,
    FOREIGN KEY (advertisement_id) REFERENCES advertisement (id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (logadvertisement_id) REFERENCES logadvertisement (id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=INNODB CHARACTER SET=utf8;


CREATE TABLE advertisement_user
(
    user_id BIGINT,
    advertisement_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (advertisement_id) REFERENCES advertisement (id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=INNODB CHARACTER SET=utf8;

CREATE TABLE hibernate_sequence
(
    next_val INT
) ENGINE=INNODB;
