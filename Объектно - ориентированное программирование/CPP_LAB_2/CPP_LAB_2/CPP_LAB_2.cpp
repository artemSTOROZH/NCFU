#include <string>
#include <iostream>
#include <map>
#include "SymbString.h"
#include "DecString.h"
#include "CPP_LAB_2.h"
#include "Factory.h"
using namespace std;
int main()
{
    std::map<std::string, SymbString> SymbStrings;

    setlocale(LC_ALL, "Russian");
    Factory *factory = new Factory();
    int choice;
    while (true)
    {

        cout << "\n\nChoose option:\n" << endl;
        cout << "1. " << "Add object" << endl;
        cout << "2. " << "Delete object" << endl;
        cout << "3. " << "Work with object" << endl;
        cout << "4. " << "Subtraction" << endl;
        cout << "5. " << "Show objects" << endl;
        cout << "6. " << "Clear console" << endl;
        cout << "7. " << "Exit\n\n";
        cin >> choice;
        if (choice == 1)
        {
            std::string name;
            std::string value;
            cout << "Enter object name: ";
            cin >> name;
            cout << "Enter object value: ";
            cin >> value;
            cout << "\n";

            factory->addObject(name, value);
        }
        else if (choice == 2)
        {
            cout << "\n";
            factory->deleteObject();
        }
        else if (choice == 3)
        {
            cout << "\n";
            factory->workWithObject();
        }
        else if (choice == 4)
        {
            cout << "\n";
            factory->subtraction();
        }
        else if (choice == 5)
        {
            cout << "\n";
            factory->showObjects();
        }
        else if (choice == 6)
        {
            system("CLS");
        }
        else if (choice == 7)
        {
            break;
        }
    }
}

