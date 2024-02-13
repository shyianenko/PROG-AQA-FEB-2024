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

        Tesla tesla = new Tesla();
        Honda honda = new Honda();
        Ford ford = new Ford();

        tesla.sound();
        honda.sound();
        ford.sound();
    }
}
