USE dismissal;
SELECT ArticleID AS 'Самые частые статьи увольнения' FROM DismissalDocument
GROUP BY ArticleID
HAVING COUNT(ArticleID) > 50
ORDER BY ArticleID