USE Dismissal;
SELECT MAX(RegDate) AS '���� ���������� ���������� � ����� ����������' FROM DismissalDocument
UNION
SELECT MAX(EnterDate) From Employee