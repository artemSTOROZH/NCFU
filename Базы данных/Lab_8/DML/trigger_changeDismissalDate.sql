USE Dismissal
GO
CREATE TABLE Changes_DismissalDate(
DocumentID INTEGER NOT NULL,
UserName VARCHAR(20) NULL,
DateOfChange DATE NULL,
DismissalDateNew DATE NULL, 
DismissalDateOld DATE NULL
)
GO
CREATE TRIGGER trigger_changeDismissalDate
ON DismissalDocument AFTER UPDATE
AS IF UPDATE(DismissalDate)
BEGIN
DECLARE @DocumentID INTEGER
DECLARE @DismissalDateNew DATE
DECLARE @DismissalDateOld DATE
SELECT @DocumentID = (SELECT DocumentID FROM deleted)
SELECT @DismissalDateOld = (SELECT DismissalDate FROM deleted)
SELECT @DismissalDateNew = (SELECT DismissalDate FROM inserted)
INSERT INTO Changes_DismissalDate values(@DocumentID, USER_NAME(), GETDATE(), @DismissalDateOld, @DismissalDateNew)
END