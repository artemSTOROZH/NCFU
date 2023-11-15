USE SampleDb;
SELECT ProjectNumber AS "Номер проекта" FROM Projects
WHERE Budget > 300000
INTERSECT
SELECT ProjectNumber FROM Works_on
WHERE YEAR(EnterDate) > 2022 AND MONTH(EnterDate) > 6
GROUP BY ProjectNumber