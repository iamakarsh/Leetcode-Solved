# Write your MySQL query statement below
SELECT query_name,
       round( SUM(rating * 1.0 / position) / COUNT(*),2) AS quality,
       ROUND(100 * SUM(rating < 3) / COUNT(*), 2) AS poor_query_percentage
FROM queries
GROUP BY query_name;