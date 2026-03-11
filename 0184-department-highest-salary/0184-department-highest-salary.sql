# Write your MySQL query statement below
-- using cte
with maxsalary as(select departmentId,max(salary) as max_salary from employee group by departmentId)
select d.name as department,e.name as employee,e.salary as salary from employee e
join maxsalary m on e.departmentId=m.departmentId and e.salary=m.max_salary
join department d on e.departmentId=d.id;