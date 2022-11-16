use WileyDI001;

-- joining is a way to access data from multiple tables without the use of PKs or FKs:
select departmentName, jobTitle
from departments inner join jobs;

-- SUJATA'S EXAMPLE:
-- create tables:
-- auto-increment means that the value of 'member_id' will increase by 1 when a new value is inputted:
CREATE TABLE members (
    member_id INT AUTO_INCREMENT,
    name VARCHAR(100),
    PRIMARY KEY (member_id)
);

-- auto-increment means that the value of 'committee_id' will increase by 1 when a new value is inputted:
CREATE TABLE committees (
    committee_id INT AUTO_INCREMENT,
    name VARCHAR(100),
    PRIMARY KEY (committee_id)
);

-- insert values:
INSERT INTO members(name)
VALUES('John'),('Jane'),('Mary'),('David'),('Amelia');

INSERT INTO committees(name)
VALUES('John'),('Mary'),('Amelia'),('Joe');

select * from members;
select * from committees;

-- inner join:
-- the USING clause can be used if both the tables have the same columns in 
-- respect to the name, size, and data type
select member_id,m.name,committee_id,c.name
from members m inner join committees c
USING(name);

-- MY EXAMPLE:
select d.departmentName, jobTitle, salary
from departments d, jobs, employees;