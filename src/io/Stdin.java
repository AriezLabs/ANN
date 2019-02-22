package io;

import java.util.Scanner;

/** convenience class for reading console input */
public class Stdin {
    private static Scanner sc;

    static {
        sc = new Scanner(System.in);
    }

    public static String prompt(String message) {
        System.out.print(message + ": ");
        return sc.nextLine();
    }

    public static int promptInt(String message) {
        System.out.print(message + ": ");
        while(true) {
            String in = sc.nextLine();
            try {
                return Integer.parseInt(in);
            } catch (NumberFormatException e) {
                System.out.println("enter an integer number: ");
            }
        }
    }
}
