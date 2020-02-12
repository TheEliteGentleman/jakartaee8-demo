CREATE USER 'tutorial_user'@'localhost' IDENTIFIED BY 'Tut0r1alD3mo';
CREATE SCHEMA IF NOT EXISTS tutorial CHARACTER SET utf8mb4;
GRANT ALL ON tutorial.* TO 'tutorial_user'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;
