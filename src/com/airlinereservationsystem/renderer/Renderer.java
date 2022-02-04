package com.airlinereservationsystem.renderer;

import com.airlinereservationsystem.flights.Flight;

import java.util.List;

public interface Renderer {
    void showMainMenu();

    void showSchedule();

    void renderAvailableFlights(List<Flight> flights);

    void renderAvailableSeats(Flight flight);

    void showTicketMenu();

    void showReturnTicketMenu();
}
