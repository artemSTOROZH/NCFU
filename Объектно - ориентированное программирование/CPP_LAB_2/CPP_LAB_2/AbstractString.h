#pragma once
#include <iostream>
class AbstractString 
{
public:
	virtual std::string getName() = 0;
	virtual void setName(std::string) = 0;
	virtual std::string getValue() = 0;
	virtual void setValue(std::string) = 0;
	std::string type;
private:
	std::string name;
	std::string value;
};

