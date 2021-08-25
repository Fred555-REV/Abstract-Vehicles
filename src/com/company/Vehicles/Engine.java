package com.company.Vehicles;

public class Engine {
    private String type;
    private String Brand;
    private int horsePower;
    private boolean isOn;

    public Engine(String type, String brand, int horsePower) {
        this.type = type;
        Brand = brand;
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
                ", Brand='" + Brand + '\'' +
                ", horsePower=" + horsePower +
                '}';
    }
}
