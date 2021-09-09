package com.company.dragrace;

import com.company.cardealer.abstracts.Vehicle;
import com.company.cardealer.airvehicles.CommercialAircraft;
import com.company.cardealer.interfaces.languages.English;
import com.company.cardealer.interfaces.languages.Language;
import com.company.cardealer.interfaces.languages.Spanish;
import com.company.cardealer.interfaces.vehicletypes.AirVehicles;
import com.company.cardealer.interfaces.vehicletypes.LandVehicles;
import com.company.cardealer.interfaces.vehicletypes.VehicleType;

import java.text.NumberFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class CLI {
    private static final Scanner scan = new Scanner(System.in);
    protected static LocalDateTime initialTime;
    protected Player player;
    private int targetDistance;
    private int distanceFromTarget;
    private VehicleType vehicleType;
    private Language lang;

    public CLI() {
        setLang();
        addPlayer();
        setVehicleType();

    }

    private void setLang() {
        int choice = Validation.inputInt("(1) English\n(2) Español", 1, 2);
        switch (choice) {
            case 1:
                lang = new English();
                break;
            case 2:
                lang = new Spanish();
                break;

        }
    }

    private void setVehicleType() {
//        VEHICLETYPE_PROMPT
        int choice = Validation.inputInt(lang.VEHICLETYPE_PROMPT(), 1, 2);
        switch (choice) {
            case 1:
                vehicleType = new AirVehicles();
                this.targetDistance = 10000;
                this.distanceFromTarget = 10000;
                break;
            case 2:
                vehicleType = new LandVehicles();
                this.targetDistance = 1000;
                this.distanceFromTarget = 1000;
                break;
        }
        vehicleType.setLang(lang);
    }

    public void addPlayer() {
        if (this.player == null) {
            System.out.println(lang.ENTER_PROMPT() + lang.PLAYER_FIELDS().get(0));
            String name = scan.next();
            System.out.println(lang.ENTER_PROMPT() + lang.PLAYER_FIELDS().get(1));
            String color = scan.next();
            this.player = new Player(name, color);
        } else {
            this.player = null;
        }
    }

    public boolean setup() {
        lang.CAR_DEALER_MENU().forEach(System.out::println);
        int selection = Validation.inputInt(lang.SELECT_PROMPT(), 1, 3);
        switch (selection) {
            case 1:
                chooseVehicle();
                break;
            case 2:
                if (Objects.nonNull(player.getVehicle())) {
                    chooseEngine();
                } else {
                    System.out.println(lang.ERROR_MSGS().get(5));
                }
                break;
            case 3:
                if (Objects.isNull(player.getVehicle())) {
                    System.out.println(lang.ERROR_MSGS().get(5));
                } else if (Objects.isNull(player.getEngine())) {
                    System.out.println(lang.ERROR_MSGS().get(6));
                } else {
                    player.getVehicle().displayVehicleSpecs();
                    player.getVehicle().displayVehicle();
                    player.getVehicle().addPassenger();
                    player.getVehicle().changePowerStatus();
                    player.getVehicle().displayPowerStatus();
                    setInitialTime();
                    return false;
                }

            default:
                System.out.println(lang.ERROR_MSGS().get(3));
                break;
        }
        return true;
    }

    public void chooseVehicle() {
        //TODO if null then buy else sell
        if (Objects.isNull(player.getVehicle())) {
            buyVehicle();
        } else {
            sellVehicle();
        }
    }

    private void buyVehicle() {
        displayPlayerBalance();
        for (Vehicle vehicle : vehicleType.vehicles()) {
            vehicle.displayVehicleSpecs();
        }
        int selection = Validation.inputInt(lang.BUY_VEHICLE_PROMPT() + vehicleType.vehicles().size(), 1, vehicleType.vehicles().size());

        if (player.getVehicle().getCost() <= player.getBalance()) {
            player.buyVehicle(vehicleType.vehicles().get(selection - 1));
        } else {
            System.out.println(Color.RED + lang.ERROR_MSGS().get(7) + Color.RESET);
        }
    }

    private void sellVehicle() {
        if (Objects.isNull(player.getVehicle().getEngine())) {
            player.sellVehicle();
        } else {
            System.out.println(lang.SELL_VEHICLE_PROMPT());
            Scanner scan = new Scanner(System.in);
            String input = scan.next();
            if (input.equals("1")) {
                player.sellVehicle();
            }
        }
        System.out.println(lang.VEHICLE_SOLD());
        displayPlayerBalance();
    }


    public void chooseEngine() {
        //TODO if null then buy else sell
        if (Objects.isNull(player.getEngine())) {
            buyEngine();
        } else {
            sellEngine();
        }

    }

    private void sellEngine() {
        player.sellEngine();
        System.out.println(lang.ENGINE_SOLD());
        displayPlayerBalance();
    }

    private void buyEngine() {
        displayPlayerBalance();
        System.out.println(vehicleType.engines());
        int selection = Validation.inputInt(lang.BUY_ENGINE_PROMPT() + vehicleType.engines().size(), 1, vehicleType.engines().size());
        if (vehicleType.engines().get(selection).getCost() <= player.getBalance()) {
            player.buyEngine(vehicleType.engines().get(selection - 1));
        } else {
            System.out.println(Color.RED + lang.ERROR_MSGS().get(7) + Color.RESET);
        }
    }

    public boolean controlVehicle() {
        displayCurrentTime();
        displayHUD();
        lang.CONTROL_MENU().forEach(System.out::println);
        System.out.println(Color.getColor(player));
        int action = Validation.inputInt(lang.SELECT_PROMPT());
        switch (action) {
            case 1:
                accelerate();
                break;
            case 2:
                decelerate();
                break;
            case 3:
                coast();
                break;
            case 4:
                System.out.println(Color.getColor(player));
                vehicleType.jumpOut(player);
                return false;
            default:
                System.out.println(lang.ERROR_MSGS().get(2));
                return true;
        }
        if (distanceFromTarget < -100) {
            System.out.println(Color.RED_BOLD);
            System.out.println(lang.END().get(0));
            return false;
        } else if (distanceFromTarget < 70) {
            System.out.println(Color.RED_BOLD);
            System.out.println(lang.END().get(1));
        }

        System.out.println(Color.RESET);
        distanceFromTarget -= player.getVehicle().getCurrentSpeed();
        TimeKeeper.timePass();
        return true;
    }


    public void accelerate() {
        if (player.getVehicle() instanceof CommercialAircraft) {
            CommercialAircraft vehicle = (CommercialAircraft) player.getVehicle();
            vehicle.accelerate();
        } else {
            player.getVehicle().accelerate();
        }


    }

    public void decelerate() {
        if (player.getVehicle() instanceof CommercialAircraft) {
            CommercialAircraft vehicle = (CommercialAircraft) player.getVehicle();
            vehicle.decelerate();
        } else {
            player.getVehicle().decelerate();
        }
    }

    public void coast() {
        player.getVehicle().coast();
    }

    //    public void jumpOut() {
//        player.takeDamage(player.getVehicle().getCurrentSpeed());
//        System.out.printf("You jump out of %s going %s mph\n",
//                player.getVehicle().getModel(), player.getVehicle().getCurrentSpeed());
//        if (player.getHealth() <= 0) {
//            System.out.println("Y̵̙͕̫̒O̶͉̬̠̔Ụ̵͋ ̷͈͝D̴̥̱̦̀̇I̷͖͒̊̕E̷̛̙D");
//        }
//        System.out.println("You now have " + player.getHealth() + " health");
//        displayTotalTime();
//        vehicleType.displayRaceResult(player,distanceFromTarget, getTotalTime());
//    }
    //display current passenger amount for possible future use
    public void displayCurrentPassengerAmount() {
        System.out.printf("%s %s %s %s.\n", player.getVehicle().getModel(), lang.HAS(),
                player.getVehicle().getCurrentPassengerAmount(), lang.PASSENGERS());
    }

    public void displayPlayerBalance() {
        System.out.printf("%s%s %s %s%s.\n", Color.getColor(player), player.getName(), lang.HAS(),
                NumberFormat.getCurrencyInstance().format(player.getBalance()), Color.RESET);
    }

    public void displayHUD() {
        System.out.printf(lang.HUD(),
                targetDistance, distanceFromTarget, player.getVehicle().getCurrentSpeed()
        );
    }

//    public void displayRaceResult() {
//        displayTotalTime();
//        int penalty = Math.abs(distanceFromTarget);
//        if (penalty != 0) {
//            //   (5)-50   (3) -25    -10     10   25 (3)  50 (5)
//            if (penalty > 50) {
//                penalty = 5;
//            } else if (penalty > 25) {
//                penalty = 3;
//            } else if (penalty > 10) {
//                penalty = 2;
//            } else if (penalty > 2) {
//                penalty = 1;
//            } else {
//                penalty = 0;
//            }
//            System.out.printf("Because you missed the target distance by %s units %s seconds have been added to your time.\n"
//                    , Math.abs(distanceFromTarget), penalty);
//        }
//        if (player.getHealth() < 100) {
//            System.out.printf("Because you took %s damage from jumping out of the vehicle %s seconds have been added to your time.\n",
//                    player.getVehicle().getCurrentSpeed(), (100 - player.getHealth()) / 10);
//            penalty += (100 - player.getHealth()) / 10;
//        }
//        System.out.println("Your final score was " + (getTotalTime() + penalty));
//        if (player.getHealth() == 0) {
//            System.out.println("RIP");
//        }
//
//    }

    public static void setInitialTime() {
        initialTime = LocalDateTime.now();

    }

    public static void displayInitialTime() {
        System.out.println(initialTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    public static void displayCurrentTime() {
        System.out.println(TimeKeeper.endTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    public String getCurrentTime() {
        return TimeKeeper.endTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public void displayTotalTime() {
        System.out.println(lang.TIME().get(0) + initialTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println(lang.TIME().get(1) + TimeKeeper.endTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println(lang.TIME().get(2) + Duration.between(initialTime, TimeKeeper.endTime).getSeconds() + " " + lang.SECONDS());
    }

    public static long getTotalTime() {
        return Duration.between(initialTime, TimeKeeper.endTime).getSeconds();
    }

}
