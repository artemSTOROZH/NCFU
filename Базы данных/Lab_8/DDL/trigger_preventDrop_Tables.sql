GO 
CREATE TRIGGER trigger_preventDrop_Tables
ON DATABASE FOR DROP_TABLE
AS BEGIN
PRINT 'Чтобы удалять таблицы, необходимо отключить триггер trigger_preventDrop_Tables'
ROLLBACK
END