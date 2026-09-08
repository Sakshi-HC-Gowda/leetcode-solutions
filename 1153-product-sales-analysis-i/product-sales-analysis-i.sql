# Write your MySQL query statement below
SELECT product_name,year,price
FROM Sales s
LEFT JOIN Product p
on s.product_id=p.product_id;