package com.company.cardealer.interfaces.vehicletypes;

import com.company.cardealer.abstracts.Engine;
import com.company.cardealer.abstracts.Vehicle;
import com.company.dragrace.Player;

import java.util.*;

public interface VehicleType {
    List<Vehicle> vehicles();
    List<Engine> engines();
    void jumpOut(Player player);
    void displayRaceResult(Player player, int distanceFromTarget, long totalTime);
}
