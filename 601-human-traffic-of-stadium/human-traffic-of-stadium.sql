# Write your MySQL query statement below
SELECT *
FROM Stadium
WHERE id IN (
    SELECT s1.id
    FROM Stadium s1
    JOIN Stadium s2 ON s1.id + 1 = s2.id
    JOIN Stadium s3 ON s1.id + 2 = s3.id
    WHERE s1.people >= 100
    AND s2.people >= 100
    AND s3.people >= 100
    UNION
    SELECT s2.id
    FROM Stadium s1
    JOIN Stadium s2 ON s1.id + 1 = s2.id
    JOIN Stadium s3 ON s1.id + 2 = s3.id
    WHERE s1.people >= 100
    AND s2.people >= 100
    AND s3.people >= 100
    UNION
    SELECT s3.id
    FROM Stadium s1
    JOIN Stadium s2 ON s1.id + 1 = s2.id
    JOIN Stadium s3 ON s1.id + 2 = s3.id
    WHERE s1.people >= 100
    AND s2.people >= 100
    AND s3.people >= 100
)
ORDER BY visit_date;