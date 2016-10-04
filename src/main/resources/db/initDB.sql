DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS records;
DROP TABLE IF EXISTS objectives;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  email      VARCHAR NOT NULL,
  password   VARCHAR NOT NULL,
  registered TIMESTAMP DEFAULT now(),
  enabled    BOOL DEFAULT TRUE
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE objectives (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id     INTEGER NOT NULL,
  name TEXT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX objective_unique_user_objective_name ON objectives(user_id, name);

CREATE TABLE records (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  objective_id     INTEGER NOT NULL,
  date    DATE NOT NULL,
  done    BOOLEAN NOT NULL,
  FOREIGN KEY (objective_id) REFERENCES objectives (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX records_unique_objective_date ON records(objective_id, date);