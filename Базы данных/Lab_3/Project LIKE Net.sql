SELECT        TOP (100) PERCENT ProjectName, ProjectNumber, Budget
FROM            dbo.Projects
WHERE        (ProjectName LIKE '%Net%')
ORDER BY ProjectName