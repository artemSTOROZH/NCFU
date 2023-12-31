# Программирование на языке высокого уровня (Python).
# Задание № 4.3.2. Вариант 8
#
# Выполнил: Стороженко А.В.
# Группа: ПИН-б-о-21-1
# E-mail: artem_storozhenko_2016@mail.ru


import time


class Заказ:
    счетчик_заказов = 0

    def __init__(self):
        self.заказанные_пиццы = []
        Заказ.счетчик_заказов += 1

    def __str__(self):
        res = ""
        res += f"Заказ №{Заказ.счетчик_заказов}\n"
        for пицца in self.заказанные_пиццы:
            res += f"{self.заказанные_пиццы.index(пицца)}. Пицца: {пицца} | Цена: {пицца.цена} р.\n"
            res += f"Тесто: {пицца.тесто} Соус: {пицца.соус}\n"
            res += f"Начинка: {пицца.начинка}\n"
        return res

    def добавить(self, пицца):
        """Добавить пиццу в заказ."""
        self.заказанные_пиццы.append(пицца)
        print(f"Пицца {пицца.название} добавлена к заказу")

    def сумма(self):
        """Вернуть сумму заказа."""
        order_sum = 0
        for пицца in self.заказанные_пиццы:
            order_sum += пицца.цена
        return order_sum

    def выполнить(self):
        """Выполнить заказ.

               Для каждой пиццы в заказе: подготовить, испечь, нарезать и упаковать.
               Сообщить, что заказ готов и пожелать приятного аппетита.

               Для визуального эффекта, каждое действие осуществляется с "задержкой",
               используя time.sleep(1).

               Формат вывода:

               Заказ поступил на выполнение...
               1. Пепперони
               Начинаю готовить пиццу Пепперони
                 - замешиваю тонкое тесто...
                 - добавляю соус: томатный...
                 - и, конечно: пепперони, сыр моцарелла...
               Выпекаю пиццу... Готово!
               Нарезаю на аппетитные кусочки...
               Упаковываю в фирменную упаковку и готово!

               Заказ №2 готов! Приятного аппетита!
               """
        for пицца in self.заказанные_пиццы:
            for действие in [пицца.подготовить, пицца.испечь, пицца.нарезать, пицца.упаковать]:
                time.sleep(1)
                действие()
