USE dismissal;
SELECT ArticleID AS '����� ������ ������ ����������' FROM DismissalDocument
GROUP BY ArticleID
HAVING COUNT(ArticleID) > 50
ORDER BY ArticleID