#include "DecString.h"
#pragma once
#include "SymbString.h"
#include "AbstractString.h"
#include <cstring>
#include <string>

DecString::DecString(std::string _name, std::string _value)
{
	name = _name;
	value = std::stoi(_value); 
	type = "DecString";
}

DecString::~DecString() {};

DecString::DecString(AbstractString* abs_string)
{
	name = abs_string->getName();
	value = stoi(abs_string->getValue());
}

std::string DecString::getName()
{
	return name;
}

void DecString::setName(std::string newName)
{
	name = newName;
}

std::string DecString::getValue()
{
	return std::to_string(value);
}

void DecString::setValue(std::string newValue)
{
	try
	{
		value = stoi(newValue);
	}
	catch (std::invalid_argument error)
	{
		std::cout << "DecString can only have integer value" << std::endl;
		return;
	}
}

std::string DecString::operator-(DecString other)
{
	return std::to_string(value - std::stoi(other.getValue()));
}

