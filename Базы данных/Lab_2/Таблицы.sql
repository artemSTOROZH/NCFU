USE SampleDb
CREATE TABLE Department(
DepartmentNumber CHAR(4) PRIMARY KEY NOT NULL,
DepartmentName NCHAR(40) NULL,
DepLocation NCHAR(40) NULL,
);

CREATE TABLE Projects(
ProjectNumber CHAR(4) PRIMARY KEY NOT NULL,
ProjectName NCHAR(40) NULL,
Budget FLOAT(53) NULL
CONSTRAINT unique_number UNIQUE (ProjectNumber),
);

CREATE TABLE Employee(
EmpId INT NOT NULL CONSTRAINT primary_id PRIMARY KEY,
FirstName NCHAR(20) NULL,
LastName NCHAR(20) NULL,
DepartmentNumber CHAR(4) NULL
);

CREATE TABLE Works_on(
EmpId INT NOT NULL,
ProjectNumber CHAR(4) NOT NULL,
Job NCHAR(40) NULL,
EnterDate DATETIME NULL,
CONSTRAINT primary_works PRIMARY KEY (EmpId, ProjectNumber),
CONSTRAINT foreign_employee FOREIGN KEY (EmpId)
CONSTRAINT foreign_project FOREIGN KEY (ProjectNumber)
);