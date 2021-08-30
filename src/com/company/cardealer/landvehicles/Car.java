package com.company.cardealer.landvehicles;

import com.company.cardealer.abstracts.Engine;

public class Car extends LandVehicle {
    private boolean isAutomatic;

    public Car(String manufacturer, String model, String color, Engine engine, int cost, int passengerSpace, int topSpeedInMPH, int weightInOunces, boolean isAutomatic) {
        super(manufacturer, model, color, engine, cost, passengerSpace, topSpeedInMPH, weightInOunces, 4);
        this.isAutomatic = isAutomatic;
    }

    public Car(String manufacturer, String model, String color, Engine engine, int cost, int passengerSpace, int topSpeedInMPH, int weightInOunces, int wheelAmount, boolean isAutomatic) {
        super(manufacturer, model, color, engine, cost, passengerSpace, topSpeedInMPH, weightInOunces, wheelAmount);
        this.isAutomatic = isAutomatic;
    }

    @Override
    public void displayVehicle() {
        System.out.println("  ______\n" +
                " /|_||_\\`.__\n" +
                "(   _    _ _\\\n" +
                "=`-(_)--(_)-' \n");
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
        return "\nCar{" +
                super.toString() +
                "\nisAutomatic=" + isAutomatic +
                "}\n";
    }
}
