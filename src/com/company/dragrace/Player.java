package com.company.dragrace;

import com.company.cardealer.abstracts.Engine;
import com.company.cardealer.abstracts.Vehicle;

import java.util.Locale;
import java.util.Scanner;

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

    protected void buyVehicle(Vehicle vehicle) {
        if (vehicle.getCost() < balance) {
            balance -= vehicle.getCost();
            this.vehicle = vehicle;
        }

    }

    protected void sellVehicle() {
        if (vehicle != null) {
            if (vehicle.getEngine() == null) {
                balance += vehicle.getCost();
                vehicle = null;
            } else {
                System.out.println("The vehicle still has an engine are you sure? [y/n] (you will lose the engine and it's value)");
                Scanner scan = new Scanner(System.in);
                String input = scan.nextLine();
                if (input.toUpperCase(Locale.ROOT).equals("Y")) {
                    balance += vehicle.getCost();
                    vehicle = null;
                }
            }
        } else {
            System.out.println("There is nothing to sell");
        }


    }

    protected void buyEngine(Engine engine) {
        if (engine.getCost() < balance) {
            balance -= vehicle.getCost();
            this.vehicle.installEngine(engine);
        } else {
            System.out.println("Not enough money.");
        }
    }

    protected void sellEngine() {
        balance += getEngine().getCost();
        vehicle.removeEngine();

    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Engine getEngine() {
        return vehicle.getEngine();
    }

    public int getScore() {
        return score;
    }

    public int getBalance() {
        return balance;
    }
}
