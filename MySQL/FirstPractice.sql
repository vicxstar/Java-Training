create database WileyDI001; /*creates database called 'WileyDI001'*/
/*drop database WileyDI001_22; /*deletes database called 'WileyDI001_22'*/

/*To create a table: */
create table employee(
employeeId int primary key,
name varchar(30),
designation varchar(30),
department varchar(35),
salary double);

/*To insert rows into table: */
insert into employee(employeeId, name, designation, department, salary)
/*To add values (data) into the table: */
values(101, 'Vic', 'Executive', 'IT', 78000);

/*To add more values at once into the table: */
insert into employee
values(102, 'Lewis', 'Manager', 'Fitness', 40000),
(103, 'Jen', 'Lecturer', 'Academia', 50000),
(104, 'Dorcas', 'Senior Manager', 'Medicine', 100000),
(105,'Olu', 'Freelancer', 'Transportation', 30000);

/*To view the table: */
select * from employee;

/*To create a table: */
create table Department(
Department_ID int primary key,
Department_Name varchar(30),
Manager_ID int,
Location_ID int);

/*To add more values at once into the table: */
insert into Department
values(100, 'Fitness', 1010, 1011),
(200, 'Medicine', 2010, 2011),
(300, 'IT', 3010, 3011),
(400, 'Academia', 4010, 4011),
(500, 'Transportation', 5010, 5011);

/*To view the table: */
select * from department; 

-- 'command' + '/' is a shortcut to adding comments

-- when not adding values to a column, add the key wrd 'null' for that field:
insert into Department
values(600, 'Fitness', null, 6011); -- 'null' means 'not known', not '0'

-- view the table:
select * from department;

-- or to just add values to certain fields, just add the field names you want to insert, followed by their values:
insert into department(Department_ID, Department_Name, Location_ID)
values(700, 'Fitness', 7011);

-- view the table:
select * from department;

-- primary keys cannot be 'null' and are always unique by default
-- indexes are created on primary keys by default, this makes searching faster (Binary Tree search is automatically created)

-- search queries:
select *
from department
where Department_Name = 'Fitness';

-- any insertions that have a duplicated primary key, you can use the 'ignore' keyword to enable the insertion of the values without the duplicated primary key:
insert ignore into Department
values(100, 'Medicine', 1010, 1011),
(800, 'Medicine', 8010, 8011);

-- view the table:
select * from department;