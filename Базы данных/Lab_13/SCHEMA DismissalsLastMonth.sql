GO
CREATE SCHEMA MonthReports


GO
CREATE VIEW DismissalsLastMonth
AS SELECT        dbo.Employee.EmpId, dbo.Employee.LastName, dbo.Employee.FirstName, dbo.Employee.MiddleName, dbo.Employee.JobTitle, dbo.Employee.DepartmentName
FROM            dbo.Employee INNER JOIN
                         dbo.Get_DismissalReason_InPeriod(DATEFROMPARTS(YEAR(GETDATE()), MONTH(GETDATE()) - 1, DAY(GETDATE())), GETDATE()) AS Get_DismissalReason_InPeriod_1 ON 
                         dbo.Employee.EmpId = Get_DismissalReason_InPeriod_1.EmpID
GROUP BY dbo.Employee.EmpId, dbo.Employee.LastName, dbo.Employee.FirstName, dbo.Employee.MiddleName, dbo.Employee.JobTitle, dbo.Employee.DepartmentName