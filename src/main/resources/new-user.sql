CREATE USER 'olx_pets_admin_db'@'localhost' IDENTIFIED BY 'olxpetsadmin';
GRANT ALL PRIVILEGES ON * . * TO 'olx_pets_admin_db'@'localhost';
FLUSH PRIVILEGES;


CREATE DATABASE olx_pets_db CHARACTER SET utf8 COLLATE utf8_general_ci;
