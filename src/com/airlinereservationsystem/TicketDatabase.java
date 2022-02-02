package com.airlinereservationsystem;

import com.airlinereservationsystem.tickets.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketDatabase {
    private final ArrayList<Ticket> tickets = new ArrayList<>();

    public TicketDatabase(FlightDatabase flightDatabase) {
        Flight[] flights = flightDatabase.getFlights();

        for (Flight flight : flights) {
            for (int i = 1; i <= 200; i++) {
                tickets.add(new Ticket(i, "econom", flight));
            }
        }
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public List<Ticket> getTickets(Flight flight) {
        return tickets.stream().filter((Ticket ticket) -> ticket.getFlight().equals(flight)).toList();
    }
}
