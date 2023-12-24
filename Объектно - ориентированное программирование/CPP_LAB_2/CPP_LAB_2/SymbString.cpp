#pragma once
#include "SymbString.h"
#include "AbstractString.h"
#include <cstring>
#include <string>
SymbString::SymbString(std::string _name, std::string _value)
{
	name = _name;
	value = _value;
	type = "SymbString";
}
SymbString::~SymbString() {};
SymbString::SymbString(AbstractString* abs_string)
{
	name = abs_string->getName();
	value = abs_string->getValue();
}

std::string SymbString::getName()
	{
		return name;
	}

void SymbString::setName(std::string newName) 
{
	name = newName;
}

std::string SymbString::getValue()
{
	return value;
}

void SymbString::setValue(std::string newValue)
{
	value = newValue;
}

std::string SymbString::operator-(SymbString other)
{
	try
	{
		if (value.find(other.getValue()) == std::string::npos)
		{
			return value;
		}
		else
		{
			return value.replace(value.find(other.getValue()), other.getValue().length(), "");
		}
	}
	catch (const char* error_message)
	{
		std::cout << error_message << std::endl;
	}
}
