USE Dismissal
SELECT  DepartmentName, COUNT(*) AS '���������� �����������' FROM Employee WHERE DepartmentName IS NOT NULL
Group BY DepartmentName
ORDER BY '���������� �����������' 