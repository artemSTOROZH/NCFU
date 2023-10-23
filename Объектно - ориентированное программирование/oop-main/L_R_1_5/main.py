# Программирование на языке высокого уровня (Python).
# Задание №4.3.5. Вариант 8
#
# Выполнил: Стороженко А.В.
# Группа: ПИН-б-о-21-1
# E-mail: artem_storozhenko_2016@mail.ru


...
if __name__ == "__main__":
    from queue import Queue
    from queueCollection import QueueCollection
    queue_1 = Queue(['15', '64', '88'], name="numbers")
    queue_2 = Queue(['list', 'dict', 'tuple'], name="data_structures")
    queue_3 = Queue(["a", "b", "c"], name="characters")
    queueCollection = QueueCollection([queue_1, queue_2, queue_3])
    queue_4 = Queue(['blue', 'red', 'green'])

    # Добавление элемента в коллекцию
    queueCollection.add_item(queue_4)

    # Строковое представление коллекции
    print(queueCollection)

    # Срез коллекции
    print(queueCollection[1:3])

    # Сохранение коллекции
    queueCollection.save("qCol")

    # Очистка коллекции
    queueCollection.clear()
    print(queueCollection)

    # Загрузка коллекции из файла
    new_QCol = QueueCollection.load("qCol")
    print(new_QCol)
    new_QCol[0] = queue_2
    print(new_QCol)
