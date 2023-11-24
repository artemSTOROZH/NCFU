USE Dismissal
SELECT Employee.*, DismissalArticle.Reason FROM Employee
JOIN DismissalDocument ON Employee.EmpID = DismissalDocument.EmpID
JOIN DismissalArticle ON DismissalArticle.ArticleID = DismissalDocument.ArticleID
ORDER BY Reason