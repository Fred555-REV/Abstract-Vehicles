package com.company.DragRace;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;

public class CLI {
    protected static LocalDateTime initialTime = LocalDateTime.now();
    protected Player player;
    protected TimeKeeper timeKeeper;

    public CLI() {
    }

    public static void takeAction() {

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
    }

}
