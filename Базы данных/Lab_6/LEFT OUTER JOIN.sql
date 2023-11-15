USE SampleDb;
SELECT Works_on.*, ProjectName, Budget, FirstName, LastName, DepartmentNumber FROM Works_on
LEFT OUTER JOIN Projects ON Works_on.ProjectNumber = Projects.ProjectNumber
LEFT OUTER JOIN Employee ON Works_on.ProjectNumber = Employee.EmpId