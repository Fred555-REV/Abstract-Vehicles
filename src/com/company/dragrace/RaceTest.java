package com.company.dragrace;

public class RaceTest {
    public static void main(String[] args) {
        CLI.addPlayer();
        boolean isSettingUp = true;
        while (isSettingUp) {
            isSettingUp = CLI.setup();
        }

        while (true) {
            CLI.controlVehicle();
        }
    }
}
