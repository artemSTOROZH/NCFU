USE Dismissal

GO
CREATE SCHEMA Views_Dismissal AUTHORIZATION Administrator_1

GO 
CREATE VIEW View_Enter_DismissalDates
AS SELECT Employee.EmpID, EnterDate, DismissalDate FROM Employee
JOIN DismissalDocument ON Employee.EmpID = DismissalDocument.EmpID

GO
CREATE VIEW View_Job_Department
AS SELECT Employee.EmpID, LastName, FirstName, JobTitle, DepartmentName FROM Employee
JOIN DismissalDocument ON Employee.EmpID = DismissalDocument.EmpID

GO
CREATE VIEW View_DismissalReasons
AS SELECT Employee.EmpID, LastName, FirstName, Reason FROM Employee
JOIN DismissalDocument ON Employee.EmpID = DismissalDocument.EmpID
JOIN DismissalArticle ON DismissalDocument.ArticleID = DismissalArticle.ArticleID

GO 
GRANT SELECT TO User_2
DENY UPDATE TO User_2