#include "Factory.h"
#include "AbstractString.h"
#include <string>
void Factory::addObject(std::string name, std::string value)
{
	AbstractString* newObj;
	if (atoi(value.c_str()) != 0)
	{
		newObj = new DecString(name, value);
	}
	else
	{
		newObj = new SymbString(name, value);
	}
	Strings.push_back(newObj);
}

void Factory::deleteObject()
{
	int nItem = Strings.size();
	if (!nItem)
	{
		std::cout << "Where is no objects\n\n";
		return;
	}
	std::cout << "Choose object:\n";
	showObjects();
	int item;
	std::cin >> item;
	Strings.erase(Strings.begin() + item - 1);
}

void Factory::workWithObject()
{
	int nItem = Strings.size();
	if (!nItem)
	{
		std::cout << "Where is no objects\n\n";
		return;
	}
	std::cout << "Choose object:\n";
	showObjects();
	int item;
	std::cin >> item;
	std::cout << "Choose object option: " << std::endl;
	std::cout << "1. Get name" << std::endl;
	std::cout << "2. Set name" << std::endl;
	std::cout << "3. Get value" << std::endl;
	std::cout << "4. Set value" << std::endl;
	int choice;
	std::cin >> choice;
	if (choice == 1)
	{
		std::cout << Strings[item - 1]->getName() << std::endl;
	}
	else if (choice == 2)
	{
		std::cout << "Enter new object name: " << std::endl;
		std::string newName;
		std::cin >> newName;
		Strings[item - 1]->setName(newName);
	}
	else if (choice == 3)
	{
	
		std::cout << Strings[item - 1]->getValue() << std::endl;
	}
	else if (choice == 4)
	{
		std::cout << "Enter new object value: " << std::endl;
		std::string newValue;
		std::cin >> newValue;
		Strings[item - 1]->setValue(newValue);
	}
}
void Factory::showObjects()
{
	int nItem = Strings.size();
	if (!nItem)
	{
		std::cout << "Where is no objects";
		return;
	}
	for (int i = 0; i < Strings.size(); i++)
	{
		std::cout << i + 1 << ". " << "name = " + Strings[i]->getName() << "| value = " + Strings[i]->getValue() << "| type = " + Strings[i]->type << std::endl;
	}
}

void Factory::subtraction()
{
	int nItem = Strings.size();
	if (!nItem)
	{
		std::cout << "Where is no objects\n\n";
		return;
	}
	int item_1;
	int item_2;
	std::cout << "Choose object 1: ";
	std::cin >> item_1;
	std::cout << "Choose object 2: ";
	std::cin >> item_2;
	if (Strings[item_1 - 1]->type == Strings[item_1 - 1]->type)
	{
		if (Strings[item_1 - 1]->type == "DecString")
		{
			std::cout << Strings[item_1 - 1]->getName() + " - " + Strings[item_2 - 1]->getName() + " = " << ((DecString)(Strings[item_1 - 1]) - (DecString)(Strings[item_2 - 1])) << std::endl;
		}
		else
		{
			std::cout << Strings[item_1 - 1]->getName() + " - " + Strings[item_2 - 1]->getName() + " = " << ((SymbString)(Strings[item_1 - 1]) - (SymbString)(Strings[item_2 - 1])) << std::endl;
		}
	}
	else
	{
		std::cout << "Objects must have same type" << std::endl;
	}

}