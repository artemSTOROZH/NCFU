#pragma once
class Vector
{
public:
	Vector();
	Vector(int _items[], int _size);
	int operator[](int index);

	Vector operator+(Vector other);
	Vector operator += (Vector other);

	Vector operator-(Vector other);
	Vector operator-=(Vector other);

	Vector operator*(int other);
	Vector operator*=(int other);

	Vector operator/(int other);
	Vector operator/=(int other);

	int get_size();
	void print_element(int index);
	void print();
private:
	int* items;
	int size;
};

