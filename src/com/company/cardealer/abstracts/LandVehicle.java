package com.company.cardealer.abstracts;

import com.company.cardealer.abstracts.Engine;
import com.company.cardealer.abstracts.Vehicle;

public abstract class LandVehicle extends Vehicle {
    protected int wheelAmount;

    public LandVehicle(String manufacturer, String model, String color, Engine engine, int cost, int passengerSpace, int topSpeedInMPH, int weightInOunces, int wheelAmount) {
        super(manufacturer, model, color, engine, cost, passengerSpace, topSpeedInMPH, weightInOunces);
        this.wheelAmount = wheelAmount;
    }

    public LandVehicle(String manufacturer, String model, String color, Engine engine, int cost, int passengerSpace, int topSpeedInMPH, int weightInOunces) {
        super(manufacturer, model, color, engine, cost, passengerSpace, topSpeedInMPH, weightInOunces);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nwheelAmount=" + wheelAmount + ",";
    }
}
