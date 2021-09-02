package com.company.dragrace;

public class RaceTest {
    public static void main(String[] args) {
        CLI cli = new CLI();
        cli.addPlayer();
        while (cli.setup());
        while(cli.controlVehicle());

    }
}
