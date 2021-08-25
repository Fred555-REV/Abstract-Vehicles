package com.company.Vehicles;

public class Car extends Vehicle {
    public Car(String manufacturer, String model, String color, Engine engine, int passengerSpace, int topSpeedInMPH, int weightInOunces) {
        super(manufacturer, model, color, engine, passengerSpace, topSpeedInMPH, weightInOunces);
    }

    @Override
    public void displayVehicle() {
        System.out.println("  ______\n" +
                " /|_||_\\`.__\n" +
                "(   _    _ _\\\n" +
                "=`-(_)--(_)-' \n");
    }

    @Override
    public void method2() {

    }


    @Override
    public String toString() {
        return "Car{" +
                super.toString() +
                "}";
    }
}
