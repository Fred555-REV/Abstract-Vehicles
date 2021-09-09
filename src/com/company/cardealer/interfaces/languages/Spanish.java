package com.company.cardealer.interfaces.languages;

import java.util.List;

public class Spanish implements Language {

    @Override
    public String VEHICLETYPE_PROMPT() {
        return "(1) Vehiculos Aéreo\n(2) Vehículos Terrestre";
    }

    @Override
    public String ENTER_PROMPT() {
        return "Ingrese ";
    }

    @Override
    public List<String> PLAYER_FIELDS() {
        return List.of(
                "Nombre",
                "Color"
        );
    }

    @Override
    public List<String> CAR_DEALER_MENU() {
        return List.of(
                "Venta de vehiculos",
                "(1) Comprar o vender un vehiculo",
                "(2) Comprar o vender motor(es)",
                "(3) Empezar Carrera"
        );
    }

    @Override
    public List<String> ERROR_MSGS() {
        return List.of(
                "OK",
                "Número Invalido",
                "Excepción Generica",
                "selección Invalida",
                "404 - Objeto No Encontrado",
                "No hay vehiculo",
                "No hay motor",
                "No hay suficiente balance"
        );
    }

    @Override
    public String SELECT_PROMPT() {
        return "Que quieres hacer?";
    }

    @Override
    public String BUY_VEHICLE_PROMPT() {
        return "Elige Vehiculo 1-";
    }

    @Override
    public String SELL_VEHICLE_PROMPT() {
        return "El vehiculo tiene un motor estas seguro(a)? (Vas a perder el motor y su valor)\n(1) Si\n(2) No";
    }

    @Override
    public String BUY_ENGINE_PROMPT() {
        return "Elige Motor 1-";
    }

    @Override
    public String VEHICLE_SOLD() {
        return "Vehiculo Vendido";
    }

    @Override
    public String ENGINE_SOLD() {
        return "Motor Vendido";
    }

    @Override
    public List<String> CONTROL_MENU() {
        return List.of(
                "Elige una accion",
                "(1) Accelerar",
                "(2) Frenar",
                "(3) Hacer nada",
                "(4) Saltar del vehiculo"
        );
    }

    @Override
    public List<String> END() {
        return List.of(
                "HAZ MUERTO",
                "El fin se acerca..."
        );
    }

    @Override
    public String HAS() {
        return "tiene";
    }

    @Override
    public String PASSENGERS() {
        return "pasajeros";
    }

    @Override
    public String HUD() {
        return "\nMeta:\t%s\nDistancia de la meta\t%s\nVelocidad\t%s\n";
    }

    @Override
    public List<String> TIME() {
        return List.of(
                "Tiempo Inicial:\t",
                "Tiempo Final:    \t",
                "To tomaste:    \t"
        );
    }

    @Override
    public String SECONDS() {
        return "segundos";
    }

    @Override
    public String JUMPOUT_AIR() {
        return "Tu saltastes del %s con paracaidas yendo %s knots\n";
    }

    @Override
    public String JUMPOUT_LAND() {
        return "Tu saltastes del %s yendo %s mph\n";
    }

    @Override
    public String YOU_HAVE() {
        return "tú tienes ";
    }

    @Override
    public String HEALTH() {
        return "puntos de salud";
    }

    @Override
    public List<String> DISPLAY_RACE_RESULT() {
        return List.of(
                "Porque no alcanzaste la meta por %s units %s segundos se han añadidos a tu tiempo final.\n",
                "Porque tomaste %s puntos de daño por saltar del vehiculo, %s segundos se han añadidos a tu tiempo final.\n",
                "Tu puntuaje final es "
        );
    }
}
