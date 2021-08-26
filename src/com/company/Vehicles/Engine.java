package com.company.Vehicles;

public class Engine {
    private String type;
    private String name;
    private int horsePower;
    private int amount;
    private boolean isOn;

    public Engine(String type, String name, int horsePower) {
        this.type = type;
        this.name = name;
        this.horsePower = horsePower;
        amount = 1;
        isOn = false;
    }

    public Engine(String type, String name, int horsePower, int amount) {
        this.type = type;
        this.name = name;
        this.horsePower = horsePower;
        this.amount = amount;
        isOn = false;
    }

    protected void turnOnOff() {
        isOn = !isOn;
    }

    public boolean getPowerStatus() {
        return isOn;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", horsePower=" + horsePower +
                ", amount=" + amount +
                "}";
    }
}
