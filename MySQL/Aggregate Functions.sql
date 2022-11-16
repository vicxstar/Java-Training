/*
Aggregate function
multiple row input  -> function() -> one output
sum(), count(),max(),min(),avg()
*/

select * from departments;

select sum(salary) "Total Salary to Entire Organisation"
from employees;

select count(departmentId) "Total Departments in Organisation"
from departments;

select min(salary) "Minimum Salary in Entire Organisation",
max(salary) "Maximum Salary in Entire Organisation",
avg(salary) "Average Salary in an Organisation"
from employees;

select min(salary) "Minimum Salary in HR Department",
max(salary) "Maximum Salary in HR Department",
avg(salary) "Average Salary in HR Department"
from employees
where departmentId="200";