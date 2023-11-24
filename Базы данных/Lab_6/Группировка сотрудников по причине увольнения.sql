USE Dismissal
SELECT COUNT(*) AS 'Кол - во сотрудников', DismissalArticle.Reason FROM Employee
JOIN DismissalDocument ON Employee.EmpID = DismissalDocument.EmpID
JOIN DismissalArticle ON DismissalArticle.ArticleID = DismissalDocument.ArticleID
GROUP BY Reason
ORDER BY COUNT(*)