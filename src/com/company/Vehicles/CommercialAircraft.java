package com.company.Vehicles;

public class CommercialAircraft extends Vehicle {
    private int wingAmount;

    public CommercialAircraft(String manufacturer, String model, String color, Engine engine, int passengerSpace, int topSpeedInMPH, int weightInOunces, int wingAmount) {
        super(manufacturer, model, color, engine, passengerSpace, topSpeedInMPH, weightInOunces);
        this.wingAmount = wingAmount;
    }

    @Override
    public void displayVehicle() {
        System.out.println("           _\n" +
                "         -=\\`\\\n" +
                "     |\\ ____\\_\\__\n" +
                "   -=\\c`\"\"\"\"\"\"\" \"`)\n" +
                "      `~~~~~/ /~~`\n" +
                "        -==/ /\n" +
                "          '-'");
    }

    @Override
    public void displayWeight() {

    }

    @Override
    public void displaySpeed() {

    }
}
