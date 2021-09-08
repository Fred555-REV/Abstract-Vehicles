package com.company.cardealer.interfaces.vehicletypes;

import com.company.cardealer.abstracts.Engine;
import com.company.cardealer.abstracts.Vehicle;
import com.company.cardealer.airvehicles.CommercialAircraft;
import com.company.cardealer.engines.GasEngine;
import com.company.cardealer.interfaces.languages.English;
import com.company.cardealer.interfaces.languages.Language;
import com.company.dragrace.Color;
import com.company.dragrace.Player;

import java.util.List;
import java.util.spi.LocaleNameProvider;

public class AirVehicles implements VehicleType {
    private Language lang;
    public AirVehicles() {
        lang = new English();
    }

    @Override
    public List<Vehicle> vehicles() {
        return List.of(
                new CommercialAircraft(
                        "Boeing", "Boeing 737-800", "Green",
                        null,
                        25_000, 162, 588, 1_451_360, 4),
                new CommercialAircraft(
                        "Bombardier", "Challenger 650", "Blue",
                        null,
                        30_000, 21, 531, 771_200, 4
                )
        );
    }

    @Override
    public List<Engine> engines() {
        return List.of(
                new GasEngine("High-bypass turbofan", "CFM56", 10_000, 2),
                new GasEngine("high-bypass turbofan", "GE CF34", 9_200, 2)
//        new ElectricEngine()
        );
    }

    @Override
    public void jumpOut(Player player) {
        player.takeDamage(player.getVehicle().getCurrentSpeed()/3);
        System.out.printf("You jump out of a %s with a parachute going %s knots\n",
                player.getVehicle().getModel(), player.getVehicle().getCurrentSpeed() * 0.868976);
        if (player.getHealth() <= 0) {
            System.out.print(Color.RED);
            System.out.println(lang.END().get(0));
            System.out.print(Color.RESET);
        }
        System.out.println("You now have " + player.getHealth() + " health");
    }
    @Override
    public void displayRaceResult(Player player, int distanceFromTarget, long totalTime) {

        int penalty = Math.abs(distanceFromTarget);
        if (penalty != 0) {
            //   (5)-50   (3) -25    -10     10   25 (3)  50 (5)
            if (penalty > 50) {
                penalty = 5;
            } else if (penalty > 25) {
                penalty = 3;
            } else if (penalty > 10) {
                penalty = 2;
            } else if (penalty > 2) {
                penalty = 1;
            } else {
                penalty = 0;
            }
            System.out.printf("Because you missed the target distance by %s units %s seconds have been added to your time.\n"
                    , Math.abs(distanceFromTarget), penalty);
        }
        if (player.getHealth() < 100) {
            System.out.printf("Because you took %s damage from jumping out of the vehicle %s seconds have been added to your time.\n",
                    player.getVehicle().getCurrentSpeed()/3, (100 - player.getHealth()) / 10);
            penalty += (100 - player.getHealth()) / 10;
        }
        System.out.println("Your final score was " + (totalTime + penalty));

    }
}
