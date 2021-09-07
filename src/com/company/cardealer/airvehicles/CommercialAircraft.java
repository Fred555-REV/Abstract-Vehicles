package com.company.cardealer.airvehicles;

import com.company.cardealer.abstracts.Engine;
import com.company.cardealer.abstracts.Vehicle;

public class CommercialAircraft extends Vehicle {
    private int wingAmount;

    public CommercialAircraft(String manufacturer, String model, String color, Engine engine, int cost, int passengerSpace, int topSpeedInMPH, int weightInOunces, int wingAmount) {
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
    public void accelerate() {
        acceleration = (int) Math.round(engine.getHorsePower() * engine.getAmount() / (weightInOunces / 10000.0));
        currentSpeed += acceleration;
        if (currentSpeed > topSpeedInMPH) {
            currentSpeed = topSpeedInMPH;
        }
    }

    @Override
    public void decelerate() {
        int deceleration = (int) Math.round((engine.getHorsePower() + topSpeedInMPH + acceleration) / (weightInOunces / 10000.0));
        currentSpeed -= deceleration;
        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
    }


    @Override
    public void coast() {
        int coast = (int) Math.round((currentSpeed / (weightInOunces / 10000.0)));
        currentSpeed -= coast;
        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
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
