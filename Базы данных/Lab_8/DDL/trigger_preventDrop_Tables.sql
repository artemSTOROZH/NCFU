GO 
CREATE TRIGGER trigger_preventDrop_Tables
ON DATABASE FOR DROP_TABLE
AS BEGIN
PRINT '����� ������� �������, ���������� ��������� ������� trigger_preventDrop_Tables'
ROLLBACK
END