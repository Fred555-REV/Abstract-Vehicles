package com.company.cardealer.engines;

import com.company.cardealer.abstracts.Engine;

public class GasEngine extends Engine {
    public GasEngine(String type, String name, int horsePower) {
        super(type, name, horsePower);
    }

    public GasEngine(String type, String name, int horsePower, int amount) {
        super(type, name, horsePower, amount);
    }
}
