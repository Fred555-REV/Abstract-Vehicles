package com.company.cardealer.interfaces.vehicletypes;

import com.company.cardealer.abstracts.Engine;
import com.company.cardealer.abstracts.Vehicle;
import com.company.cardealer.engines.ElectricEngine;
import com.company.cardealer.engines.GasEngine;
import com.company.cardealer.landvehicles.Car;
import com.company.cardealer.landvehicles.Motorcycle;
import com.company.dragrace.Color;
import com.company.dragrace.Player;

import java.util.List;

public class LandVehicles implements VehicleType {
    @Override
    public List<Vehicle> vehicles() {
        return List.of(
                new Car("Honda", "Civic", "Blue",
                        null,
                        31_000, 5, 200, 34_400, true),
                new Car("SR3", "Raycaster", "Yellow",
                        null,
                        40_000, 2, 250, 25_000, false),
                new Motorcycle("Harley Davidson", "Softail Slim", "Cruiser", "Red",
                        null,
                        16_000, 2, 150, 10_737)
//            new Motorcycle()
        );
    }

    @Override
    public List<Engine> engines() {
        return List.of(
                new GasEngine("2.0 L 4-cylinder", "Civic", 212),
                new GasEngine("4.0 L 6-cylinder", "RayCaster", 250),
                new ElectricEngine("V-Twin", "Milwaukee-Eight 107", 77)
        );
    }

    @Override
    public void jumpOut(Player player) {
        player.takeDamage(player.getVehicle().getCurrentSpeed());
        System.out.printf("You jump out of %s going %s mph\n",
                player.getVehicle().getModel(), player.getVehicle().getCurrentSpeed());
        if (player.getHealth() <= 0) {
            System.out.print(Color.getColor("RED"));
            System.out.println("Y̵̙͕̫̒O̶͉̬̠̔Ụ̵͋ ̷͈͝D̴̥̱̦̀̇I̷͖͒̊̕E̷̛̙D");
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
                    player.getVehicle().getCurrentSpeed(), (100 - player.getHealth()) / 10);
            penalty += (100 - player.getHealth()) / 10;
        }
        System.out.println("Your final score was " + (totalTime + penalty));
        if (player.getHealth() == 0) {
            System.out.println("RIP");
        }

    }
}