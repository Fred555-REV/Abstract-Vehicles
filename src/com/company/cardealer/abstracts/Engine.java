package com.company.cardealer.abstracts;

public abstract class Engine {
    protected String type;
    protected String name;
    protected int horsePower;
    protected int amount;
    protected int cost;
    protected boolean isOn;

    public Engine(String type, String name, int horsePower) {
        this.type = type;
        this.name = name;
        this.horsePower = horsePower;
        amount = 1;
        cost = horsePower;
        isOn = false;
    }

    public Engine(String type, String name, int horsePower, int amount) {
        this.type = type;
        this.name = name;
        this.horsePower = horsePower;
        this.amount = amount;
        cost = (horsePower*amount);
        isOn = false;
    }

    protected void turnOnOff() {
        isOn = !isOn;
    }

    public boolean getPowerStatus() {
        return isOn;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", horsePower=" + horsePower +
                ", amount=" + amount +
                ", cost=" + cost +
                "}";
    }
}
