package com.airlinereservationsystem.databases;

import com.airlinereservationsystem.flights.Flight;

import java.util.List;

public class FlightDatabase implements Database<List<Flight>, Flight> {
    private final List<Flight> flights;

    FlightDatabase(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public List<Flight> get() {
        return flights;
    }

    @Override
    public List<Flight> get(Flight flight) {
        return flights;//not implemented
    }
}
