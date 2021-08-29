package com.company.DragRace;

import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAmount;

public class CLI {
    protected static LocalDateTime initialTime = LocalDateTime.now();
    protected Player player;
    protected TimeKeeper timeKeeper;

    public CLI() {
    }

    public static void takeAction() {
        int selection = Validation.inputInt("What Will you do?", 1, 5);
        switch (selection) {
            case 1: //acceleration
                break;
            case 2: //deceleration
                break;
            case 3: //coast
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid Selection");
                break;
        }
        TimeKeeper.timePass();
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
        System.out.println("You took " + Duration.between(initialTime, TimeKeeper.endTime).getSeconds()+" seconds");

    }

}
