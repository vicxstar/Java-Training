-- 1. The HR department wants a query to display the last name, job code, hire date, and employee number for each employee, 
	-- with employee number appearing first. Provide an alias STARTDATE for the HIRE_DATE column:

select firstName, lastName, jobId, hireDate startdate, phoneNumber
from employees
order by phoneNumber;

-- 2. The HR department has requested a report of all employees and their job IDs. 
	-- Display the last name concatenated with the job ID (separated by a comma and space) and name the column Employee and Title:

select concat(lastName, ", ", jobId ) as "Employee and Title"
from employees;

-- 3. To familiarize yourself with the data in the EMPLOYEES table, create a query to display all the data from that table. 
	-- Separate each column output by a comma. Name the column title THE_OUTPUT:
    
    select concat(firstname, ", ", lastName, ", ", email, ", ", phoneNumber, ", ", hireDate, ", ", jobId, ", ", salary, ", ", commission_pct, ", ", managerId, ", ", departmentId) "THE_OUTPUT"
    from employees;
    
-- 4. HR department needs a report that displays the last name and salary of employees who earn more than $12,000:

select lastName, salary
from employees
where salary > 12000;

-- 5. Create a report to display the last name, job ID, and start date for the employees with the last names of Matos and Taylor:

select lastName, jobId, hireDate
from employees
where lastName = "Matos" or lastName = "Taylor";