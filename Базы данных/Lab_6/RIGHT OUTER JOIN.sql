USE SampleDb;
SELECT Department.*, Employee.EmpId, Employee.FirstName, Employee.LastName FROM Employee 
RIGHT OUTER JOIN Department ON Employee.DepartmentNumber = Department.DepartmentNumber
ORDER BY EmpId