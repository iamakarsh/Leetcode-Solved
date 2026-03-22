# Write your MySQL query statement below
with ranks as  (
    select score,
    dense_rank() over (order by score desc) as`rank` 
    from scores )
select score,`rank` from ranks;