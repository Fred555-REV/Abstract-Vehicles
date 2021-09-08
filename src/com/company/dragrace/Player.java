package com.company.dragrace;

import com.company.cardealer.abstracts.Engine;
import com.company.cardealer.abstracts.Vehicle;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Player {
    private String name;
    protected String color;
    private Vehicle vehicle;
    protected int health;
    private int balance;

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        health = 100;
        balance = 50_000;
    }

    public void takeDamage(int amount) {
        health -= amount;
        if (health < 0) {
            health = 0;
        }
    }

    protected void buyVehicle(Vehicle vehicle) {

        balance -= vehicle.getCost();
        this.vehicle = vehicle;


    }

    protected void sellVehicle() {

        balance += vehicle.getCost();
        vehicle = null;


    }

    protected void buyEngine(Engine engine) {
        balance -= vehicle.getCost();
        this.vehicle.installEngine(engine);

    }

    protected void sellEngine() {
        balance += getEngine().getCost();
        vehicle.removeEngine();

    }

    public void displayBalance() {
        System.out.printf("%s%s has %s%s\n", Color.getColor(this), getName(),
                NumberFormat.getCurrencyInstance().format(getBalance()), Color.RESET);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Engine getEngine() {
        return vehicle.getEngine();
    }

    public int getHealth() {
        return health;
    }

    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }
}
