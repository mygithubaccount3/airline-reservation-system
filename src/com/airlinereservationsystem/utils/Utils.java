package com.airlinereservationsystem.utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Utils {
    public static String readInput(String message, Scanner scanner) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static String readInput(String message, String defaultValue, Scanner scanner) {
        String input = readInput(message, scanner);

        return input.equals("") ? defaultValue : input;
    }

    public static boolean checkInput(String input, String pattern) {
        var compiledPattern = Pattern.compile(pattern);
        var matcher = compiledPattern.matcher(input);

        return matcher.matches();
    }
}
