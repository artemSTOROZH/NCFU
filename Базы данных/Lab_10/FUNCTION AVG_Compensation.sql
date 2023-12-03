USE Dismissal
GO
CREATE FUNCTION AVG_Compensation(@StartDisDate DATE, @EndDisDate DATE)
RETURNS DECIMAL(10, 4)
BEGIN
DECLARE @AvgComp DECIMAL(10, 4)
SELECT @AvgComp = AVG(Compensation) FROM DismissalDocument
WHERE DismissalDate IS NOT NULL AND DismissalDocument.DismissalDate >= @StartDisDate AND DismissalDocument.DismissalDate <= @EndDisDate
RETURN @AvgComp
END