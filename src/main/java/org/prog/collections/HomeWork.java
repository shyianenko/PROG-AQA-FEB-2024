package org.prog.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Write HashMap of owned cars, set their colors using enum you create
 * print owners of cars of certain color
 */
public class HomeWork {

    public static void main(String[] args) {
        Map<CarBrand, CarColour> carOwners = new HashMap<>();
        carOwners.put(CarBrand.TOYOTA, CarColour.GRAY);
        carOwners.put(CarBrand.TOYOTA, CarColour.BLUE);
        carOwners.put(CarBrand.AUDI, CarColour.BLACK);
        carOwners.put(CarBrand.AUDI, CarColour.YELLOW);
        carOwners.put(CarBrand.FIAT, CarColour.WHITE);
        carOwners.put(CarBrand.FORD, CarColour.YELLOW);
        carOwners.put(CarBrand.OPEL, CarColour.VIOLET);
        carOwners.put(CarBrand.VOLKSWAGEN, CarColour.YELLOW);
        carOwners.put(CarBrand.VOLKSWAGEN, CarColour.ORANGE);
        carOwners.put(CarBrand.RANGE_ROVER, CarColour.BLUE);
        carOwners.put(CarBrand.BMW, CarColour.GREEN);
        carOwners.put(CarBrand.NISSAN, CarColour.RED);
        carOwners.put(CarBrand.JEEP, CarColour.GRAY);
        carOwners.put(CarBrand.GMC, CarColour.ORANGE);
        carOwners.put(CarBrand.MAZDA, CarColour.BLACK);
        carOwners.put(CarBrand.SKODA, CarColour.VIOLET);

    }
}
