USE Dismissal
GO 
CREATE PROCEDURE AVGCompensation_ByMonths(@Year CHAR(4))
AS BEGIN
DECLARE @MonthNumber INTEGER = 1;
DECLARE @AVG_Comp DECIMAL(10, 4);
WHILE @MonthNumber < 13
BEGIN
IF @MonthNumber <> 12
SELECT @AVG_Comp = dbo.AVG_Compensation(DATEFROMPARTS(@Year, @MonthNumber, 1), DATEFROMPARTS(@Year, @MonthNumber + 1, 1));
ELSE
SELECT @AVG_Comp = dbo.AVG_Compensation(DATEFROMPARTS(@Year, @MonthNumber, 1), DATEFROMPARTS(@Year + 1, 1, 1));
IF (@MonthNumber = 1)
BEGIN
SELECT DATENAME(MONTH, DATEFROMPARTS(@Year, @MonthNumber, 1)) AS 'Month', @AVG_Comp AS 'AverageCompensation' INTO #AVGCompensations;
SELECT @MonthNumber = @MonthNumber + 1;
END
INSERT INTO #AVGCompensations VALUES(DATENAME(MONTH, DATEFROMPARTS(@Year, @MonthNumber, 1)), @AVG_Comp)
SELECT @MonthNumber = @MonthNumber + 1
END
SELECT * FROM #AVGCompensations;
DROP TABLE #AVGCompensations;
END