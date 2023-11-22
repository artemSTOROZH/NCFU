USE Dismissal;
SELECT DocumentID, DismissalDocument.Number, EmpID, RegDate, DismissalDate, DismissalDocument.ArticleID, DismissalArticle.Name, DismissalArticle.Number, ParagraphNumber, DismissalReason FROM DismissalDocument
JOIN DismissalArticle ON DismissalDocument.ArticleID = DismissalArticle.ArticleID