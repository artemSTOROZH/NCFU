#pragma once
#include "Vector.h"
#include <iostream>
#include <map>
using namespace std;
int main() {
	try
	{
		int command;
		string vector_name_1;
		string vector_name_2;
		int operand;
		map<string ,Vector> vectors;
		Vector vector_1(new int[] {1, 3, 5, 7, 9, 11, 13, 15, 17, 19}, 10);
		Vector vector_2(new int[] {2, 4, 6, 8, 10, 12, 14, 16, 18, 20}, 10);
		Vector vector_3(new int[] {10, 20, 30, 40, 50, 60, 70, 80, 90, 100}, 10);
		vectors["vector_1"] = vector_1;
		vectors["vector_2"] = vector_2;
		vectors["vector_3"] = vector_3;
		cout << "Commands:\n\n0 -> exit\n1 -> vector + vector\n2 -> vector - vector\n3 -> vector * integer\n4 -> vector / integer\n5 -> print Vector\n6 -> print element\n7 -> print vectors list\n8 -> clear console\n\n";

		while (true)
		{
			cin >> command;
			if (command == 1)
			{
				cout << "\nEnter first vector name: \n";
				cin >> vector_name_1;
				cout << "\nEnter second vector name: \n";
				cin >> vector_name_2;
				if (vectors.find(vector_name_1) == vectors.cend() || vectors.find(vector_name_2) == vectors.cend())
				{
					throw exception("Wrong name of vector");
				}
				else
				{
					vectors[vector_name_1] += vectors[vector_name_2];
				}
			} 
			else if (command == 2)
			{
				cout << "\nEnter first vector name: " << endl;
				cin >> vector_name_1;
				cout << "\nEnter second vector name: " << endl;
				cin >> vector_name_2;
				if (vectors.find(vector_name_1) == vectors.cend() || vectors.find(vector_name_2) == vectors.cend())
				{
					throw exception("Wrong name of vector");
				}
				else
				{
					vectors[vector_name_1] -= vectors[vector_name_2];
				}
			}
			else if (command == 3)
			{
				cout << "\nEnter first vector name: " << endl;
				cin >> vector_name_1;
				cout << "\nEnter integer: " << endl;
				cin >> operand;
				if (vectors.find(vector_name_1) == vectors.cend())
				{
					throw exception("Wrong name of vector");
				}
				else
				{
					vectors[vector_name_1] *= operand;
				}
			}
			else if (command == 4)
			{
				cout << "\nEnter first vector name: " << endl;
				cin >> vector_name_1;
				cout << "\nEnter integer: " << endl;
				cin >> operand;
				if (vectors.find(vector_name_1) == vectors.cend())
				{
					throw exception("Wrong name of vector");
				}
				else
				{
					vectors[vector_name_1] /= operand;
				}
			}
			else if (command == 5)
			{
				cout << "\nEnter vector name: " << endl;
				cin >> vector_name_1;
				cout << vector_name_1 << " = ";
				vectors[vector_name_1].print();
				cout << endl;
			}
			else if (command == 6)
			{
				int index;
				cout << "\nEnter vector name: " << endl;
				cin >> vector_name_1;
				cout << "\nEnter element index: " << endl;
				cin >> index;
				cout << "\n" << vector_name_1 << "[" << index << "] = ";
				vectors[vector_name_1].print_element(index);
				cout << endl;
			}
			else if (command == 7)
			{
				cout << endl;
				for (const auto& [name, vector] : vectors)
				{
					cout << name << " = ";
					Vector(vector).print();
				}
			}
			else if (command == 8)
			{
				cout << endl;
				for (const auto& [name, vector] : vectors)
				{
					system("cls");
					cout << "Commands:\n\n0 -> exit\n1 -> vector + vector\n2 -> vector - vector\n3 -> vector * integer\n4 -> vector / integer\n5 -> print Vector\n6 -> print element\n7 -> print vectors list\n8 -> clear console\n\n";
				}
			}
			else
			{
				throw exception("Wrong command");
			}
			cout << "\nEnter command\n\n";
		}
	}
	catch (std::exception e)
	{
		cerr << e.what() << endl;
		return -1;
	}
};