CREATE DATABASE your_database;
USE your_database;

CREATE TABLE employees (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(50)
);

INSERT INTO employees (id, name, department) VALUES (1, 'John Doe', 'HR');
INSERT INTO employees (id, name, department) VALUES (2, 'Jane Smith', 'IT');
