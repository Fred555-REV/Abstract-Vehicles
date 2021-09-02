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
    protected static final LocalDateTime initialTime = LocalDateTime.now();
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
            case 5:
                return false;
            default:
                System.out.println("Invalid Selection");
                controlVehicle();
                break;
        }
        return true;
    }


    public void accelerate() {

    }

    public void decelerate() {

    }

    public void coast() {

    }

    public void jumpOut() {

    }

    public void displayHUD() {
        System.out.printf("%s\nTarget Distance:\t%s\nDistance From Target\t%s\nCurrent Speed\t",
                getCurrentTime(), targetDistance, distanceFromTarget, player.getVehicle().getCurrentSpeed()
        );
    }

    public void displayRaceResult() {

    }

    public static void setCurrentTime() {

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
        System.out.println(initialTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println(TimeKeeper.endTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println("You took " + Duration.between(initialTime, TimeKeeper.endTime).getSeconds() + " seconds");

    }

}
