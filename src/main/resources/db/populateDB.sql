DELETE FROM user_roles;
DELETE FROM records;
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

INSERT INTO objectives (name, user_id) VALUES
  ('Работа', 100000),
  ('Учеба', 100000),
  ('Спорт', 100000),
  ('Работа', 100001),
  ('Учеба', 100001);

INSERT INTO records (date, done, objective_id) VALUES
  ('2016-10-01', TRUE, 100002),
  ('2016-10-02', TRUE, 100002),
  ('2016-10-03', TRUE, 100002),
  ('2016-10-01', TRUE, 100003),
  ('2016-10-03', TRUE, 100003),
  ('2016-10-01', TRUE, 100004),
  ('2016-10-02', TRUE, 100004),
  ('2016-10-02', TRUE, 100005),
  ('2016-10-03', TRUE, 100006);