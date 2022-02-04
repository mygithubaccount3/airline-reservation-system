package com.airlinereservationsystem.utils;

import java.util.Scanner;

public interface Utils {
    String readInput(String message, Scanner scanner);

    String readInput(String message, String defaultValue, Scanner scanner);

    boolean checkInput(String input, String pattern);
}
