from random import *
import time


class Vehicle:

    """Абстрактный класс транспортного средства содержит общие для всех ТС атрбиуты и свойства.

       Дочерние классы будут его конкретизировать"""

    _environment = None     # Среда, в которой может двигаться ТС (земля, вода, воздух)
    _mechanical = None      # Механическое ТС или нет

    def __init__(self, speed, mechanical):
        self.speed = speed
        self._mechanical = mechanical
        self._check_attributes()

    def _check_attributes(self):

        """Проверка правильности ввода атрибутов при инициализации"""

        if not isinstance(self.speed, (int, float)):
            raise ValueError("Incorrect speed value")
        if not isinstance(self._mechanical, str):
            raise ValueError("Incorrect environment value")

    def _do_service(self, malfunction):

        """Метод, осуществляющий ремонт ТС в соответствии с неисправностью. Принимает на вход целочисленное значение,

         соответствующее неисправности"""

        if isinstance(malfunction, int):
            if malfunction == 1:
                print("\n\nRefuel required")
                time.sleep(0.25)
                self._refuel()
            elif malfunction == 2:
                print("\n\nOil change required")
                self._change_oil()
        else:
            raise ValueError("Wrong malfunction value type")

    def move(self, environment, travel_length):

        """Метод движения. Принимает в качестве аргумента среду, в которой будет происходить движение и длину пути"""

        pass

    def _isMechanical(self):

        """Проверка механизированности ТС"""

        if self._mechanical == "mechanical":
            return True
        else:
            return False

    def get_env(self):

        """Метод, возвращающий среду, в которой ТС может двигаться"""

        return f"The vehicle can move in this environment: {self._environment}"

    def _check_env(self, environment):

        """Сравнение среды маршрута со средой возможного движения ТС"""

        if self._environment != environment:
            raise Exception("Wrong movement environment!")

    def _refuel(self):

        """Метод заправки ТС в случае обнаружения недостатка топлива. При вызове метода для немеханического ТС вызывается исключение.
           Этой неисправности соответствует число 1"""

        if self._isMechanical():
            print("Refueling the vehicle...")
            time.sleep(5)
            print("The vehicle is fueled\n")
        else:
            raise Exception("Non-mechanical vehicle")

    def _change_oil(self):

        """Метод заправки ТС в случае обнаружения устаревания масла. При вызове метода для немеханического ТС вызывается исключение.
           Этой неисправности соответствует число 2"""

        if self._isMechanical():
            print("Changing oil...")
            time.sleep(1.5)
            print("Oil changed\n")
        else:
            raise Exception("Non-mechanical vehicle")


class WheeledVehicle(Vehicle):

    """Класс WheeledVehicle дополняет класс Vehicle"""

    def __init__(self, speed, mechanical, number_of_wheels):
        super().__init__(speed, mechanical)
        self._environment = "ground"    # Среда для движения у колесных ТС всегда земля
        self._number_of_wheels = number_of_wheels   # Атрибут, определяющий количество колес транспортного средства
                                                    # Используется в методе _change_wheels
        self._mechanical = mechanical
        self._check_attributes()

    def _do_service(self, malfunction):
        super()._do_service(malfunction)    # Для заправки и смены масла вызывается родительский метод
        if malfunction == 3:
            print("\nWheel damage detected")
            time.sleep(0.25)
            self._change_wheels()
        elif malfunction == 4:
            print("\nBrakes malfunction detected")
            time.sleep(0.25)
            self._repair_brakes()

    def _change_wheels(self):

        """Метод для починки колес транспортного ТС. Наследуется дочерними классами класса WheeledVehicle"""

        print("Changing the wheels...")
        time.sleep(0.25)
        for i in range(1, self._number_of_wheels + 1):
            time.sleep(1)
            print(f"Wheel {i} changed")
        time.sleep(0.2)
        print("Wheels changed\n")

    def _repair_brakes(self):

        """Метод для ремонта тормозов транспортного ТС. Наследуется дочерними классами класса WheeledVehicle"""

        print("Repairing the brakes...")
        time.sleep(3)
        time.sleep(0.2)
        print("Brakes are repaired\n")

    def move(self, environment, travel_length):

        """Переопределенный метода для движения родительского класса"""

        self._check_env(environment)
        time.sleep(0.5)
        print("The wheeled vehicle is moving")
        distance_traveled = 0

        """В зависимости от скорости ТС выбирается интервал изменения проеханного ТС расстояния.
        
           Во время движения у ТС случайным образом возникают неисправности, 
           
           для исправления которых вызывается метод _do_service"""

        while distance_traveled < travel_length:
            distance_traveled += 1
            time.sleep(1 / self.speed)
            print("\r", end="")
            print(f"{distance_traveled} / {travel_length} km", end='')
            if random() < 0.01:
                if self._isMechanical():
                    malfunction = randint(1, 4)
                else:
                    malfunction = randint(1, 2)
                self._do_service(malfunction)
        print()
        print("The wheeled vehicle has arrived to the final destination")


class WaterVehicle(Vehicle):

    """Класс WaterVehicle дополняет класс Vehicle"""

    def __init__(self, speed, mechanical):
        super().__init__(speed, mechanical)
        self._environment = "water"     # У водного транспорта среда движения всегда вода
        self._mechanical = mechanical
        self._check_attributes()

    def _close_leak(self):

        """Метод для закрытия течи на водном ТС"""

        print("Closing the leak...")
        time.sleep(1)
        print("The leak is closed")
        time.sleep(0.5)
        print("Removing the water...")
        time.sleep(2)
        print("Water is removed\n")

    def _do_service(self, malfunction):
        super()._do_service(malfunction)
        if malfunction == 3:
            print("\nLeak detected")
            time.sleep(0.25)
            self._close_leak()

    def move(self, environment, travel_length):
        self._check_env(environment)
        time.sleep(0.5)
        print("\nThe water vehicle is moving")
        distance_traveled = 0
        while distance_traveled < travel_length:
            distance_traveled += 1
            time.sleep(1 / self.speed)
            print("\r", end="")
            print(f"{distance_traveled} / {travel_length} km", end='')
            if random() < 0.01:
                if self._isMechanical():
                    malfunction = randint(1, 3)
                else:
                    malfunction = randint(1, 2)
                self._do_service(malfunction)
        print()
        print("The water vehicle has arrived to the final destination")


class Car(WheeledVehicle):

    """Класс Car дополняет класс WheeledVehicle"""

    def __init__(self, speed):
        super().__init__(speed, number_of_wheels=4, mechanical="mechanical")  # Автомобиль является механическим ТС и имеет 4 колеса по умолчанию
        self._check_attributes()

    def _repair_lights(self):

        """Метод для починки фар автомобиля"""

        print("Repairing headlights...")
        time.sleep(3)
        print("Headlights functioning\n")
        time.sleep(0.5)
        print("Repairing back lights...")
        time.sleep(3)
        print("Back lights functioning\n")

    def _do_service(self, malfunction):
        super()._do_service(malfunction)
        if malfunction == 3:
            print("\nLights malfunction detected")
            self._repair_lights()
            print("\nCar service is finished")

    def move(self, environment, travel_length):
        self._check_env(environment)
        time.sleep(0.5)
        print("\nThe car is moving")
        distance_traveled = 0
        while distance_traveled < travel_length:
            distance_traveled += 1
            time.sleep(1 / self.speed)
            print("\r", end="")
            print(f"{distance_traveled} / {travel_length} km", end='')
            if random() < 0.01:
                malfunction = randint(1, 3)
                self._do_service(malfunction)
        print()
        print("The car has arrived to the final destination")


