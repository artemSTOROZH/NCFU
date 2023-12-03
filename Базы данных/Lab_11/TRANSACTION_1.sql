USE Dismissal
BEGIN TRANSACTION;
INSERT INTO Employee VALUES(2024, 'Osipov', 'Aleksandr', 'Grigorievich', 'Programmer III', 'Research and Development', '2018-10-11')
SAVE TRANSACTION TRAN_1;

INSERT INTO Employee VALUES(2025, 'Filchenko', 'Alla', 'Vladimirovna', 'Recruiter', 'Training', '2017-12-01')

UPDATE Employee SET EnterDate = '2017-10-11' WHERE EmpID = 2024
SAVE TRANSACTION TRAN_2;

ROLLBACK TRANSACTION TRAN_1;
COMMIT TRANSACTION;