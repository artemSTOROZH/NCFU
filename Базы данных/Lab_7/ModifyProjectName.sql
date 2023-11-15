USE SampleDb;
GO
CREATE PROCEDURE ModifyProjectName(@Number INTEGER, @newName CHAR(40))
AS UPDATE Projects
SET ProjectName = @newName 
WHERE ProjectNumber = @Number