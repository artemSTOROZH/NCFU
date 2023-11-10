USE SampleDb
ALTER TABLE Department ADD CONSTRAINT check_DepartmentName CHECK(DepartmentName = 'Product Management' 
OR DepartmentName = 'Marketing' OR DepartmentName = 'Legal' OR DepartmentName = 'Sales'
OR DepartmentName = 'Services' OR DepartmentName = 'Engineering' OR DepartmentName = 'Training' OR DepartmentName = 'Support' OR DepartmentName = 'Human Resources'
OR DepartmentName = 'Research and Development' OR DepartmentName = 'Accounting' OR DepartmentName = 'Business Development')