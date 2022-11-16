-- 1. Find the highest, lowest, sum, and average salary of all employees. 
-- Label the columns Maximum, Minimum, Sum, and Average, respectively:

select max(salary) "Maximum", min(salary) "Minimum", sum(salary) "Sum", avg(salary) "Average"
from employees;

-- 2. Display the minimum, maximum, sum, and average salary for each job type:

select min(salary) "Minimum", max(salary) "Maximum", sum(salary) "Sum", avg(salary) "Average"
from employees
group by departmentId;

-- 3. Write a query to display the number of people with the same job:

select count(employeeId)
from employees
group by jobId;

-- 4. Determine the number of managers without listing them. 
-- Label the column Number of Managers:

select count(managerId) "Number of Managers"
from employees;

select managerId, count(*) "Number of Managers"
from employees
group by managerId;

-- 5. Find the difference between the highest and lowest salaries. 
-- Label the column DIFFERENCE:

select max(salary) - min(salary) DIFFERENCE
from employees;