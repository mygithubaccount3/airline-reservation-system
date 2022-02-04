package com.airlinereservationsystem.flights;

import com.airlinereservationsystem.Airline;
import com.airlinereservationsystem.Gate;
import com.airlinereservationsystem.Status;

public class NewFlight implements Flight {
    private final String flight;
    private String departureTime = "00:00";
    private String arrivalTime = "00:00";
    private final String arrivalStation;
    private String departureStation;
    private final Airline airline;
    private char terminal = 'D';
    private Gate gate = Gate.D1;
    private Status status = Status.EXPECTED;

    @Override
    public String toString() {
        return "Flight: %s Airline: %s".formatted(flight, airline);
    }

    public NewFlight(
            String flight, String departureTime, String arrivalTime, String arrivalStation, Airline airline,
            char terminal, Gate gate, Status status) {
        this.flight = flight;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.arrivalStation = arrivalStation;
        this.airline = airline;
        this.terminal = terminal;
        this.gate = gate;
        this.status = status;
    }

    public NewFlight(String flight, String arrivalStation, String departureStation, Airline airline) {
        this.flight = flight;
        this.arrivalStation = arrivalStation;
        this.departureStation = departureStation;
        this.airline = airline;
    }

    @Override
    public String flight() {
        return flight;
    }

    @Override
    public String arrivalTime() {
        return arrivalTime;
    }

    @Override
    public String departureTime() {
        return departureTime;
    }

    @Override
    public String arrivalStation() {
        return arrivalStation;
    }

    @Override
    public Airline airline() {
        return airline;
    }

    @Override
    public char terminal() {
        return terminal;
    }

    @Override
    public Gate gate() {
        return gate;
    }

    @Override
    public Status status() {
        return status;
    }
}
