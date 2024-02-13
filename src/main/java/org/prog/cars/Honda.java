package org.prog.cars;

public class Honda implements ICar {
    @Override
    public void goTo() {
        System.out.println("Honda uses gas");
    }
    @Override
    public void sound() {
        System.out.println("Boop-Boop");
    }
    @Override
    public void fillCar() {
        System.out.println("Honda is using gas");
    }
}
