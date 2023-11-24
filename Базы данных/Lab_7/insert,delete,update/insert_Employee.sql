USE Dismissal
GO
CREATE PROCEDURE insert_employee(@LastName NVARCHAR(30) = NULL, @FirstName NVARCHAR(25) = NULL, @MiddleName NVARCHAR(25) = NULL, @JobTitle NVARCHAR(40) = NULL, @DepartmentName NVARCHAR(30) = NULL, @EnterDate DATE = NULL)
AS BEGIN
SELECT MAX(EmpID) FROM Employee
DECLARE @EmpID INTEGER;
SELECT @EmpID = MAX(EmpID) FROM Employee
SET @EmpID = @EmpID + 1
INSERT INTO Employee values(@EmpID, @LastName, @FirstName, @MiddleName, @JobTitle, @DepartmentName, @EnterDate)
END