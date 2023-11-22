USE DISMISSAL
SELECT DocumentID, RegDate, DismissalDate, EmpID, DismissalDocument.ArticleID, DismissalArticle.Name FROM DismissalDocument
LEFT JOIN DismissalArticle ON DismissalDocument.ArticleID = DismissalArticle.ArticleID