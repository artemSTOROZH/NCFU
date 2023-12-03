GO
CREATE TRIGGER trigger_deleteEmployee
ON Employee AFTER DELETE
AS BEGIN
PRINT 'Удаление сотрудников запрещено'
ROLLBACK TRANSACTION
END