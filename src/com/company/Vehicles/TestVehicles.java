package com.company.Vehicles;

public class TestVehicles {
    public static void main(String[] args) {
        Engine engine = new Engine("SUV", "Honda", 1400);
//        System.out.println(engine.getPowerStatus());
        engine.turnOnOff();
//        System.out.println(engine.getPowerStatus());
        engine.turnOnOff();
//        System.out.println(engine.getPowerStatus());
        Car honda = new Car("Honda", "CR-V", "Silver", engine, 5, 250, 7000);
        System.out.println(honda);
    }
}
