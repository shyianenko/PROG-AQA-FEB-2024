package org.prog.collections;

import java.util.ArrayList;
import java.util.List;

public class Owner {
    private String name;
    public List<CarBrand> carBrands = new ArrayList<>();

    public Owner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
