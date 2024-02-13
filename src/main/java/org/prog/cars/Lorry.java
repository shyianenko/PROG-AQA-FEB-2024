package org.prog.cars;

public class Lorry extends CargoTruck{
    @Override
    public void turn() {
        System.out.println("Lorry can turn left and right from the second lane");
    }
}
