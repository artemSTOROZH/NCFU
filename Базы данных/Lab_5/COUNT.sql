USE Dismissal;
Select COUNT(*) AS '����������, ������� � ������ �������� 2022 ����' FROM Employee 
WHERE YEAR(EnterDate) = 2022 AND MONTH(EnterDate) < 6