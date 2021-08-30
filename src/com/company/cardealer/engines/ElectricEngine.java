package com.company.cardealer.engines;

import com.company.cardealer.abstracts.Engine;

public class ElectricEngine extends Engine {
    public ElectricEngine(String type, String name, int horsePower) {
        super(type, name, horsePower);
    }

    public ElectricEngine(String type, String name, int horsePower, int amount) {
        super(type, name, horsePower, amount);
    }
}
