DELETE FROM user_roles;
DELETE FROM objectives;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password');

INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO objectives (date, name, done, user_id) VALUES
  ('2016-10-01', 'Работа', TRUE, 100000),
  ('2016-10-02', 'Работа', TRUE, 100000),
  ('2016-10-03', 'Работа', TRUE, 100000),
  ('2016-10-01', 'Учеба', TRUE, 100000),
  ('2016-10-03', 'Учеба', TRUE, 100000),
  ('2016-10-01', 'Спорт', TRUE, 100000),
  ('2016-10-02', 'Спорт', TRUE, 100000),
  ('2016-10-02', 'Работа', TRUE, 100001),
  ('2016-10-03', 'Учеба', TRUE, 100001);