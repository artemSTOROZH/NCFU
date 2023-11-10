USE SampleDb;
GO
CREATE TRIGGER Projects_INSERT_UPDATE
ON Projects
AFTER INSERT, UPDATE
AS
UPDATE Projects
SET Budget = Budget + Budget * 0.13
WHERE ProjectNumber = (SELECT ProjectNumber FROM inserted)