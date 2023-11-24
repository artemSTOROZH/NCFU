USE Dismissal
GO
CREATE PROCEDURE delete_DismissalDocument(@TargetID INTEGER)
AS DELETE FROM DismissalDocument WHERE DocumentID = @TargetID