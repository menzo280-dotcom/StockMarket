CREATE USER 'developer'@'localhost' IDENTIFIED BY '1234567';
GRANT ALL PRIVILEGES ON stockmarket.* TO 'developer'@'localhost';
FLUSH PRIVILEGES;