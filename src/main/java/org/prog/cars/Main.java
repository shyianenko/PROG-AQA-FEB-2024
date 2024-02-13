package org.prog.cars;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Truck truck = new Truck();
        CargoTruck cargoTruck = new CargoTruck();
        Lorry lorry = new Lorry();

        car.turn();
        truck.turn();
        cargoTruck.turn();
        lorry.turn();
    }
}
