package com.company.DragRace;

import java.sql.Time;

public class RaceTest {
    public static void main(String[] args) {
        CLI.displayInitialTime();
        CLI.displayCurrentTime();
        TimeKeeper.timePass();
        CLI.displayCurrentTime();
        TimeKeeper.timePass();
        TimeKeeper.timePass();
        CLI.displayCurrentTime();
        CLI.displayInitialTime();
    }
}
