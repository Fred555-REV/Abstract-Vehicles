package com.company.DragRace;

import com.company.Vehicles.Engine;
import com.company.Vehicles.*;
import com.company.Vehicles.LandVehicles.Car;
import com.company.Vehicles.LandVehicles.Motorcycle;

import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAmount;
import java.util.List;

public class CLI {
    protected static LocalDateTime initialTime = LocalDateTime.now();
    protected Player player;
    protected TimeKeeper timeKeeper;
    protected List<Vehicle> vehicles = List.of(
//            new Car(),
//            new Car(),
//            new Motorcycle(),
//            new Motorcycle()
    );
    protected List<Engine> engines = List.of(

    );

    public CLI() {
    }

    public void addPlayer(Player player) {
        if (this.player == null) {
            this.player = player;
        } else {
            System.out.println("There is already a player.");
        }
    }

    public static void takeAction() {
        System.out.println("Available actions");
        System.out.println("(1) Choose a vehicle");
        System.out.println("(2) Choose an engine");
        System.out.println("(3) Accelerate ");
        System.out.println("(4) Coast");
        System.out.println("(5) Decelerate");

        int selection = Validation.inputInt("What Will you do?", 1, 5);
        switch (selection) {
            case 1: //Choose a vehicle
                break;
            case 2: //Choose an engine
                break;
            case 3: //Accelerate
                break;
            case 4: //Coast
                break;
            case 5: //Decelerate
                break;
            default:
                System.out.println("Invalid Selection");
                break;
        }
    }

    public static void chooseVehicle() {

    }

    public static void chooseEngine() {

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
