package com.company.Vehicles;

public class TestVehicles {
    public static void main(String[] args) {
        Engine hondaEngine = new Engine("SUV", "Honda", 1400);
//        System.out.println(engine.getPowerStatus());
        hondaEngine.turnOnOff();
//        System.out.println(engine.getPowerStatus());
        hondaEngine.turnOnOff();
//        System.out.println(engine.getPowerStatus());
        Car honda = new Car("Honda", "CR-V", "Silver", hondaEngine, 5, 250, 7000);
        System.out.println(honda);
        honda.displayVehicle();

        Engine harleyEngine = new Engine("Motorcylce", "Harley Davidson", 1400);
        Motorcycle harley = new Motorcycle("Harley Davidson", "Cruiser", "Black", harleyEngine, 5, 250, 7000);
        System.out.println(harley);
        harley.displayVehicle();
    }
}
