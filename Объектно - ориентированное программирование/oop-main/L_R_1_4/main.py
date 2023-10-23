# Программирование на языке высокого уровня (Python).
# Задание №4.3.4. Вариант 8
#
# Выполнил: Стороженко А.В.
# Группа: ПИН-б-о-21-1
# E-mail: artem_storozhenko_2016@mail.ru

if __name__ == "__main__":
    from queue import Queue
    queue = Queue(["first", "second", "third"])

    # Атрибуты переднего и конечного элемента очереди
    print(f"Передний элемент: {queue.front}")
    print(f"Задний элемент: {queue.rear}")

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

    # Проверка на наличие в очереди элемента
    print(f"""Проверка на вхождение элемента "second" --> {queue.contains("second")}""")
    print(f"""Проверка на вхождение элемента "fifth" --> {queue.contains("fifth")}""")

    # Строковое представление объекта
    print(f"Строковое представление объекта: {queue}")

    # Очистка очереди
    print(f"Очистка очереди: {queue.get_items()}", end=" --> ")
    queue.clear()
    print(f"{queue.get_items()}")

    # Проверка объекта на пустоту
    print(f"Проверка на пустоту: {queue.get_items()} --> {queue.isEmpty()}")

    # Загрузка объекта из JSON - файла
    print("До загрузки")
    print(f"Элементы очереди: {queue.get_items()}\nПередний элемент: {queue.front}\nЗадний элемент: {queue.rear}")
    print("\nПосле загрузки")
    queue.load("object")
    print(f"Элементы очереди: {queue.get_items()}\nПередний элемент: {queue.front}\nЗадний элемент: {queue.rear}")
    print(f"Проверка на пустоту: {queue.get_items()} --> {queue.isEmpty()}")

    # Арифметические операции над объектом
    queue.clear()
    queue.enqueue(4)
    print(f"queue / 2 = {queue / 2}")

    # Создание очереди из строки
    print(f"""Создание очереди из строки: {queue.from_string("1,2,3,4,5")}""")
