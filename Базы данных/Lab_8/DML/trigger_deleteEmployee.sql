GO
CREATE TRIGGER trigger_deleteEmployee
ON Employee AFTER DELETE
AS BEGIN
PRINT '�������� ����������� ���������'
ROLLBACK TRANSACTION
END