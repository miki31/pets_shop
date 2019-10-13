use olx_pets_db;

INSERT INTO user (id, first_name, sur_name, nick_name, birthday, password, email) VALUES
(1, 'Admin', 'Sur_Admin', 'aaa', '1970-1-1', '$2a$10$.xysUEZxutiwXaduiJJ8oeWpXU9FbU5W7ow9.0KdjBepM0w86ZAT.', 'admin@gmail.com'),
(2, 'Manager', 'Sur_Manager', 'mmm', '1975-1-1', '$2a$10$.xysUEZxutiwXaduiJJ8oeWpXU9FbU5W7ow9.0KdjBepM0w86ZAT.', 'manager@gmail.com'),
(3, 'Seller', 'Sur_Seller', 'sss', '1980-1-1', '$2a$10$.xysUEZxutiwXaduiJJ8oeWpXU9FbU5W7ow9.0KdjBepM0w86ZAT.', 'seller@gmail.com'),
(4, 'User', 'Sur_User', 'uuu', '1985-1-1', '$2a$10$.xysUEZxutiwXaduiJJ8oeWpXU9FbU5W7ow9.0KdjBepM0w86ZAT.', 'user@gmail.com'),
(5, 'Guest', 'Sur_Guest', 'ggg', '1990-1-1', '$2a$10$.xysUEZxutiwXaduiJJ8oeWpXU9FbU5W7ow9.0KdjBepM0w86ZAT.', 'guest@gmail.com'),

(6, 'Олег', 'Пашкевич', 'тічер', '1972-10-22', '$2a$10$.xysUEZxutiwXaduiJJ8oeWpXU9FbU5W7ow9.0KdjBepM0w86ZAT.', 'tich123@gmail.com'),
(7, 'Мар''ян', 'Лукаш', 'NOтічер', '1988-02-11', '$2a$10$.xysUEZxutiwXaduiJJ8oeWpXU9FbU5W7ow9.0KdjBepM0w86ZAT.', 'NOtich123@gmail.com'),
(8, 'Світлана', 'Федорчук', 'NOтічер_2', '1979-01-01', '$2a$10$.xysUEZxutiwXaduiJJ8oeWpXU9FbU5W7ow9.0KdjBepM0w86ZAT.', 'NOOOtich123@gmail.com'),
(9, 'Svitlana', 'Fedorchuk', 'Sveta', '1992-05-15', '$2a$10$.xysUEZxutiwXaduiJJ8oeWpXU9FbU5W7ow9.0KdjBepM0w86ZAT.', 'svetaF123@gmail.com'),
(10, 'Misha', 'Shchepanskiy', 'mmm31', '1991-03-31', '$2a$10$.xysUEZxutiwXaduiJJ8oeWpXU9FbU5W7ow9.0KdjBepM0w86ZAT.', 'mmm31@gmail.com'),
(11, 'Peter', 'Kolomya', 'Peterrr', '1966-06-09', '$2a$10$.xysUEZxutiwXaduiJJ8oeWpXU9FbU5W7ow9.0KdjBepM0w86ZAT.', 'petre3@gmail.com');

INSERT INTO role (id, name) VALUES
(1, 'ADMIN'),
(2, 'SELLER'),
(3, 'USER');

INSERT INTO user_role (user_id, role_id) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 3),
(5, 3),
(6, 2),
(7, 3),
(8, 1),
(9, 3),
(10, 2),
(11, 3);


INSERT INTO category (id, name) VALUES
(1, 'Коти' ),
(2, 'Собаки'),
(3, 'Птахи'),
(4, 'Рибки'),
(5, 'Гризуни'),
(6, 'Рептилії'),
(7, 'Комахи'),
(8,'Свійські тварини');

INSERT INTO pet (id, name, price, category_id) VALUES
(1, 'Мурчик' , 1000, 1);

INSERT INTO advertisement (id, seller_id, title, category_id, description, photo, price, posted_on) VALUES
(1, 3, 'Якась цікава назва посту', 1, 'Віддам в добрі руки 2-x кошенят, 2 місяці, хлопчик і дівчинка. Окрас чорно-білий, дуже-дуже лагідні. Привчені до лотка', null, 0, '1999-1-1'),
(2, 6, 'Супер цікава назва посту', 3, 'продам папугу, сидить в клітці і радіє життю', null, 500, '2012-3-3'),
(3, 3, "Обов'язково купіть!!!", 6, 'Продається черепаха, червоновуха. Вік 3 місяці, кличка Флеш', null, 400, '2019-09-25'),
(4, 3, 'Миле цуценя :))', 2, 'Продам цуцика порода Бернський Зенненхунд, хлопчик вік 2,5 місяці. Всі щеплення проведені, Документи КСУ, паспорт', null, 10000, '2019-06-16'),
(5, 6, 'Інше миле цуценя :))', 2, null, null, 10099, '2019-06-16'),
(6, 10, null, 1, 'Продається черепаха, червоновуха. Вік 3 місяці, кличка Флеш', null, 255, '2019-09-01');


INSERT INTO response (id, reviewer_id, author_id, response_text, posted, good) VALUES
(1, 4, 3, "Якийсь хороший коментар )))", '2019-06-16 11:11:11.354', true),
(2, 5, 3, "Якийсь дуже поганий коментар (((", '2019-07-18 23:59:55.432', false),
(3, 4, 3, "Якийсь інший ще кращий коментар :-D", '2019-09-09 15:35:08.354', true);

INSERT INTO like_the_response (id, good, appraiser_id, response_id) VALUES
(1, true, 6, 1),
(2, false, 7, 1),
(3, true, 8, 1),
(4, true, 9, 1),
(5, true, 6, 2),
(6, false, 6, 3),
(7, true, 8, 3);


INSERT INTO hibernate_sequence (next_val) VALUE (1000000);
