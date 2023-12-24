#pragma once
#include <vector>
#include "AbstractString.h"
#include "SymbString.h"
#include "DecString.h"
class Factory
{
public:
	std::vector<SymbString> SymbStrings;
	std::vector<SymbString> DecStrings;
	std::vector<AbstractString*> Strings;
	void addObject(std::string name, std::string value);
	void workWithObject();
	void showObjects();
	void deleteObject();
	void subtraction();
private:
};

