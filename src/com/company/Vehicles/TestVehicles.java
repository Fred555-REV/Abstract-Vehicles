package com.company.Vehicles;

import com.company.Vehicles.LandVehicles.Car;
import com.company.Vehicles.LandVehicles.Motorcycle;

import java.util.ArrayList;
import java.util.List;

public class TestVehicles {
    public static void main(String[] args) {
        Car honda = new Car("Honda", "CR-V", "Silver", new Engine("SUV", "Honda", 1400), 5, 250, 7000, true);
//        System.out.println(honda);
        honda.displayVehicle();

        Motorcycle harley = new Motorcycle("Harley Davidson", "Cruiser", "Softtail Slim", "Midnight Crimson", new Engine("V-Twin", "Milwaukee-Eight 107", 77), 5, 250, 7000);
//        System.out.println(harley);
        harley.displayVehicle();

        CommercialAircraft airplane = new CommercialAircraft("Boeing", "Boeing 737-800", "White", new Engine("high-bypass turbofan", "CFM56", 62, 8000), 100, 100, 100, 2);
        System.out.println(airplane);
        airplane.displayVehicle();

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(honda);
        vehicles.add(harley);
        vehicles.add(airplane);
        System.out.println(vehicles);
    }


}
