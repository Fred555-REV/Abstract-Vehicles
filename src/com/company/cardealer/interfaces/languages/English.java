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
                "There is no engine",
                "Not Enough Money"
        );
    }

    @Override
    public String SELECT_PROMPT() {
        return "What will you do?";
    }

    @Override
    public String BUY_VEHICLE_PROMPT() {
        return "Choose Vehicle 1-";
    }

    @Override
    public String SELL_VEHICLE_PROMPT() {
        return "The vehicle still has an engine are you sure? (you will lose the engine and it's value)\n(1) Yes\n(2) No";
    }

    @Override
    public String BUY_ENGINE_PROMPT() {
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
    public String HAS() {
        return "has";
    }

    @Override
    public String PASSENGERS() {
        return "passengers";
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

    @Override
    public String SECONDS() {
        return "seconds";
    }

    @Override
    public String JUMPOUT_AIR() {
        return "You jump out of a %s with a parachute going %s knots\n";
    }

    @Override
    public String JUMPOUT_LAND() {
        return "You jump out of %s going %s mph\n";
    }

    @Override
    public String YOU_HAVE() {
        return "You have ";
    }

    @Override
    public String HEALTH() {
        return "Health";
    }

    @Override
    public List<String> DISPLAY_RACE_RESULT() {
        return List.of(
                "Because you missed the target distance by %s units %s seconds have been added to your time.\n",
                "Because you took %s damage from jumping out of the vehicle %s seconds have been added to your time.\n",
                "Your final score was "
        );
    }
}
