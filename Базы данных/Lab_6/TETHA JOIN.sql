USE SampleDb;
SELECT Works_on.Job, Projects.ProjectName FROM Works_on
JOIN Projects ON Works_on.Job < Projects.ProjectName WHERE Works_on.ProjectNumber = Projects.ProjectNumber
ORDER BY Job