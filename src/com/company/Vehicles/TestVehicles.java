package com.company.Vehicles;

import java.util.ArrayList;
import java.util.List;

public class TestVehicles {
    public static void main(String[] args) {
        Engine hondaEngine = new Engine("SUV", "Honda", 1400);
//        System.out.println(engine.getPowerStatus());
        hondaEngine.turnOnOff();
//        System.out.println(engine.getPowerStatus());
        hondaEngine.turnOnOff();
//        System.out.println(engine.getPowerStatus());
        Car honda = new Car("Honda", "CR-V", "Silver", hondaEngine, 5, 250, 7000, true);
//        System.out.println(honda);
        honda.displayVehicle();


        Engine harleyEngine = new Engine("V-Twin", "Milwaukee-Eight 107", 77);
        Motorcycle harley = new Motorcycle("Harley Davidson", "Cruiser", "Softtail Slim", "Midnight Crimson", harleyEngine, 5, 250, 7000);r
//        System.out.println(harley);
        harley.displayVehicle();

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(honda);
        vehicles.add(harley);
        System.out.println(vehicles);
    }


}
