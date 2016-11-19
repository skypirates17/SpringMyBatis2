--create database
CREATE DATABASE "School"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'English_Republic of the Philippines.1252'
       LC_CTYPE = 'English_Republic of the Philippines.1252'
       CONNECTION LIMIT = -1;

--create table
DROP TABLE IF EXISTS student_info;
CREATE TABLE student_info
(
  student_id SERIAL PRIMARY KEY,
  student_name character varying (100),
  student_age character varying (5),
  student_address character varying(255)
);

--insertion of records
INSERT INTO student_info (student_name,student_age, student_address) VALUES
('JOHNREY','21','ANTIPOLO'),
('DOROTHY','25','CALOOCAN'),
('RYAN','33','BULACAN');