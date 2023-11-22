USE Dismissal;
SELECT MAX(RegDate) AS 'Дата последнего увольнения и найма сотрудника' FROM DismissalDocument
UNION
SELECT MAX(EnterDate) From Employee