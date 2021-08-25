package com.company.Vehicles;

public class Motorcycle extends Vehicle {

    public Motorcycle(String manufacturer, String model, String color, Engine engine, int passengerSpace, int topSpeedInMPH, int weightInOunces) {
        super(manufacturer, model, color, engine, passengerSpace, topSpeedInMPH, weightInOunces);
    }

    @Override
    public void displayVehicle() {
        System.out.println("   ,\n" +
                ".-/c-.,::\n" +
                "(_)'==(_)\n");
    }

    @Override
    public void method2() {

    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                super.toString() +
                "}";
    }
}
