USE SampleDb;
SELECT ProjectNumber FROM Works_on
GROUP BY ProjectNumber
HAVING COUNT(*) > 4