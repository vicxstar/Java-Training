use wileydi001;

select * from employees;

-- the 'update' keyword is used to update values in a table: 
update employees
set salary=salary+100
where employeeId=101;

-- used to disable the safe update and enables the execution of 
-- an UPDATE or DELETE statement without a WHERE clause:
SET SQL_SAFE_UPDATES = 0;

select * from jobs;

update jobs
set jobTitle = concat("Sr. ",jobTitle)
where jobId = 10;

delete from employees
where salary=1500;

select * from employees;

insert into employees
values(5001, "James", "Kempt", "jamesk@email.com", 079123456765, "2019-03-03", 50, 1500, 20.00, 5021, 500);