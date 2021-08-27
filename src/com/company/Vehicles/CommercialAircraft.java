package com.company.Vehicles;

public class CommercialAircraft extends Vehicle {
    private int wingAmount;

    public CommercialAircraft(String manufacturer, String model, String color, Engine engine, int cost,int passengerSpace, int topSpeedInMPH, int weightInOunces, int wingAmount) {
        super(manufacturer, model, color, engine, cost, passengerSpace, topSpeedInMPH, weightInOunces);
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
        System.out.printf("%s weighs %s tons\n", model, (weightInOunces / (16 * 2000)));
    }

    @Override
    public void displaySpeed() {
        System.out.printf("%s's Top Speed is\t%s knots\n", model, (topSpeedInMPH * .0868976));
    }

    @Override
    public String toString() {
        return "\nCommercialAircraft{" +
                super.toString() +
                ", \nwingAmount=" + wingAmount +
                "}\n";
    }
}
