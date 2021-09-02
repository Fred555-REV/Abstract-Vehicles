package com.company.cardealer.abstracts;

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

    }

    public void changePowerStatus() {
        engine.turnOnOff();
    }

    public void getPowerStatus() {
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

    public void displayCurrentPassengerAmount() {
        System.out.printf("%s has %s passengers\n", model, currentPassengerAmount);
    }

    public void installEngine(Engine engine) {
        if (this.engine == null) {
            setEngine(engine);
            acceleration = (int) Math.round(engine.getHorsePower() * engine.getAmount() / (weightInOunces / 1000.0));
        } else {
            System.out.println("There is already an engine installed.");
        }
    }

    public void removeEngine() {
        if (engine != null) {
            setEngine(null);
        } else {
            System.out.println("There is no engine to remove");
        }
    }

    protected void setEngine(Engine engine) {
        this.engine = engine;
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

    public void displayVehicleSpecs() {
        System.out.println("Vehicle{" +
                "\nmodel='" + model + '\'' +
                ", \ncolor='" + color + '\'' +
                ", \ncost=" + cost +
                ", \ntopSpeed=" + topSpeedInMPH +
                ", \nweightInPounds=" + (weightInOunces / 16.0)
        );
        if (engine != null) {
            System.out.println("Engine{" +
                    "\ntype='" + engine.getType() + '\'' +
                    ", \nname='" + engine.getName() + '\'' +
                    ", \nhorsePower=" + engine.getHorsePower() +
                    ", \namount=" + engine.getAmount() +
                    ", \ncost=" + cost +
                    "}"
            );
        }
    }

    @Override
    public String toString() {
        return "\nmanufacturer='" + manufacturer + '\'' +
                ", \nmodel='" + model + '\'' +
                ", \ncolor='" + color + '\'' +
                ", \n" + engine +
                ", \ncost=" + cost +
                ", \ncurrentPassengerAmount=" + currentPassengerAmount +
                ", \npassengerSpace=" + passengerSpace +
                ", \ntopSpeed=" + topSpeedInMPH +
                ", \nweightInOunces=" + weightInOunces;
    }


}
