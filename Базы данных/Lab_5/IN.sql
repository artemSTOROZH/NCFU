USE Dismissal;
SELECT EmpID FROM Employee WHERE EmpID IN
(SELECT EmpID FROM DismissalDocument WHERE ArticleID = 1)