package com.company.cardealer.abstracts;

import com.company.dragrace.Color;

import javax.swing.*;
import java.util.Objects;

public abstract class Vehicle {
    protected String manufacturer;
    protected String model;
    protected String color;
    protected Engine engine;
    protected int cost;
    protected int passengerSpace;
    protected int topSpeedInMPH;
    protected int weightInOunces;
    protected int currentPassengerAmount;
    protected int acceleration;
    protected int currentSpeed;

    public Vehicle(String manufacturer, String model, String color, Engine engine,
                   int cost, int passengerSpace, int topSpeedInMPH, int weightInOunces) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.color = color;
        this.engine = engine;
        this.cost = cost;
        this.passengerSpace = passengerSpace;
        this.topSpeedInMPH = topSpeedInMPH;
        this.weightInOunces = weightInOunces;
        currentPassengerAmount = 0;
        acceleration = 0;
        currentSpeed = 0;

    }

    public void changePowerStatus() {
        engine.turnOnOff();
    }

    public void displayPowerStatus() {
        if (engine.getPowerStatus()) {
            System.out.println(model + "'s Engine is on");
        } else {
            System.out.println(model + "'s Engine is off");
        }
    }

    public boolean addPassenger() {
        if (currentPassengerAmount < passengerSpace) {
            currentPassengerAmount++;
            return true;
        } else {
            System.out.println("Not enough space, " + model + "'s  max passengers is " + passengerSpace);
            return false;
        }
    }

    public void addPassengers(int amount) {
        for (int i = 0; i < amount; i++) {
            if (!addPassenger()) {
                break;
            }

        }
    }

    public boolean removePassenger() {
        if (currentPassengerAmount > 0) {
            currentPassengerAmount--;
            return true;
        } else {
            System.out.println("There are no passengers to remove");
            return false;
        }
    }

    public void removePassengers(int amount) {
        for (int i = 0; i < amount; i++) {
            if (!removePassenger()) {
                break;
            }

        }
    }

    public abstract void displayVehicle();

    public abstract void displayWeight();   //My thinking is that large vehicles can use tons and smaller use pounds

    public abstract void displaySpeed();    //My thinking is that planes and boats use knots while others use miles

    public int getCurrentPassengerAmount() {
        return currentPassengerAmount;
    }



    public void installEngine(Engine engine) {
        this.engine = engine;
    }

    public void removeEngine() {
        this.engine = null;
    }

    public void accelerate() {
        acceleration = (int) Math.round(engine.getHorsePower() * engine.getAmount() / (weightInOunces / 1000.0));
        currentSpeed += acceleration;
        if (currentSpeed > topSpeedInMPH) {
            currentSpeed = topSpeedInMPH;
        }
    }

    public void decelerate() {
        int deceleration = (int) Math.round((topSpeedInMPH - acceleration) / (weightInOunces / 1000.0));
        currentSpeed -= deceleration;
        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
    }

    public void coast() {
        int coast = (int) Math.round((currentSpeed / (weightInOunces / 1000.0)));
        currentSpeed -= coast;
        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getCost() {
        return cost;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void displayVehicleSpecs() {
        System.out.println(Color.getColor(color) + "Vehicle{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", cost=" + cost +
                ", topSpeed=" + topSpeedInMPH +
                ", weightInPounds=" + (weightInOunces / 16.0) +
                "\n"
        );
        if (Objects.nonNull(engine)) {
            System.out.println("Engine{" +
                    "\ntype='" + engine.getType() + '\'' +
                    ", \nname='" + engine.getName() + '\'' +
                    ", \nhorsePower=" + engine.getHorsePower() +
                    ", \namount=" + engine.getAmount() +
                    ", \ncost=" + cost +
                    "}"
            );
        }
        System.out.print(Color.RESET);

    }

    @Override
    public String toString() {
        return Color.getColor(color) + "\nmanufacturer='" + manufacturer + '\'' +
                ", \nmodel='" + model + '\'' +
                ", \ncolor='" + color + '\'' +
                ", \n" + engine +
                ", \ncost=" + cost +
                ", \ncurrentPassengerAmount=" + currentPassengerAmount +
                ", \npassengerSpace=" + passengerSpace +
                ", \ntopSpeed=" + topSpeedInMPH +
                ", \nweightInOunces=" + weightInOunces + Color.RESET;
    }


}
