GO
GRANT VIEW SERVER STATE TO User_1;

GO 
CREATE TRIGGER trigger_ConnectionLimit
ON ALL SERVER WITH EXECUTE AS 'User_1'
FOR LOGON AS
BEGIN
IF ORIGINAL_LOGIN() = '14159' AND
(SELECT COUNT(*) FROM sys.dm_exec_sessions
WHERE is_user_process = 1 AND
original_login_name = '14159') > 2
ROLLBACK;
END;
