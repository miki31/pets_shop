use olx_pets_db;

INSERT INTO user (id, first_name, sur_name, nick_name, birthday, password, email, role) VALUES
(1, 'Олег', 'Пашкевич', 'тічер', '1972-10-22', '$2a$10$.xysUEZxutiwXaduiJJ8oeWpXU9FbU5W7ow9.0KdjBepM0w86ZAT.', 'tich123@gmail.com', 'ADMIN'),
(2, 'Мар''ян', 'Лукаш', 'NOтічер', '1988-02-11', 'NOtich123', 'NOtich123@gmail.com', 'GUEST' ),
(3, 'Світлана', 'Федорчук', 'NOтічер_2', '1979-01-01', 'NOtich123NO', 'NOOOtich123@gmail.com', 'GUEST'),
(4, 'Svitlana', 'Fedorchuk', 'Sveta', '1992-05-15', 'sveta', 'svetaF123@gmail.com', 'ADMIN'),
(5, 'Misha', 'Shchepanskiy', 'mmm31', '1991-03-31', 'mmm31', 'mmm31@gmail.com', 'MANAGER' ),
(6, 'Peter', 'Kolomya', 'Peterrr', '1966-06-09', 'petro', 'petre3@gmail.com', 'USER');

INSERT INTO category (id, name, description) VALUES
(1, 'котик', 'коротко про милих котиків'),
(2, 'собачка', 'щось про собачок'),
(3, 'папуга', 'говоряща пташкка, що не дає спати'),
(4, 'рибка', 'плаває глибоко під водою, або в 3-літровому слоїку'),
(5, 'мишка', 'гризе компютерні кабелі');

INSERT INTO pet (id, name, price, category_id) VALUES
(1, "Мурчик" , 1000, 1);
