package com.company.dragrace;

import com.company.cardealer.abstracts.Engine;
import com.company.cardealer.abstracts.Vehicle;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class CLI {
    private static final Scanner scan = new Scanner(System.in);
    protected static final LocalDateTime initialTime = LocalDateTime.now();
    protected static Player player;
    protected static TimeKeeper timeKeeper;
    protected static final List<Vehicle> vehicles = List.of(
//            new Car(),
//            new Car(),
//            new Motorcycle(),
//            new Motorcycle()
    );
    protected static final List<Engine> engines = List.of(

    );

    public CLI() {
    }

    public static void addPlayer() {
        System.out.println("Enter Name");
        String name = scan.next();
        System.out.println("Enter Color");
        String color = scan.next();
        Player player = new Player(name, color);
        if (CLI.player == null) {
            CLI.player = player;
        } else {
            System.out.println("There is already a player.");
        }
    }

    public static boolean setup() {
        System.out.println("Set up");
        System.out.println("(1) buy or sell a vehicle");
        System.out.println("(2) Choose an engine");
        System.out.println("(3) Start Race");

        int selection = Validation.inputInt("What Will you get?", 1, 5);
        switch (selection) {
            case 1: //TODO allow player to buy and/or sell a vehicle
                chooseVehicle();
                break;
            case 2:
                break;
            case 3://TODO allow player to buy and/or sell a vehicle
                chooseEngine();
                break;
            case 4:
                break;
            case 5:
                System.out.println("This is your Vehicle");
                player.getVehicle().displayVehicle();
                //TODO display limited stats of vehicle and engine
                player.getVehicle();
                player.getEngine();
                return false;
            default:
                System.out.println("Invalid Selection");
                break;
        }
        return true;
    }

    public static void controlVehicle() {
        System.out.println("Choose an action");
        System.out.println("(1)");
    }

    public static void chooseVehicle() {
        //TODO if null buy else sell
        if (player.getVehicle() == null) {

        }else {
            player.sellVehicle();
        }
    }

    public static void chooseEngine() {
        //TODO if null buy else sell
        if (player.getEngine() == null) {

        }else {
            player.sellEngine();
        }

    }

    public static void accelerate() {

    }

    public static void decelerate() {

    }

    public static void coast() {

    }

    public static void displayInitialTime() {
        System.out.println(initialTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    public static void displayCurrentTime() {
        System.out.println(TimeKeeper.endTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    public static void displayTotalTime() {
        System.out.println(initialTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println(TimeKeeper.endTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println("You took " + Duration.between(initialTime, TimeKeeper.endTime).getSeconds() + " seconds");

    }

}
