package com.company.dragrace;

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
        do {
            try {

                input = scan.nextInt();

            } catch (ClassCastException | InputMismatchException cce) {
                System.out.println("Your input is invalid, please try again");
                validOption = false;
            }
        } while (validOption);
        return input;
    }

    public static int inputInt(String prompt, int min, int max) {
        if (!prompt.equals("")) {
            System.out.println(prompt);
        }
        Scanner scan = new Scanner(System.in);
        int input = -1;
        do {
            try {

                input = scan.nextInt();

            } catch (ClassCastException | InputMismatchException cce) {
                System.out.println("Your input is invalid, please try again");
            }

        } while (input > max || input < min);
        return input;
    }
}