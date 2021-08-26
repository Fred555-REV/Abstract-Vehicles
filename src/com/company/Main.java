package com.company;

import com.company.Vehicles.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Car honda = new Car(
                "Honda", "CR-V", "Silver",
                new Engine("SUV", "Honda", 212), 5, 150, 54400, true);
        Motorcycle harley = new Motorcycle(
                "Harley Davidson", "Softail Slim", "Cruiser", "Midnight Crimson",
                new Engine("V-Twin", "Milwaukee-Eight 107", 77),
                2, 200, 10737);
        CommercialAircraft airplane = new CommercialAircraft(
                "Boeing", "Boeing 737-800", "White",
                new Engine("high-bypass turbofan", "CFM56", 62, 8000),
                162, 588, 1451360, 4);

        System.out.println(honda);
        honda.addPassenger();
        honda.changePowerStatus();
        honda.displayVehicle();
        System.out.println(honda);

        airplane.displayVehicle();
        System.out.println(airplane);
        airplane.addPassengers(20);
        airplane.displayCurrentPassengerAmount();
        airplane.removePassengers(15);
        airplane.displayCurrentPassengerAmount();
        airplane.displayWeight();
        airplane.displaySpeed();

        harley.getPowerStatus();
        harley.displaySpeed();
        harley.displayWeight();

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(honda);
        vehicles.add(harley);
        vehicles.add(airplane);
        for (Vehicle vehicle : vehicles) {
            vehicle.displayVehicle();
        }

        harley.addPassenger();
        harley.displayCurrentPassengerAmount();
        harley.addPassengers(2);
        System.out.println(harley);

    }
}

/*
Challenge for Abstract Classes and Methods:

Create a program focusing on Vehicles
Required Classes: Vehicle, Engine
Each Vehicle Class should contain one Engine
Each Vehicle Class should contain methods to:
    Start/Stop
    Add Passengers
    Remove Passengers

Basic Requirements:
At least one Abstract Class
At least two Abstract Methods
 */