package com.company.dragrace;

import com.company.cardealer.abstracts.Engine;
import com.company.cardealer.abstracts.Vehicle;
import com.company.cardealer.engines.ElectricEngine;
import com.company.cardealer.engines.GasEngine;
import com.company.cardealer.landvehicles.Car;
import com.company.cardealer.landvehicles.Motorcycle;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CLI {
    private static final Scanner scan = new Scanner(System.in);
    protected static LocalDateTime initialTime;
    protected Player player;
    private final int targetDistance;
    private int distanceFromTarget;
    protected static final List<Vehicle> vehicles = List.of(
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
    protected static final List<Engine> engines = List.of(
            new GasEngine("2.0 L 4-cylinder", "Civic", 212),
            new GasEngine("4.0 L 6-cylinder", "RayCaster", 250),
            new ElectricEngine("V-Twin", "Milwaukee-Eight 107", 77)
    );

    public CLI() {
        this.targetDistance = 1000;
        this.distanceFromTarget = 1000;
    }

    public void addPlayer() {
        if (this.player == null) {
            System.out.println("Enter Name");
            String name = scan.next();
            System.out.println("Enter Color");
            String color = scan.next();
            this.player = new Player(name, color);
        } else {
            System.out.println("There is already a player.");
        }
    }

    public boolean setup() {
        System.out.println("Car Dealer");
        System.out.println("(1) buy or sell a vehicle");
        System.out.println("(2) buy or sell an engine");
        System.out.println("(3) Start Race");

        int selection = Validation.inputInt("What will you do?", 1, 3);
        switch (selection) {
            case 1:
                chooseVehicle();
                break;
            case 2:
                if (Objects.nonNull(player.getVehicle())) {
                    chooseEngine();
                } else {
                    System.out.println("No vehicle to install engine with");
                }
                break;
            case 3:
                //TODO display limited stats of vehicle and engine

                if (Objects.isNull(player.getVehicle())) {
                    System.out.println("There is no vehicle");
                } else if (Objects.isNull(player.getEngine())) {
                    System.out.println("There is no engine");
                } else {
                    System.out.println("This is your Vehicle");
                    player.getVehicle().displayVehicleSpecs();
                    player.getVehicle().displayVehicle();
                    player.getVehicle().addPassenger();
                    player.getVehicle().changePowerStatus();
                    player.getVehicle().displayPowerStatus();
                    setInitialTime();
                    return false;
                }

            default:
                System.out.println("Invalid Selection");
                break;
        }
        return true;
    }

    public void chooseVehicle() {
        //TODO if null buy else sell
        if (Objects.isNull(player.getVehicle())) {
            player.displayBalance();
            for (Vehicle vehicle : vehicles) {
                vehicle.displayVehicleSpecs();
            }
            int selection = Validation.inputInt("Choose Vehicle 1-" + vehicles.size(), 1, vehicles.size());
            player.buyVehicle(vehicles.get(selection - 1));

        } else {
            player.sellVehicle();
            System.out.println("Vehicle Sold");
            player.displayBalance();
        }
    }

    public void chooseEngine() {
        //TODO if null buy else sell
        if (Objects.isNull(player.getEngine())) {
            player.displayBalance();
            System.out.println(engines);
            int selection = Validation.inputInt("Select Engine 1-" + engines.size(), 1, engines.size());
            player.buyEngine(engines.get(selection - 1));
        } else {
            player.sellEngine();
            System.out.println("Engine Sold");
            player.displayBalance();
        }

    }

    public boolean controlVehicle() {
        displayCurrentTime();
        displayHUD();
        System.out.println("Choose an action");
        System.out.println("(1) Accelerate");
        System.out.println("(2) Decelerate");
        System.out.println("(3) Coast");
        System.out.println("(4) Jump out the vehicle");

        int action = Validation.inputInt("Select action");
        switch (action) {
            case 1:
                accelerate();
                break;
            case 2:
                decelerate();
                break;
            case 3:
                coast();
                break;
            case 4:
                jumpOut();
                return false;
            default:
                System.out.println("Invalid Selection");
                return true;
        }
        if (distanceFromTarget < -100) {
            System.out.println("Y̷̬͎͑Ô̶̡͇̬̄͝Ṵ̸̰͚͑͒̕ ̵̨͔͎̇̀͂V̴̞̱̀A̴̝̮͊̆͌͜N̷̬̰̾̔̿Ȉ̷̥̣Ṡ̵͍H̸̡̖͚̪̅́");
            return false;
        } else if (distanceFromTarget < 50) {
            System.out.println("The end is near");
        } else if (player.getVehicle().getCurrentSpeed() == 0) {
            displayRaceResult();
            return false;
        }
        distanceFromTarget -= player.getVehicle().getCurrentSpeed();
        TimeKeeper.timePass();
        return true;
    }


    public void accelerate() {
        player.getVehicle().accelerate();


    }

    public void decelerate() {
        player.getVehicle().decelerate();

    }

    public void coast() {
        player.getVehicle().coast();
    }

    public void jumpOut() {
        player.takeDamage(player.getVehicle().getCurrentSpeed());
        System.out.printf("You jump out of %s going %s mph\n",
                player.getVehicle().getModel(), player.getVehicle().getCurrentSpeed());
        if (player.getHealth() <= 0) {
            System.out.println("Y̵̙͕̫̒O̶͉̬̠̔Ụ̵͋ ̷͈͝D̴̥̱̦̀̇I̷͖͒̊̕E̷̛̙D");
        }
        displayRaceResult();
    }

    public void displayHUD() {
        System.out.printf("\nTarget Distance:\t%s\nDistance From Target\t%s\nCurrent Speed\t%s\n",
                targetDistance, distanceFromTarget, player.getVehicle().getCurrentSpeed()
        );
    }

    public void displayRaceResult() {
        displayTotalTime();
        int penalty = Math.abs(distanceFromTarget);
        if (penalty != 0) {
            //   (5)-50   (3) -25    -10     10   25 (3)  50 (5)
            if (penalty > 50) {
                penalty = 5;
            } else if (penalty > 25) {
                penalty = 3;
            } else if (penalty > 10) {
                penalty = 2;
            }
            System.out.printf("Because you missed the target distance by %s units %s seconds have been added to your time."
                    , penalty, penalty);
        }
        if (player.getHealth() < 100) {
            System.out.printf("Because you took %s damage from jumping out of the vehicle %s seconds have been added to your time.",
                    player.getVehicle().getCurrentSpeed(), (100 - player.getHealth()) / 10);
            penalty += (100 - player.getHealth()) / 10;
        }
        System.out.println("Your final score was " + (getTotalTime() + penalty));
        if (player.getHealth() == 0) {
            System.out.println("RIP");
        }

    }

    public static void setInitialTime() {
        initialTime = LocalDateTime.now();

    }

    public static void displayInitialTime() {
        System.out.println(initialTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    public static void displayCurrentTime() {
        System.out.println(TimeKeeper.endTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    public String getCurrentTime() {
        return TimeKeeper.endTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public static void displayTotalTime() {
        System.out.println("Initial Time:\t" + initialTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println("End Time:    \t" + TimeKeeper.endTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println("You took:    \t" + Duration.between(initialTime, TimeKeeper.endTime).getSeconds() + " seconds");
    }

    public static long getTotalTime() {
        return Duration.between(initialTime, TimeKeeper.endTime).getSeconds();
    }

}
