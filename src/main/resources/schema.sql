DROP TABLE IF EXISTS task;

CREATE TABLE task (
  id INTEGER PRIMARY KEY,
  title VARCHAR(32) NOT NULL,
  body VARCHAR(1024) NOT NULL,
  status INTEGER NOT NULL,
  created_on DATE NOT NULL
);