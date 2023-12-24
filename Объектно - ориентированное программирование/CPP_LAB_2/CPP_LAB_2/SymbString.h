#pragma once
#include <iostream>
#include "AbstractString.h"
class SymbString : public AbstractString
{
public:
	SymbString(std::string name, std::string strValue);
	SymbString(AbstractString* abs_string);
	std::string getName() override;
	void setName(std::string newName) override;
	std::string getValue() override;
	void setValue(std::string newValue) override;
	std::string operator-(SymbString other);
	~SymbString();
private:
	std::string name;
	std::string value;
};

