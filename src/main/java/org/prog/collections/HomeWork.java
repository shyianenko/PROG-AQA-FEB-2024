package org.prog.collections;

import java.util.*;

/**
 * Write HashMap of owned cars, set their colors using enum you create
 * print owners of cars of certain color
 */
public class HomeWork {
        public static void main(String[] args) {
            HashMap<CarBrand, CarColour> carColour = new HashMap<>();
            carColour.put(CarBrand.TOYOTA, CarColour.GRAY);
            carColour.put(CarBrand.AUDI, CarColour.YELLOW);
            carColour.put(CarBrand.FIAT, CarColour.WHITE);
            carColour.put(CarBrand.FORD, CarColour.YELLOW);
            carColour.put(CarBrand.OPEL, CarColour.VIOLET);
            carColour.put(CarBrand.MAZDA, CarColour.RED);
            carColour.put(CarBrand.VOLKSWAGEN, CarColour.GREEN);
            carColour.put(CarBrand.SKODA, CarColour.BLUE);

            Owner owner1 = new Owner("Bob");
            Owner owner2 = new Owner("Jerry");
            Owner owner3 = new Owner("Mark");
            Owner owner4 = new Owner("Bill");
            Owner owner5 = new Owner("Tom");

            HashMap<CarBrand, Owner> carBrandOwnerHashMap = new HashMap<>();
            carBrandOwnerHashMap.put(CarBrand.AUDI, owner1);
            carBrandOwnerHashMap.put(CarBrand.FIAT, owner1);
            carBrandOwnerHashMap.put(CarBrand.FORD, owner2);
            carBrandOwnerHashMap.put(CarBrand.OPEL, owner2);
            carBrandOwnerHashMap.put(CarBrand.MAZDA, owner3);
            carBrandOwnerHashMap.put(CarBrand.VOLKSWAGEN, owner4);
            carBrandOwnerHashMap.put(CarBrand.SKODA, owner5);

            for (var item:
                    getPersonNames(carBrandOwnerHashMap, carColour, CarColour.YELLOW)) {
                System.out.println(item.getName());
            }
        }

        static List<Owner> getPersonNames(HashMap<CarBrand, Owner> carBrandOwnerHashMap, HashMap<CarBrand, CarColour> carColour, CarColour colour) {
            var listOfBrands = new ArrayList<CarBrand>();
            var owners = new ArrayList<Owner>();

            for (var item :
                    carColour.entrySet()) {
                if (item.getValue() == colour) {
                    listOfBrands.add(item.getKey());
                }
            }

            for (var item :
                    carBrandOwnerHashMap.entrySet()) {
                if (listOfBrands.contains(item.getKey())) {
                    owners.add(item.getValue());
                }
            }

            return owners;
        }
    }