# Write your MySQL query statement below
-- select d.name as department, e.name as employee, e.salary
-- from employee e
-- join department d
-- on e.departmentid = d.id
-- where 3 > (
--     select count(distinct e2.salary)
--     from employee e2
--     where e2.departmentid = e.departmentid
--     and e2.salary > e.salary
-- );

-- using cte
with empcte as( select e.id,e.name,e.salary,e.departmentId from employee e)
select d.name as department,e1.name as employee,e1.salary as salary from empcte e1
join department d on e1.departmentId=d.id where(select count(distinct e2.salary) from empcte e2 where e2.departmentId=e1.departmentId and e2.salary>e1.salary)<3;