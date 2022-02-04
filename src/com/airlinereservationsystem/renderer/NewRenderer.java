package com.airlinereservationsystem.renderer;

import com.airlinereservationsystem.databases.DatabaseConnection;
import com.airlinereservationsystem.flights.Flight;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NewRenderer implements Renderer {
    private static final Map<String, Integer> map = new LinkedHashMap<>() {{
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
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Override
    public void showMainMenu() {
        clearConsole();
        renderTitle("Menu");
        System.out.println("1. Show schedule");
        System.out.println("2. Buy tickets");
        System.out.println("3. Return ticket");
        System.out.println("4. Quit");
        System.out.println("5. Sign out");
    }

    @Override
    public void showSchedule() {
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

        for (Flight flight : DatabaseConnection.flightDB.get()) {
            System.out.printf("%-15s", flight.flight());
            System.out.printf("%-15s", flight.arrivalTime());
            System.out.printf("%-20s", flight.departureTime() != null ? flight.departureTime() : "-");
            System.out.printf("%-40s", flight.arrivalStation());
            System.out.printf("%-40s", flight.airline());
            System.out.printf("%-10s", flight.terminal());
            System.out.printf("%-10s", flight.gate() != null ? flight.gate() : "-");
            System.out.println(flight.status());
        }
    }

    @Override
    public void renderAvailableFlights(List<Flight> flights) {
        renderTitle("Available flights");

        for (int i = 0; i < flights.size(); i++) {
            System.out.println(i + 1 + ". " + flights.get(i));
        }
    }

    @Override
    public void renderAvailableSeats(Flight flight) {
        renderTitle("Available seats");

        for (int i = 1; i <= DatabaseConnection.ticketDB.get(flight).size(); i++) {//declare ticketDB in top of method
            if(DatabaseConnection.ticketDB.get(flight).get(i - 1).status().equals("available")) {
                System.out.printf("%-6s", DatabaseConnection.ticketDB.get(flight).get(i - 1).seat());
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

    @Override
    public void showTicketMenu() {

    }

    @Override
    public void showReturnTicketMenu() {

    }
}
