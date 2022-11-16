select * from employees;

select departmentId, sum(salary) "Total Salary"
from employees
group by departmentId;

/* name : 3 row output,group value : 1 row, sum(salary) : 1 row  
Incorrect output : as we are trying to display multi row output with single row output
*/
select departmentId, sum(salary) "Total Salary"
from employees
group by departmentId;   -- we created groups


select departmentId, sum(salary) "Total Salary"
from employees
group by departmentId
having sum(salary)<10000;