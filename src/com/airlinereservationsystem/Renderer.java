package com.airlinereservationsystem;

import com.airlinereservationsystem.tickets.Ticket;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Renderer {
    private static Map<String, Integer> map = new LinkedHashMap<>() {{
        put("Flight", 15);
        put("Arrival time", 15);
        put("Departure Time", 20);
        put("Destination", 40);
        put("Airline", 40);
        put("Terminal", 10);
        put("Gate", 10);
        put("Status", 1);
    }};

    private static void renderTitle(String title) {
        System.out.println();
        System.out.println("======= " + title + " =======");
        System.out.println();
    }

    private static void clearConsole() {
        try {
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system

            if (operatingSystem.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void showMainMenu() {
        clearConsole();
        renderTitle("Menu");
        System.out.println("1. Show schedule");
        System.out.println("2. Buy tickets");
        System.out.println("3. Return ticket");
        System.out.println("4. Quit");
        System.out.println("5. Sign out");
    }

    public static void showSchedule() {
        clearConsole();
        renderTitle("Schedule");

        for (Map.Entry<String, Integer> a : map.entrySet()) {
            System.out.printf("%-" + a.getValue() + "s", a.getKey());
        }

        System.out.println();

        for (int i = 0; i < 156; i++) {
            System.out.print("-");
        }

        System.out.println();

        for (Flight flight : Flight.flightDB.getFlights()) {
            System.out.printf("%-15s", flight.getFlight());
            System.out.printf("%-15s", flight.getArrivalTime());
            System.out.printf("%-20s", flight.getDepartureTime() != null ? flight.getDepartureTime() : "-");
            System.out.printf("%-40s", flight.getArrivalStation());
            System.out.printf("%-40s", flight.getAirline());
            System.out.printf("%-10s", flight.getTerminal());
            System.out.printf("%-10s", flight.getGate() != null ? flight.getGate() : "-");
            System.out.println(flight.getStatus());
        }
    }

    public static void renderAvailableFlights(List<Flight> flights) {
        renderTitle("Available flights");

        for (int i = 0; i < flights.size(); i++) {
            System.out.println(i + 1 + ". " + flights.get(i));
        }
    }

    public static void renderAvailableSeats(Flight flight) {
        renderTitle("Available seats");

        for (int i = 1; i <= Ticket.ticketDB.getTickets(flight).size(); i++) {
            if(Ticket.ticketDB.getTickets(flight).get(i - 1).getStatus().equals("available")) {
                System.out.printf("%-6s", Ticket.ticketDB.getTickets(flight).get(i - 1).getSeat());
            } else {
                System.out.printf("%-6s", " ");
            }

            if (i % 6 == 0) {
                System.out.println();
            } else if (i % 3 == 0) {
                System.out.print("   ");
            }
        }

        System.out.println();
    }

    public static void showTicketMenu() {

    }

    public static void showReturnTicketMenu() {

    }
}
