-- 1. Display the last name and salary of employees who earn between $5,000 
-- and $12,000 and are in department 300 or 500. 
-- Label the columns Employee and Monthly Salary, respectively:

select lastName Employee, salary  MonthlySalary, departmentId
from employees
where salary between 5000 and 12000
and departmentId in (300, 500);

-- 2. The HR department needs a report that displays the last name and hire date 
-- for all employees who were hired in 2020:

select lastName, hireDate 
from employees
where Year(hireDate) = 2020;

-- 3. Create a report to display the last name and jobId of all employees 
-- who's manager ID is 2021:

select lastName, jobId
from employees
where managerId = 2021;

-- 4. Create a report to display the last name, salary, and commission 
-- of all employees who earn commissions:

select lastName, salary, commission_pct
from employees
where commission_pct is not null;

-- 5. Change the last name of employee 3 to Drexler:

update employees
set lastName = "Drexler"
where employeeId = 3001;

select * from employees;
-- 6. Change the salary to $2,500 for all employees who have a salary less than $2,500:

update employees
set salary = 2500
where salary < 2500;

-- 7. Delete Juliet Truimph from the EMPLOYEE table:

select * from employees;

delete from employees
where firstName = "Juliet"
and lastName = "Truimph";


-- 8. Empty the table EMPLOYEE:
truncate table employees;