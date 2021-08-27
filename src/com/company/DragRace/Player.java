package com.company.DragRace;

import com.company.Vehicles.Vehicle;

public class Player {
    private String name;
    protected String color;
    private Vehicle vehicle;
    private int score;
    private int balance;

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        score = 0;
    }

    public void buyCar(Vehicle vehicle) {

    }
}
