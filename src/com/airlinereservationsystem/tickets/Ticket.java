package com.airlinereservationsystem.tickets;

import com.airlinereservationsystem.flights.Flight;

public interface Ticket {
    void buy(String owner);

    int seat();

    float price();

    String status();

    void status(String status);

    Flight flight();

    void owner(String owner);
}
