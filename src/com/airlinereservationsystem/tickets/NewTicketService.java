package com.airlinereservationsystem.tickets;

import com.airlinereservationsystem.databases.DatabaseConnection;
import com.airlinereservationsystem.flights.Flight;
import com.airlinereservationsystem.renderer.Renderer;
import com.airlinereservationsystem.utils.Utils;

import java.text.NumberFormat;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public final class NewTicketService implements TicketService {
    private final Utils utils;
    private final Renderer renderer;

    public NewTicketService(Utils utils, Renderer renderer) {
        this.utils = utils;
        this.renderer = renderer;
    }

    private int selectSeat(Flight chosenFlight) {
        String selectedSeat = utils.readInput("Choose seat (press ENTER to randomly select a seat): ", new Scanner(System.in));
        boolean isSeatAvailable = false;
        int seatToBuy = 0;

        if (selectedSeat.equals("")) {
            int randomSeat = 0;

            while (!isSeatAvailable) {
                randomSeat = ThreadLocalRandom.current().nextInt(1, DatabaseConnection.ticketDB.get(chosenFlight).size() + 1);
                int finalRandomSeat = randomSeat;
                List<Ticket> ticket = DatabaseConnection.ticketDB.get(chosenFlight).stream().filter((Ticket seat) -> seat.seat() == finalRandomSeat).toList();
                isSeatAvailable = ticket.get(0).status().equals("available");
            }

            seatToBuy = randomSeat;
        } else {
            List<Ticket> tk = DatabaseConnection.ticketDB.get(chosenFlight).stream().filter((Ticket seat) -> seat.seat() == Integer.parseInt(selectedSeat)).toList();
            isSeatAvailable = tk.get(0).status().equals("available");

            if (isSeatAvailable) seatToBuy = Integer.parseInt(selectedSeat);
        }

        if (seatToBuy > 0) {
            System.out.println("Seat #" + seatToBuy);
            System.out.println("Price: " + NumberFormat.getCurrencyInstance().format(NewTicket.PREMIUM_PRICE));
        }

        return seatToBuy;
    }

    private List<Flight> findAvailableFlights(List<Flight> flights, Scanner scanner) {
        while (true) {
            String arrivalStation = utils.readInput("To: ", scanner);
            String timeFrom = utils.readInput("Time (from) (ex: 22:30) (press ENTER to set 00:00): ", "00:00", scanner);

            if (utils.checkInput(timeFrom, "\\d{2}:\\d{2}")) {
                return flights.stream()
                        .filter((Flight flight) -> flight.arrivalStation().equals(arrivalStation) &&
                                LocalTime.parse(timeFrom).isBefore(LocalTime.parse(flight.departureTime()))).toList();
            }

            System.out.println("Invalid time");
        }
    }

    @Override
    public void chooseTicket(String owner) {
        Scanner scanner = new Scanner(System.in);
        List<Flight> availableFlights = findAvailableFlights(DatabaseConnection.flightDB.get(), scanner);

        if (availableFlights.size() > 0) {
            renderer.renderAvailableFlights(availableFlights);

            int flight = Integer.parseInt(utils.readInput("Choose flight: ", scanner));

            if (flight >= 1 || flight < availableFlights.size()) {
                Flight chosenFlight = availableFlights.get(flight - 1);

                renderer.renderAvailableSeats(chosenFlight);

                while (true) {
                    int seatToBuy = selectSeat(chosenFlight);

                    if (seatToBuy > 0) {
                        String doBuy = utils.readInput("Buy? (y/n)", scanner);

                        if (doBuy.equalsIgnoreCase("y")) {
                            var ticket = DatabaseConnection.ticketDB.get(chosenFlight).stream().filter((Ticket tk) -> tk.seat() == seatToBuy).toList();
                            ticket.get(0).buy(owner);
                            break;
                        } else if (doBuy.equalsIgnoreCase("n")) System.out.println("Operation is canceled");
                    } else System.out.println("Ticket is not available");
                }
            }
        } else System.out.println("No available flights");
    }
}
