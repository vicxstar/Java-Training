-- view the data in the tables:
select * from departments;
select * from jobs;
select * from employees;

-- show the name of tables in current database
show tables;

-- shows the structure of the table
describe Departments;

-- to view the constaints in a table:
select table_name, constraint_type, constraint_name
from information_schema.table_constraints
where table_name='Departments';

-- to give a column an alis name and view the data inside it:
select departmentId as dept_id
from departments;

-- or:

-- to give a column an alis name and view the data inside it:
select departmentId dept_id
from departments;

-- to concat (join) strings with values from a table:
select concat(firstName," ", lastName, " has worked in the company since", " ", hireDate)
from employees;

-- operations:
-- Relational operators: =, ==, <, >, <=, >=, !=, NULL, NOT NULL
select firstName "First Name", lastName "Last Name", salary
from employees
where salary > 100;

-- or:

select * 
from jobs
where jobTitle = "ceo";

-- or:

select *
from employees
where managerId is not null;

-- Logical operators: NOT, AND, OR, BETWEEN:
select *
from employees
where not departmentName = "Sales";

-- or:
select *
from jobs
where jobId = 10 or jobId = 50; 

-- Arithmetic operators: +, -, *, /, DIV, MOD:
select * 
from departments
where locationId = 3000 + 1000;