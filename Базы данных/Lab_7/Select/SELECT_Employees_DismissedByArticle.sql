USE Dismissal
GO
CREATE PROCEDURE SELECT_Employees_DismissedByArticle(@ArticleID INTEGER)
AS BEGIN
SELECT Employee.EmpID, LastName, FirstName, JobTitle, DepartmentName, DismissalDocument.DismissalDate, DismissalDocument.Compensation FROM Employee
JOIN DismissalDocument ON Employee.EmpId = DismissalDocument.EmpID 
JOIN DismissalArticle ON DismissalDocument.ArticleID = DismissalArticle.ArticleID WHERE DismissalDocument.ArticleID = @ArticleID
END