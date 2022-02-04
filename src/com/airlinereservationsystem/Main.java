package com.airlinereservationsystem;

import com.airlinereservationsystem.auth.Auth;
import com.airlinereservationsystem.auth.AuthService;
import com.airlinereservationsystem.renderer.NewRenderer;
import com.airlinereservationsystem.renderer.Renderer;
import com.airlinereservationsystem.tickets.NewTicketService;
import com.airlinereservationsystem.tickets.TicketService;
import com.airlinereservationsystem.utils.NewUtils;
import com.airlinereservationsystem.utils.Utils;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        Utils utils = new NewUtils();
        AuthService authService = new Auth(utils);

        while (true) {
            String email = utils.readInput("Please, sign in\nEmail: ", scanner);
            String password = utils.readInput("Password: ", scanner);
            boolean isSignedIn = authService.signIn(email, password);

            if (isSignedIn) {
                Renderer renderer = new NewRenderer();

                while (true) {
                    renderer.showMainMenu();
                    String input = utils.readInput("Choose option: ", scanner);

                    switch (input) {
                        case "1" -> renderer.showSchedule();
                        case "2" -> {
                            TicketService ticketService = new NewTicketService(utils, renderer);
                            ticketService.chooseTicket(email);
                        }
                        case "3" -> renderer.showReturnTicketMenu();
//                    case 4 -> auth.signOut();
                        case "5" -> System.exit(0);
                        default -> System.out.println("Command not found");
                    }
                }
            }
        }
    }
}
