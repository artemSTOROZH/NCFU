USE Dismissal
SELECT DocumentID, EmpID, RegDate, DismissalDate FROM DIsmissalDocument 
WHERE EmpID IN
(SELECT EmpID FROM Employee WHERE YEAR(EnterDate) = 2022
EXCEPT
SELECT EmpID FROM Employee WHERE DepartmentName = 'Accounting'
)