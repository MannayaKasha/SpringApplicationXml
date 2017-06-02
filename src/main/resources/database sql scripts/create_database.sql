CREATE DATABASE `calories_counter`
  DEFAULT CHARACTER SET utf8;

GRANT CREATE, SELECT, INSERT, UPDATE, DELETE, ALTER
ON `calories_counter`.*
TO mannaya_kasha@localhost
IDENTIFIED BY 'mannaya_kasha_password';

GRANT CREATE, SELECT, INSERT, UPDATE, DELETE, ALTER
ON `calories_counter`.*
TO mannaya_kasha@'%'
IDENTIFIED BY 'mannaya_kasha_password';