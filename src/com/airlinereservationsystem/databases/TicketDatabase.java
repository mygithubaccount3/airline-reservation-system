package com.airlinereservationsystem.databases;

import com.airlinereservationsystem.flights.Flight;
import com.airlinereservationsystem.tickets.NewTicket;
import com.airlinereservationsystem.tickets.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketDatabase implements Database<List<Ticket>, Flight> {
    private final List<Ticket> tickets = new ArrayList<>();

    public TicketDatabase(Database<List<Flight>, Flight> flightDatabase) {//move to DatabaseConnection?
        List<Flight> flights = flightDatabase.get();

        for (Flight flight : flights) {
            for (int i = 1; i <= 200; i++) {
                tickets.add(new NewTicket(i, "econom", flight));
            }
        }
    }

    @Override
    public List<Ticket> get() {
        return tickets;
    }

    @Override
    public List<Ticket> get(Flight flight) {
        return tickets.stream().filter((Ticket ticket) -> ticket.flight().equals(flight)).toList();
    }
}
