CREATE TABLE resto_category (
  id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE resto_dish (
  id INT PRIMARY KEY,
  description TEXT,
  image_url TEXT,
  ingredients TEXT,
  name VARCHAR(255) NOT NULL,
  price DECIMAL(10, 2) NOT NULL,
  category_id INT,
  FOREIGN KEY (category_id) REFERENCES resto_category(id)
);

CREATE TABLE resto_order (
  id INT PRIMARY KEY,
  status VARCHAR(255) NOT NULL,
  customer_id INT DEFAULT NULL,
  order_date DATE NOT NULL
);

CREATE TABLE resto_order_item (
  id INT PRIMARY KEY,
  image_url TEXT,
  name VARCHAR(255) NOT NULL,
  note TEXT DEFAULT NULL,
  price DECIMAL(10, 2) NOT NULL,
  quantity INT NOT NULL,
  order_id INT,
  FOREIGN KEY (order_id) REFERENCES resto_order(id)
);
