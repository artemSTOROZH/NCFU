USE SampleDb;
SELECT MIN(EnterDate) AS "Первый и последний принятые в проект" FROM Works_on
UNION
SELECT MAX(EnterDate) From Works_on