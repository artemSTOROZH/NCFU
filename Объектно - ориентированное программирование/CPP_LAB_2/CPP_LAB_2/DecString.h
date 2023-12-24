#pragma once
#include <iostream>
#include "AbstractString.h"
class DecString : public AbstractString
{
public:
	DecString(std::string name, std::string value);
	DecString(AbstractString* abs_string);
	std::string getName();
	void setName(std::string name);
	std::string getValue(); 
	void setValue(std::string);
	std::string operator-(DecString other);
	~DecString();
private:
	std::string name;
	int value;
};

