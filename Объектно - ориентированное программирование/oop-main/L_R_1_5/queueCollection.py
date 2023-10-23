# Программирование на языке высокого уровня (Python).
# Задание №4.3.5. Вариант 8
#
# Выполнил: Стороженко А.В.
# Группа: ПИН-б-о-21-1
# E-mail: artem_storozhenko_2016@mail.ru

from queue import Queue
import json


class QueueCollection:
    def __init__(self, items):

        """Инициализация атрибутов класса КоллекцияОчередей"""

        for item in items:
            if not isinstance(item, Queue):
                raise TypeError
        self._items = items

    def toJSON(self):

        """Преобразование объекта в JSON - строку. Для каждого объекта, который нельзя сериализировать,
           берется его представление в виде словаря (__dict__)"""

        return json.dumps(self, default=lambda o: o.__dict__,
                          sort_keys=True, indent=4)

    def get_items(self):

        """Получение элементов коллекции"""

        return self._items

    def add_item(self, queue):
        """Добавление элемента в коллекцию"""
        if isinstance(queue, Queue):
            self._items.append(queue)
        else:
            raise ValueError

    def clear(self):

        """Очистка коллекции"""

        self._items = []

    def isEmpty(self):

        """Проверка на пустоту коллекции"""

        if len(self._items) < 1:
            return True
        else:
            return False

    def __getitem__(self, item_index):

        """Перегрузка оператора индексирования"""

        return self._items[item_index]

    def __setitem__(self, item_index, item):

        """Перегрузка оператора записи значения по индексу"""
        if isinstance(item, Queue):
            self._items[item_index] = item
        else:
            raise ValueError("Добавляемый элемент не является очередью!")

    def remove(self, index):

        """Удаление элемента из коллекции"""

        self._items.pop(index)

    def __str__(self):

        """Строковое представление объекта. Возвращаются имя каждой очереди, если оно есть, и ее элементы"""

        queues_str = "["
        if len(self._items) > 0:
            queues_str += "\n"
        for queue in self._items:
            if queue.name != None:
                queues_str += "\n" + queue.name + "\n"
            queues_str += str(queue) + "\n\n"
        queues_str += "]"
        return queues_str

    def save(self, filename):

        """Сохранение объекта в JSON - файл"""

        str_json = self.toJSON()
        with open(f"{filename}.json", "w") as file:
            file.write(str_json)

    @staticmethod
    def load(filename):

        """Загрузка объекта из JSON - файла"""

        with open(f"{filename}.json") as file:
            newQueueCollection = QueueCollection([])
            obj_from_json = json.load(file)
            str_items = []
            for item in obj_from_json["_items"]:
                queue_item = Queue(item["_items"], name=item["name"])
                newQueueCollection.add_item(queue_item)
        return newQueueCollection
