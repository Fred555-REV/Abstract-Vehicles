package com.company.Vehicles;

public abstract class LandVehicle extends Vehicle {
    private int wheelAmount;

    public LandVehicle(String manufacturer, String model, String color, Engine engine, int passengerSpace, int topSpeedInMPH, int weightInOunces, int wheelAmount) {
        super(manufacturer, model, color, engine, passengerSpace, topSpeedInMPH, weightInOunces);
        this.wheelAmount = wheelAmount;
    }

    public LandVehicle(String manufacturer, String model, String color, Engine engine, int passengerSpace, int topSpeedInMPH, int weightInOunces) {
        super(manufacturer, model, color, engine, passengerSpace, topSpeedInMPH, weightInOunces);
    }

    @Override
    public String toString() {
        return super.toString() +
                "wheelAmount=" + wheelAmount + "\n";
    }
}
