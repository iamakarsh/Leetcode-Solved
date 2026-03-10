# Write your MySQL query statement below
SELECT t1.stock_name, t2.sell-t1.buy as capital_gain_loss
FROM 
(
    SELECT stock_name, SUM(price) AS buy
    FROM stocks
    WHERE operation = 'Buy'
    GROUP BY stock_name
) AS t1
JOIN
(
    SELECT stock_name, SUM(price) AS sell
    FROM stocks
    WHERE operation = 'Sell'
    GROUP BY stock_name
) AS t2
ON t1.stock_name = t2.stock_name;