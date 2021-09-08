package com.company.cardealer.interfaces.languages;

import java.util.List;

public class English implements Language {
    @Override
    public String VEHICLETYPE_PROMPT() {
        return "(1) Air Vehicles\n(2) Land Vehicles";
    }

    @Override
    public String ENTER_PROMPT() {
        return "Enter ";
    }

    @Override
    public List<String> PLAYER_FIELDS() {
        return List.of(
                "Name",
                "Color"
        );
    }

    @Override
    public List<String> CAR_DEALER_MENU() {
        return List.of(
                "Car Dealer",
                "(1) buy or sell a vehicle",
                "(2) buy or sell an engine",
                "(3) Start Race"
        );
    }

    @Override
    public List<String> ERROR_MSGS() {
        return List.of(
                "OK",
                "Invalid Number",
                "Generic Exception",
                "Invalid Selection",
                "404 - Item Not Found",
                "There is no vehicle",
                "There is no engine"
        );
    }

    @Override
    public String SELECT_PROMPT() {
        return "What will you do?";
    }

    @Override
    public String VEHICLE_PROMPT() {
        return "Choose Vehicle 1-";
    }

    @Override
    public String ENGINE_PROMPT() {
        return "Select Engine 1-";
    }

    @Override
    public String VEHICLE_SOLD() {
        return "Vehicle Sold";
    }

    @Override
    public String ENGINE_SOLD() {
        return "Engine Sold";
    }

    @Override
    public List<String> CONTROL_MENU() {
        return List.of(
                "Choose an action",
                "(1) Accelerate",
                "(2) Decelerate",
                "(3) Coast",
                "(4) Jump out the vehicle"
        );
    }

    @Override
    public List<String> END() {
        return List.of(
                "YOU DIE",
                "The end is near..."
        );
    }

    @Override
    public String HUD() {
        return "\nTarget Distance:\t%s\nDistance From Target\t%s\nCurrent Speed\t%s\n";
    }

    @Override
    public List<String> TIME() {
        return List.of(
                "Initial Time:\t",
                "End Time:    \t",
                "You took:    \t"
        );
    }
}
