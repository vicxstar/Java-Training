select * from employees;
/*
Default sort order is : Ascending
use desc for descending order sorting
*/
select * 
from employees
order by departmentId;

select * 
from employees
order by departmentId desc;

select *
from employees
order by departmentId desc, hireDate;

select *
from employees
order by departmentId desc, salary desc;

select firstName, lastName
from employees
where departmentId = 100
order by salary;

/*
select <projection column list>
from <tablename>
where <selection condition>
order by <column list for sort order> asc/desc
*/