package com.airlinereservationsystem;

import com.airlinereservationsystem.auth.Auth;
import com.airlinereservationsystem.tickets.TicketService;
import com.airlinereservationsystem.utils.Utils;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        while (true) {
            String email = Utils.readInput("Please, sign in\nEmail: ", scanner);
            String password = Utils.readInput("Password: ", scanner);
            boolean isSignedIn = Auth.signIn(email, password);

            if (isSignedIn) {
                while (true) {
                    Renderer.showMainMenu();
                    String input = Utils.readInput("Choose option: ", scanner);

                    switch (input) {
                        case "1" -> Renderer.showSchedule();
                        case "2" -> TicketService.buy(email);
                        case "3" -> Renderer.showReturnTicketMenu();
//                    case 4 -> auth.signOut();
                        case "5" -> System.exit(0);
                        default -> System.out.println("Command not found");
                    }
                }
            }
        }
    }
}
