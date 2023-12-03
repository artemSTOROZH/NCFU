USE Dismissal
GO
CREATE FUNCTION Get_DismissalReason_InPeriod(@StartDismissalDate DATE, @EndDismissalDate DATE)
RETURNS TABLE
AS RETURN
(
SELECT DismissalDocument.EmpID, Reason, DismissalDate FROM DismissalDocument
JOIN DismissalArticle ON DismissalDocument.ArticleID = DismissalArticle.ArticleID WHERE EmpID IS NOT NULL AND
DismissalDate >= @StartDismissalDate AND DismissalDate <= @EndDismissalDate
)