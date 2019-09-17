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
(1, "ADMIN"),
(2, "SELLER"),
(3, "USER");

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


INSERT INTO category (id, name, description) VALUES
(1, 'котик', 'коротко про милих котиків'),
(2, 'собачка', 'щось про собачок'),
(3, 'папуга', 'говоряща пташкка, що не дає спати'),
(4, 'рибка', 'плаває глибоко під водою, або в 3-літровому слоїку'),
(5, 'мишка', 'гризе компютерні кабелі');

INSERT INTO pet (id, name, price, category_id) VALUES
(1, "Мурчик" , 1000, 1);





INSERT INTO hibernate_sequence (next_val) VALUE (1000000);
