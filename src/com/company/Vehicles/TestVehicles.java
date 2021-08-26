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
//        Car honda = new Car("Honda", "CR-V", "Silver", hondaEngine, 5, 250, 7000, true);
        Car honda = new Car("Honda", "CR-V", "Silver", new Engine("SUV", "Honda", 1400), 5, 250, 7000, true);
//        System.out.println(honda);
        honda.displayVehicle();

        Motorcycle harley = new Motorcycle("Harley Davidson", "Cruiser", "Softtail Slim", "Midnight Crimson", new Engine("V-Twin", "Milwaukee-Eight 107", 77), 5, 250, 7000);
//        System.out.println(harley);
        harley.displayVehicle();

        CommercialAircraft airplane = new CommercialAircraft("Manufacturer", "Model", "White", new Engine("type", "name", 100), 100, 100, 100,2);
        System.out.println(airplane);
        airplane.displayVehicle();

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(honda);
        vehicles.add(harley);
        vehicles.add(airplane);
        System.out.println(vehicles);
    }


}
