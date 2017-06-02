-- Table: users
CREATE TABLE users (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  calories_per_day INT  NULL
)
  ENGINE = InnoDB DEFAULT CHARACTER SET utf8;

-- Table: roles
CREATE TABLE roles (
  id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB DEFAULT CHARACTER SET utf8;

-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),

  UNIQUE (user_id, role_id)
)
  ENGINE = InnoDB DEFAULT CHARACTER SET utf8;

-- Table: ingestion
CREATE TABLE ingestion (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB DEFAULT CHARACTER SET utf8;

-- Table: food
CREATE TABLE food (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  fats DOUBLE NOT NULL,
  proteins DOUBLE NOT NULL,
  carbohydrates DOUBLE NOT NULL,
  calories INT NOT NULL
)
  ENGINE = InnoDB DEFAULT CHARACTER SET utf8;

-- Table: meal
CREATE TABLE meal (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  date_time TIMESTAMP NOT NULL,
  ingestion_id INT NOT NULL,
  food_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (ingestion_id) REFERENCES ingestion (id),
  FOREIGN KEY (food_id) REFERENCES food (id)
)
  ENGINE = InnoDB DEFAULT CHARACTER SET utf8;

/*CREATE TABLE meal (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  date_time TIMESTAMP NOT NULL,
  ingestion_id INT NOT NULL,
  food_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (ingestion_id) REFERENCES ingestion (id),
  FOREIGN KEY (food_id) REFERENCES food (id)
)
  ENGINE = InnoDB DEFAULT CHARACTER SET utf8;*/

