package com.company.cardealer.interfaces.languages;

import java.util.*;

public interface Language {
    String VEHICLETYPE_PROMPT();

    String ENTER_PROMPT();

    List<String> PLAYER_FIELDS();

    List<String> CAR_DEALER_MENU();

    String SELECT_PROMPT();

    List<String> ERROR_MSGS();

    String BUY_VEHICLE_PROMPT();

    String SELL_VEHICLE_PROMPT();

    String BUY_ENGINE_PROMPT();

    String VEHICLE_SOLD();

    String ENGINE_SOLD();

    List<String> CONTROL_MENU();

    List<String> END();

    String HUD();

    List<String> TIME();

    String SECONDS();

    String JUMPOUT_AIR();

    String JUMPOUT_LAND();

    String YOU_HAVE();

    String HEALTH();

    List<String> DISPLAY_RACE_RESULT();
}
