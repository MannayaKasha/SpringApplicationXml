-- Insert data

INSERT INTO users (id, username, password) VALUES
  (1, 'admin', '$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG');

INSERT INTO roles (id, name) VALUES
  (1, 'ROLE_USER'),
  (2, 'ROLE_ADMIN');

INSERT INTO user_roles (user_id, role_id) VALUES
  (1, 2);

INSERT INTO ingestion (id, name) VALUES
  (1, 'breakfast'),
  (2, 'lunch'),
  (3, 'dinner');

INSERT INTO food (id, name, fats, proteins, carbohydrates, calories) VALUES
  (1, 'porridge', 1.8, 3.2, 15.4, 93),
  (2, 'mutton', 15.3, 16.2, 0, 201),
  (3, 'fried potatoes', 9.7, 2.6, 23.5, 198),
  (4, 'icecream', 15.1, 3.6, 20.5, 223),
  (5, 'apple', 0, 0.5, 11.4, 48);

INSERT INTO meal (id, user_id, date_time, ingestion_id, food_id) VALUES
  (1, 2, SYSDATE(), 1, 1),
  (2, 2, SYSDATE(), 2, 5),
  (3, 2, SYSDATE(), 3, 2),
  (4, 3, SYSDATE(), 1, 4),
  (5, 3, SYSDATE(), 2, 5),
  (6, 3, SYSDATE(), 3, 3);

/*INSERT INTO meal (id, user_id, date_time, ingestion_id, food_id) VALUES
  (1, 2, )*/

/*INSERT INTO Categories (Name) VALUES
  ('shirts'),
  ('jeans'),
  ('shoes');

INSERT INTO Products (CODE, NAME, PRICE, NOVELTY, CREATE_DATE, CATEGORY_ID) VALUES
  ('S001', 'New Look Slim', 100, 0, SYSDATE(), 'jeans'),
  ('S002', 'ASOS Slim Twill', 150, 1, SYSDATE(), 'shirts'),
  ('S003', 'Edwin ED-80 Slim', 70, 0, SYSDATE(), 'jeans'),
  ('S004', 'PUMA Ignite Dual', 240, 0, SYSDATE(), 'shoes'),
  ('S005', 'Farah Oxford Shirt', 320, 0, SYSDATE(), 'shirts'),
  ('S006', 'River Island Regular', 130, 0, SYSDATE(), 'shirts'),
  ('S007', 'PUMA Fashin Alt', 390, 1, SYSDATE(), 'shoes'),
  ('S008', 'Pull&Bear Slim', 260, 1, SYSDATE(), 'jeans'),
  ('S009', 'Reebok Ros', 210, 0, SYSDATE(), 'shoes'),
  ('S0010', 'Selected Homme', 170, 0, SYSDATE(), 'shirts');

INSERT INTO books (ID, BOOK_TITLE, BOOK_AUTHOR, BOOK_PRICE) VALUES
  ('1', 'First Book', 'First Author', '30000'),
  ('2', 'Second Book', 'Second Author', '20000'),
  ('3', 'Third Book', 'Third Author', '15000'),
  ('4', 'Fourth Book', 'Fourth Author', '25000'),
  ('5', 'Fifth Book', 'Fifth Author', '80000'),
  ('6', 'Sixth Book', 'Sixth Author', '50000');
*/