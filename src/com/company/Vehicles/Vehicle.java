package com.company.Vehicles;

public abstract class Vehicle {
    private String manufacturer;
    private String model;
    private String color;
    private Engine engine;
    private int passengerSpace;
    private int topSpeedInMPH;
    private int weightInOunces;

    public Vehicle(String manufacturer, String model, String color, Engine engine, int passengerSpace, int topSpeedInMPH, int weightInOunces) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.color = color;
        this.engine = engine;
        this.passengerSpace = passengerSpace;
        this.topSpeedInMPH = topSpeedInMPH;
        this.weightInOunces = weightInOunces;
    }

    //TODO find out what vehicle methods I can add that varies between vehicles
    public abstract void method1();

    public abstract void method2();

    @Override
    public String toString() {
        return "\nmanufacturer='" + manufacturer + '\'' +
                ", \nmodel='" + model + '\'' +
                ", \ncolor='" + color + '\'' +
                ", \n" + engine +
                ", \npassengerSpace=" + passengerSpace +
                ", \ntopSpeed=" + topSpeedInMPH +
                ", \nweightInOunces=" + weightInOunces + "\n";
    }
}
