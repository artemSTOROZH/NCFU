SELECT p1.ProjectNumber, p1.ProjectName FROM Projects p1 
JOIN Projects p2 ON p1.ProjectName = p2.ProjectName
WHERE p1.ProjectNumber <> p2.ProjectNumber
ORDER BY ProjectName