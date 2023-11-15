USE SampleDb;
SELECT EmpId, LastName, FirstName FROM Employee e
JOIN Department d ON d.DepartmentNumber = e.DepartmentNumber 
WHERE DepartmentName = 'Human Resources'