# Программирование на языке высокого уровня (Python).
# Задание №4.3.4. Вариант 8
#
# Выполнил: Стороженко А.В.
# Группа: ПИН-б-о-21-1
# E-mail: artem_storozhenko_2016@mail.ru

if __name__ == "__main__":
    from queue import Queue
    queue = Queue([1, 2.25, 3])

    # Добавление в очередь
    print(f"Добавление в очередь: {queue.get_items()}", end=' --> ')
    queue.enqueue("fourth")
    print(queue.get_items())

    # Удаление из очереди
    print(f"Удаление из очереди: {queue.get_items()}", end=' --> ')
    queue.dequeue()
    print(queue.get_items())

    # Сохранение объекта в JSON - файл
    print("Сохранение объекта в JSON - файл")
    queue.save("object")
    with open("object.json", 'r') as file:
        for line in file:
            print(line)
    # Получение значения следующего элемента в очереди
    print(f"Получение следующего элемента очереди {queue.get_items()} --> {queue.peek()}")

    # Строковое представление объекта
    print(f"Строковое представление объекта: {queue}")

    # Получение количества элементов в очереди
    print(f"Количество элементов: {queue.get_items()} --> {queue.count()}")

    # Загрузка объекта из JSON - файла
    print("До загрузки")
    print(f"Элементы очереди: {queue.get_items()}")
    print("\nПосле загрузки")
    queue.load("object")
    print(f"Элементы очереди: {queue.get_items()}")

    # Арифметические операции над объектом
    queue.enqueue(4)
    print(f"queue / 2 = {queue / 2}")

    # Создание очереди из строки
    print(f"""Создание очереди из строки: {queue.from_string("1,2,3,4,5")}""")
