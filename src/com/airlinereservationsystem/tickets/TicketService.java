package com.airlinereservationsystem.tickets;

import com.airlinereservationsystem.Flight;
import com.airlinereservationsystem.Renderer;
import com.airlinereservationsystem.utils.Utils;

import java.text.NumberFormat;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public final class TicketService {

    private static int selectSeat(Flight chosenFlight) {
        String selectedSeat = Utils.readInput("Choose seat (press ENTER to randomly select a seat): ", new Scanner(System.in));
        boolean isSeatAvailable = false;
        int seatToBuy = 0;

        if (selectedSeat.equals("")) {
            int randomSeat = 0;

            while (!isSeatAvailable) {
                randomSeat = ThreadLocalRandom.current().nextInt(1, Ticket.ticketDB.getTickets(chosenFlight).size() + 1);
                int finalRandomSeat = randomSeat;
                List<Ticket> ticket = Ticket.ticketDB.getTickets(chosenFlight).stream().filter((Ticket seat) -> seat.getSeat() == finalRandomSeat).toList();
                isSeatAvailable = ticket.get(0).getStatus().equals("available");
            }

            seatToBuy = randomSeat;
        } else {
            List<Ticket> tk = Ticket.ticketDB.getTickets(chosenFlight).stream().filter((Ticket seat) -> seat.getSeat() == Integer.parseInt(selectedSeat)).toList();
            isSeatAvailable = tk.get(0).getStatus().equals("available");

            if (isSeatAvailable) seatToBuy = Integer.parseInt(selectedSeat);
        }

        if (seatToBuy > 0) {
            System.out.println("Seat #" + seatToBuy);
            System.out.println("Price: " + NumberFormat.getCurrencyInstance().format(Ticket.PREMIUM_PRICE));
        }

        return seatToBuy;
    }

    private static List<Flight> findAvailableFlights(Flight[] flights, Scanner scanner) {
        while (true) {
            String arrivalStation = Utils.readInput("To: ", scanner);
            String timeFrom = Utils.readInput("Time (from) (ex: 22:30) (press ENTER to set 00:00): ", "00:00", scanner);

            if (Utils.checkInput(timeFrom, "\\d{2}:\\d{2}")) {
                return Arrays.stream(flights)
                        .filter((Flight flight) -> flight.getArrivalStation().equals(arrivalStation) &&
                                LocalTime.parse(timeFrom).isBefore(LocalTime.parse(flight.getDepartureTime()))).toList();
            }

            System.out.println("Invalid time");
        }
    }

    public static void chooseTicket(String owner) {
        Scanner scanner = new Scanner(System.in);
        List<Flight> availableFlights = findAvailableFlights(Flight.flightDB.getFlights(), scanner);

        if (availableFlights.size() > 0) {
            Renderer.renderAvailableFlights(availableFlights);

            int flight = Integer.parseInt(Utils.readInput("Choose flight: ", scanner));

            if (flight >= 1 || flight < availableFlights.size()) {
                Flight chosenFlight = availableFlights.get(flight - 1);

                Renderer.renderAvailableSeats(chosenFlight);

                while (true) {
                    int seatToBuy = selectSeat(chosenFlight);

                    if (seatToBuy > 0) {
                        String doBuy = Utils.readInput("Buy? (y/n)", scanner);

                        if (doBuy.equalsIgnoreCase("y")) {
                            var ticket = Ticket.ticketDB.getTickets(chosenFlight).stream().filter((Ticket tk) -> tk.getSeat() == seatToBuy).toList();
                            ticket.get(0).buy(owner);
                            break;
                        } else if (doBuy.equalsIgnoreCase("n")) System.out.println("Operation is canceled");
                    } else System.out.println("Ticket is not available");
                }
            }
        } else System.out.println("No available flights");
    }
}
