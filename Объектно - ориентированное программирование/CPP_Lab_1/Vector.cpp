#include "Vector.h"
#include <iostream>
Vector::Vector(){}
Vector::Vector(int _items[], int _size) 
{
	items = _items;
	size = _size;
}
int Vector::get_size()
{
	return size;
};
int Vector::operator[](int index) 
{
		if (index <= (get_size() - 1))
		{
			return items[index];
		}
		else
		{
			throw std::out_of_range("Index error");
		}
};

Vector Vector::operator+(Vector other)
{
		if (get_size() == other.get_size())
		{
			for (int i = 0; i < get_size(); i++)
			{
				items[i] += other[i];
			}
			return *this;
		}
		else
		{
			throw std::exception("Vector sizes are not equal");
		}
}

Vector Vector::operator+=(Vector other)
{
	return *this + other;
}

Vector Vector::operator-(Vector other)
{
	if (get_size() == other.get_size())
	{
		for (int i = 0; i < get_size(); i++)
		{
			items[i] -= other[i];
		}
		return *this;
	}
	else
	{
		throw std::exception("Vector sizes are not equal");
	}
}

Vector Vector::operator-=(Vector other)
{
	return *this - other;
}

Vector Vector::operator*(int other)
{
	if (typeid(other) == typeid(int))
	{
		for (int i = 0; i < get_size(); i++)
		{
			items[i] *= other;
		}
		return *this;
	}
	else
	{
		throw std::exception("Vectors can only be multipled by integer!");
	}
}

Vector Vector::operator*=(int other)
{
	return *this * other;
}

Vector Vector::operator/(int other)
{
	if (typeid(other) == typeid(int))
	{
		for (int i = 0; i < get_size(); i++)
		{
			items[i] /= other;
		}
		return *this;
	}
	else
	{
		throw std::exception("Vectors can only be divided by integer!");
	}
}

Vector Vector::operator/=(int other)
{
	return *this / other;
}

void Vector::print_element(int index)
{
	if (index <= (get_size() - 1))
	{
		std::cout << items[index] << std::endl;
	}
	else
	{
		throw std::exception("Index error");
	}
}

void Vector::print()
{
	std::cout << "[";
	for (int i = 0; i < get_size(); i++)
	{
		if (i != get_size() - 1)
		{
			std::cout << items[i] << ", ";
		}
		else
		{
			std::cout << items[i] << "]" << std::endl;
		}
	}
}