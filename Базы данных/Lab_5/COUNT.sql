USE Dismissal;
Select COUNT(*) AS 'Сотрудники, нанятые в первой половине 2022 года' FROM Employee 
WHERE YEAR(EnterDate) = 2022 AND MONTH(EnterDate) < 6