package com.company.cardealer.interfaces.vehicletypes;

import com.company.cardealer.abstracts.Engine;
import com.company.cardealer.abstracts.Vehicle;
import com.company.cardealer.interfaces.languages.English;
import com.company.cardealer.interfaces.languages.Language;
import com.company.dragrace.Player;

import java.util.*;

public interface VehicleType {
    List<Vehicle> vehicles();
    List<Engine> engines();
    void jumpOut(Player player);
    void displayRaceResult(Player player, int distanceFromTarget, long totalTime);
    void setLang(Language language);
}
