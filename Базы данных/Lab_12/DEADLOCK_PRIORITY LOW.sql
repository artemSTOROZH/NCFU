USE Dismissal
BEGIN TRANSACTION SET DEADLOCK_PRIORITY LOW
UPDATE DismissalDocument
SET Number = 2045 WHERE EmpID = 8

WAITFOR DELAY '00:00:10'

UPDATE Employee
SET JobTitle = 'Recruiter' WHERE EmpID = 5

COMMIT TRANSACTION
