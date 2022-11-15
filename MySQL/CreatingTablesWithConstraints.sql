-- drop existing tables:
drop table Department;
drop table employee;

-- create table:
create table Departments(
departmentId int primary key,
departmentName varchar(30) not null,
managerId int,
locationId int);
-- insert values:
insert into Departments
values(100, "Sales", 1011, 1000),
(200, "HR", 2011, 2000),
(300, "Customer Service", 3011, 3000),
(400, "Finance", 4011, 4000),
(500, "Disciplinary", 5011, 5000);

-- create table:
create table Jobs(
jobId varchar(10) primary key,
jobTitle varchar(15) not null,
minSalary int,
maxSalary int);

-- insert values:
insert into Jobs
values(10, "Manager", 2000, 4000),
(20, "Assistant", 1000, 3000),
(30, "Executive", 4000, 6000),
(40, "CEO", 10000, 30000),
(50, "Trainee", 500, 1500);

-- create table:
create table Employees(
employeeId int primary key,
firstName varchar(20),
lastName varchar(25) not null,
email varchar(20) not null,
phoneNumber varchar(20),
hireDate date not null,
jobId varchar(10),
salary double,
commission_pct double,
managerId int,
departmentId int,
constraint jobId_FK
foreign key(jobId) references Jobs(jobId),
constraint deptId_FK
foreign key(departmentId) references Departments(departmentId));

-- insert values:
insert into Employees
values (3001, "Vic", "Ayo", "vickiayo@email.com", 079123456765, "2020-01-21", 30, 5000, 100.00, 3021, 300),
(1001, "Jen", "Smart", "jensmart@email.com", 078323476125, "2020-05-15", 10, 3000, 90.00, 1021, 100),
(4001, "Dorcas", "English", "dorcaseng@email.com", 079123456765, "2010-11-10", 40, 20000, 1000.00, 4021, 400),
(2001, "Juliet", "Truimph", "julietri@email.com", 079123456765, "2022-10-23", 20, 2000, 80.00, 2021, 200),
(5001, "James", "Kempt", "jamesk@email.com", 079123456765, "2019-03-03", 50, 1500, 20.00, 5021, 500);