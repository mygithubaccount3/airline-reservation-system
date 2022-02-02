package com.airlinereservationsystem;

public class Flight {
    private final String flight;
    private String departureTime = "00:00";
    private String arrivalTime = "00:00";
    private final String arrivalStation;
    private String departureStation;
    private final Airline airline;
    private char terminal = 'D';
    private Gate gate = Gate.D1;
    private Status status = Status.EXPECTED;
    public static final FlightDatabase flightDB = new FlightDatabase();

    @Override
    public String toString() {
        return "Flight: %s Airline: %s".formatted(this.flight, this.airline);
    }

    public Flight(
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

    public Flight(String flight, String arrivalStation, String departureStation, Airline airline) {
        this.flight = flight;
        this.arrivalStation = arrivalStation;
        this.departureStation = departureStation;
        this.airline = airline;
    }

    public String getFlight() {
        return flight;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public Airline getAirline() {
        return airline;
    }

    public char getTerminal() {
        return terminal;
    }

    public Gate getGate() {
        return gate;
    }

    public Status getStatus() {
        return status;
    }
}
