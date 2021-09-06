package com.company;

import com.company.dragrace.CLI;

public class Main {

    public static void main(String[] args) {
        CLI cli = new CLI();
        while (cli.setup());
        while (cli.controlVehicle());

    }
//        Car honda = new Car(
//                "Honda", "CR-V", "Silver",
//                new Engine("2.0 L 4-cylinder", "CR-V", 212),
//                31_000, 5, 150, 54_400, true);
//        Motorcycle harley = new Motorcycle(
//                "Harley Davidson", "Softail Slim", "Cruiser", "Midnight Crimson",
//                new Engine("V-Twin", "Milwaukee-Eight 107", 77),
//                16_000, 2, 200, 10_737);
//        CommercialAircraft airplane = new CommercialAircraft(
//                "Boeing", "Boeing 737-800", "White",
//                new Engine("high-bypass turbofan", "CFM56", 62, 8000),
//                48_000_000, 162, 588, 1_451_360, 4);
//
//        System.out.println(honda);
//        honda.addPassenger();
//        honda.changePowerStatus();
//        honda.displayVehicle();
//        System.out.println(honda);
//
//        airplane.displayVehicle();
//        System.out.println(airplane);
//        airplane.addPassengers(20);
//        airplane.displayCurrentPassengerAmount();
//        airplane.removePassengers(15);
//        airplane.displayCurrentPassengerAmount();
//        airplane.displayWeight();
//        airplane.displaySpeed();
//        System.out.println();
//        harley.changePowerStatus();
//        harley.getPowerStatus();
//        harley.displaySpeed();
//        harley.displayWeight();
//
//        List<Vehicle> vehicles = new ArrayList<>();
//        vehicles.add(honda);
//        vehicles.add(harley);
//        vehicles.add(airplane);
//        for (Vehicle vehicle : vehicles) {
//            vehicle.displayVehicle();
//        }
//
//        harley.addPassenger();
//        harley.displayCurrentPassengerAmount();
//        harley.addPassengers(2);
//        System.out.println(harley);
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