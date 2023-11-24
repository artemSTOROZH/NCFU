USE Dismissal
SELECT  DepartmentName, COUNT(*) AS 'Количество сотрудников' FROM Employee WHERE DepartmentName IS NOT NULL
Group BY DepartmentName
ORDER BY 'Количество сотрудников' 