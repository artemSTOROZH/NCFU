USE Dismissal
GO
CREATE PROCEDURE Modify_DismissalDocument (@TargetID INTEGER , @NewDocumentID INTEGER, @NewNumber VARCHAR(4), @NewRegDate DATE, @NewDismissalDate DATE, @NewArticleID INTEGER, @NewEmpID INTEGER, @NewCompensation DECIMAL(10, 4))
AS UPDATE DismissalDocument
SET 
DocumentID = @NewDocumentID,
Number = @NewNumber,
RegDate = @NewRegDate,
DismissalDate = @NewDismissalDate,
ArticleID = @NewArticleID,
EmpID = @NewEmpID,
Compensation = @NewCompensation
WHERE DocumentID = @TargetID
