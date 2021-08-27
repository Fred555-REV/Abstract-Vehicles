package com.company.Vehicles.LandVehicles;

import com.company.Vehicles.Engine;
import com.company.Vehicles.LandVehicles.LandVehicle;

public class Motorcycle extends LandVehicle {
    private String type;

    public Motorcycle(String manufacturer, String model, String type, String color, Engine engine, int cost, int passengerSpace, int topSpeedInMPH, int weightInOunces) {
        super(manufacturer, model, color, engine, cost, passengerSpace, topSpeedInMPH, weightInOunces, 2);
        this.type = type;
    }

    public Motorcycle(String manufacturer, String model, String type, String color, Engine engine, int cost, int passengerSpace, int topSpeedInMPH, int weightInOunces, int wheelAmount) {
        super(manufacturer, model, color, engine, cost, passengerSpace, topSpeedInMPH, weightInOunces, wheelAmount);
        this.type = type;
    }

    @Override
    public void displayVehicle() {
        System.out.println("   ,\n" +
                ".-/c-.,::\n" +
                "(_)'==(_)\n");
    }

    @Override
    public void displayWeight() {
        System.out.printf("%s weighs %s lbs.\n", model, (weightInOunces / 16));
    }

    @Override
    public void displaySpeed() {
        System.out.printf("%s's Top Speed is %s mph.\n", model, topSpeedInMPH);
    }

    @Override
    public String toString() {
        return "\nMotorcycle{" +
                super.toString() +
                "\ntype=" + type +
                "}\n";
    }
}
