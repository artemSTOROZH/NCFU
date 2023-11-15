USE SampleDb;
SELECT  Employee.*, DepartmentName, DepLocation FROM Employee
INNER JOIN Department ON Employee.DepartmentNumber = Department.DepartmentNumber
ORDER BY EmpId