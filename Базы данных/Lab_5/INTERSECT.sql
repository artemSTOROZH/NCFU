USE Dismissal;
SELECT EmpID AS '��������, ��������� � �������' FROM DismissalDocument 
WHERE DismissalDate > '2023-08-01'
INTERSECT
SELECT EmpID  FROM Employee
WHERE JobTitle LIKE '%Engineer%'