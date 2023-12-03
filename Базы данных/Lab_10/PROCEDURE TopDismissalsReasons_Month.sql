USE Dismissal
GO
CREATE PROCEDURE TopDismissalReasons_Month(@Month CHAR(2))
AS BEGIN
SELECT Reason, COUNT(*) AS 'DismissalNumber' FROM dbo.Get_DismissalReason_InPeriod(DATEFROMPARTS(YEAR(GETDATE()), @Month, 1), DATEFROMPARTS(YEAR(GETDATE()), @Month + 1, 1))
GROUP BY Reason
ORDER BY COUNT(*) DESC
END