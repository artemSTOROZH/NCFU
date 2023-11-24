USE Dismissal
GO
CREATE PROCEDURE SELECT_Employees_WorkedMoreThan_X_YEARS(@YearsCount INTEGER)
AS BEGIN
SELECT Employee.EmpID, LastName, FirstName, JobTitle, EnterDate, DismissalDate FROM Employee
JOIN DismissalDocument ON DismissalDocument.EmpID = Employee.EmpID WHERE (YEAR(DismissalDate) - YEAR(EnterDate) > @YearsCount)
END