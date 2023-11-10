# Программирование на языке высокого уровня (Python).
# Задание № 4.3.3. Вариант 8
#
# Выполнил: Стороженко А.В.
# Группа: ПИН-б-о-21-1
# E-mail: artem_storozhenko_2016@mail.ru

import json


class Queue:
    def __init__(self, items=[], name=None):
        """
        Инициализация атрибутов класса Очередь. Параметр имя является необязательным,

        Первый и последний элементы очереди задаются, если в ней есть хотя бы один элемент.
        """
        self._items = items  # Элементы  очереди
        self.name = name     # Название объекта (необязательно)


    def get_items(self):
        """Возвращает список всех элементов очереди"""

        return self._items
    def count(self):

        """Получение количества элементов очереди"""

        return len(self._items)

    def enqueue(self, item):
        """Добавить элемент в конец очереди"""

        self._items.append(item)
    
    def dequeue(self):
        """Вернуть и убрать из очереди первый элемент.
           Если элементов в очереди нет, вызывается IndexError"""

        if self.count() > 0:
          return self._items.pop(0)
        else:
          raise IndexError("The queue is empty")
    
    def __str__(self):

        """Строковое представление класса. Возвращается список элементов"""

        return f"{self._items}"
    
    def peek(self):

        """Возвращает значение следующего элемента в очереди"""

        if self.count() > 0:
          return self._items[0]
        else:
          raise IndexError("The queue is empty")
    
    def from_string(self, str_value):

        """Создание элемента из строки"""

        return Queue(str_value.split(","))

    def save(self, filename):

        """Сохранение объекта в JSON - файл"""

        queue_json = {'_items' : self._items}
        with open(f"{filename}.json", "w") as file:
            json.dump(queue_json, file, indent=2)

    @staticmethod
    def load(filename):

        """Загрузка объекта из JSON - файла. Возвращает объект, находящийся в JSON - файле"""

        with open(f"{filename}.json") as file:
            obj_dict = json.load(file)
            queue = Queue([])
            Queue._items = obj_dict["_items"]
            return queue

    def __add__(self, other):

        """Перегрузка оператора сложения для очереди.
           Сложение происходит с первым элементом очереди, который после этого из нее убирается"""

        if ((isinstance(other, int) and isinstance(self._items[0], int)) or             #   Проверка соответствия типов
                (isinstance(other, float) and isinstance(self._items[0], float))):
            result = self._items[0] + other
            self.dequeue()
            return result
        else:
            raise ValueError

    def __sub__(self, other):

        """Перегрузка оператора вычитания. Принцип работы аналогичен перегрузке метода сложения"""

        if ((isinstance(other, int) and isinstance(self._items[0], int)) or             #   Проверка соответствия типов
                (isinstance(other, float) and isinstance(self._items[0], float))):
            result = self._items[0] - other
            self.dequeue()
            return result
        else:
            raise ValueError("Wrong data type")

    def __mul__(self, other):

        """Перегрузка оператора умножения. Принцип работы аналогичен перегрузке метода сложения"""

        if isinstance(other, (int, float)) and isinstance(self._items[0], (int, float)):    #   Проверка соответствия типов
            result = self._items[0] * other
            self.dequeue()
            return result
        else:
            raise ValueError("Wrong data type")

    def __truediv__(self, other):
        """Перегрузка оператора деления. Принцип работы аналогичен перегрузке метода сложения"""
        if isinstance(other, (int, float)) and isinstance(self._items[0], (int, float)):    #   Проверка соответствия типов
            result = self._items[0] / other
            self.dequeue()
            return result
        else:
            raise ValueError("Wrong data type")

    def __floordiv__(self, other):

        """Перегрузка оператора деления нацело. Принцип работы аналогичен перегрузке метода сложения"""

        if isinstance(other, int) and isinstance(self._items[0], int):
            result = self._items[0] // other
            self.dequeue()
            return result
        else:
            raise ValueError("Wrong data type")