from Hierarchy import *
ship = WaterVehicle(80, "mechanical")
print(ship.get_env())
ship.move("water", 300)
bicycle = WheeledVehicle(30, "non-mechanical", 2)
bicycle.move("ground", 100)
car = Car(120)
car.move("ground", 200)
