DROP table if EXISTS order_;
CREATE TABLE order_(
  id INT AUTO_INCREMENT,
  uid INT,
  PRIMARY KEY (id)
);

DROP table if EXISTS orderitem;
CREATE TABLE orderitem(
  id INT AUTO_INCREMENT,
  pid INT,
  num INT,
  oid int,
  PRIMARY KEY (id)
);