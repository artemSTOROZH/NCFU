USE SampleDb;
SELECT ProjectNumber, ProjectName FROM Projects WHERE ProjectNumber IN
(SELECT ProjectNumber FROM Works_on WHERE EmpId IN
(SELECT EmpId FROM Employee WHERE LastName IS NULL)
)
