package com.company.DragRace;

import java.sql.Time;

public class RaceTest {
    public static void main(String[] args) {
        CLI.addPlayer();
        boolean isSettingUp = true;
        while (isSettingUp) {
            isSettingUp = CLI.setup();
        }
    }
}
