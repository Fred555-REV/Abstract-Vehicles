package com.company.DragRace;

public class Logic {
    private CLI cli;

    public Logic(CLI cli) {
        this.cli = cli;
    }

    public void addPlayer(Player player) {
        if (cli.player == null) {
            cli.player = player;
        } else {
            System.out.println("There is already a player.");
        }
    }
}
