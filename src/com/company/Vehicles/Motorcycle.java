package com.company.Vehicles;

public class Motorcycle extends LandVehicle {
    private String type;

    public Motorcycle(String manufacturer, String model, String type, String color, Engine engine, int passengerSpace, int topSpeedInMPH, int weightInOunces) {
        super(manufacturer, model, color, engine, passengerSpace, topSpeedInMPH, weightInOunces, 2);
        this.type = type;
    }

    public Motorcycle(String manufacturer, String model, String type, String color, Engine engine, int passengerSpace, int topSpeedInMPH, int weightInOunces, int wheelAmount) {
        super(manufacturer, model, color, engine, passengerSpace, topSpeedInMPH, weightInOunces, wheelAmount);
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

    }

    @Override
    public void displaySpeed() {

    }

    @Override
    public String toString() {
        return "\nMotorcycle{" +
                super.toString() +
                "}";
    }
}
