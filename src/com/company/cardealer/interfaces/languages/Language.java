package com.company.cardealer.interfaces.languages;

import java.util.*;

public interface Language {
    String VEHICLETYPE_PROMPT();
    String ENTER_PROMPT();
    List<String> PLAYER_FIELDS();
    List<String> CAR_DEALER_MENU();
    String SELECT_PROMPT();
    List<String> ERROR_MSGS();
    String VEHICLE_PROMPT();
    String ENGINE_PROMPT();
    String VEHICLE_SOLD();
    String ENGINE_SOLD();
    List<String> CONTROL_MENU();
    List<String> END();
    String HUD();
    List<String> TIME();
}
