GO 
CREATE TRIGGER trigger_preventChanges
ON Changes_DismissalDate
FOR INSERT, UPDATE, DELETE
AS BEGIN
PRINT '��������� ���� ������� �� �����������'
ROLLBACK
END