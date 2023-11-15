USE SampleDb;
SELECT Employee.*, Department.* FROM Employee CROSS JOIN Department
WHERE EmpId < 100 AND Department.DepartmentNumber < 100
ORDER BY LastName, FirstName