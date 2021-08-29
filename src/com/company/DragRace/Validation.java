package com.company.DragRace;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Validation {
    public static int inputInt(String prompt) {
        if (!prompt.equals("")) {
            System.out.println(prompt);
        }
        Scanner scan = new Scanner(System.in);
        boolean validOption = true;
        int input = -1;
        try {

            input = scan.nextInt();

        } catch (ClassCastException | InputMismatchException cce) {
            System.out.println("Your input is invalid, please try again");
            validOption = false;
        }
        if (!validOption) {
            inputInt(prompt);
        }
        return input;
    }

    public static int inputInt(String prompt, int min, int max) {
        if (!prompt.equals("")) {
            System.out.println(prompt);
        }
        Scanner scan = new Scanner(System.in);
        boolean validOption = true;
        int input = -1;
        try {

            input = scan.nextInt();

        } catch (ClassCastException | InputMismatchException cce) {
            System.out.println("Your input is invalid, please try again");
            validOption = false;
        }
        if (!validOption) {
            inputInt(prompt, min, max);
        } else if (input > max || input < min) {
            System.out.println("Input should be between " + min + " and " + max);
            inputInt(prompt, min, max);
        }
        return input;
    }
}