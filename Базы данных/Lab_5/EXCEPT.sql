USE SampleDb;
SELECT EmpId From Works_on WHERE YEAR(EnterDate) = 2023 AND MONTH(EnterDate) = 3
EXCEPT
SELECT EmpId FROM Employee WHERE DepartmentNumber IS NULL