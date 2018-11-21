package com.rpg.util;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Mubashir on 11/18/2018.
 */
public final class ReadUserInput {
    private ReadUserInput() {
    }

    public static int getIntInput() {
        return getIntInput(Integer.MAX_VALUE);
    }

    public static int getIntInput(int max) {
        int userInput;
        do {
            try {
                userInput = new Scanner(System.in).nextInt();
                if (userInput < 1 || userInput > max) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IllegalArgumentException | InputMismatchException ex) {
                System.out.println("Invalid input please try again!");
            }
        } while (true);

        return userInput;
    }

    public static String getStringInput() {
        String userInput = "";
        try {
            userInput = new Scanner(System.in).next();
        } catch (InputMismatchException ex) {
            System.out.println("Invalid input please try again!");
        }
        return userInput;
    }

    public static String getStringInput(String... validChars) {
        boolean isValid = false;
        String userInput = "";
        while (!isValid) {
            try {
                userInput = new Scanner(System.in).next();
                isValid = validateInput(userInput, validChars);

            } catch (InputMismatchException ex) {
                System.out.println("Invalid input please try again!");
            }
        }
        return userInput;
    }

    private static boolean validateInput(String userInput, String[] validChars) {
        if (Arrays.stream(validChars).filter(input -> input.toLowerCase().equals(userInput.toLowerCase()))
                .count() == 1) {
            return true;
        }
        System.out.println("Invalid input please try again!");
        return false;
    }
}
