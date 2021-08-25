package com.company.Vehicles;

public class Engine {
    private String type;
    private String name;
    private int horsePower;
    private boolean isOn;

    public Engine(String type, String name, int horsePower) {
        this.type = type;
        this.name = name;
        this.horsePower = horsePower;
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
                ", Name='" + name + '\'' +
                ", horsePower=" + horsePower +
                '}';
    }
}
