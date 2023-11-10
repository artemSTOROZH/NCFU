USE SampleDb
ALTER TABLE Projects ADD CONSTRAINT check_budget CHECK(100000 < Budget AND Budget < 500000)