USE Dismissal
GO
CREATE PROCEDURE SELECT_Employees_WithCompensationMoreThan_X(@TargetCompensation DECIMAL(10, 4))
AS BEGIN
SELECT Employee.EmpID, LastName, FirstName, JobTitle, DepartmentName, DocumentID, Number, RegDate, DismissalDate, Compensation FROM Employee
JOIN DismissalDocument ON Employee.EmpID = DismissalDocument.EmpID WHERE Compensation > @TargetCompensation
ORDER BY Compensation
END