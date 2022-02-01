package com.airlinereservationsystem;

import com.airlinereservationsystem.tickets.Ticket;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

public class Flight {
    private final String flight;
    private String departureTime = "00:00";
    private String arrivalTime = "00:00";
    private String arrivalStation;
    private String departureStation;
    private final Airline airline;
    private char terminal = 'D';
    private Gate gate = Gate.D1;
    private Status status = Status.EXPECTED;
    private List<Ticket> tickets = new ArrayList<>();

    public static Flight[] flights = {
            new Flight("PQ 762",
                    DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(20, 15)),
                    DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(1, 10)),
                    "Madrid",
                    Airline.SKY_UP_AIRLINES,
                    'D',
                    null,
                    Status.EXPECTED,
                    new ArrayList<>() {{
                        for (int i = 1; i <= 200; i++) {
                            this.add(new Ticket(i, "econom", null));
                        }
                    }}
            ),
            new Flight("FR 2740",
                    DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(20, 15)),
                    DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(4, 35)),
                    "Karlsruhe/Baden Baden",
                    Airline.RYANAIR,
                    'D',
                    null,
                    Status.ARRIVED,
                    new ArrayList<>() {{
                        for (int i = 1; i <= 200; i++) {
                            this.add(new Ticket(i, "econom", null));
                        }
                    }}
            ),
            new Flight("PQ 7524",
                    DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(20, 20)),
                    DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(3, 20)),
                    "Sharm El Sheikh",
                    Airline.SKY_UP_AIRLINES,
                    'D',
                    null,
                    Status.ARRIVED,
                    new ArrayList<>() {{
                        for (int i = 1; i <= 200; i++) {
                            this.add(new Ticket(i, "econom", null));
                        }
                    }}
            ),
            new Flight("FR 3825",
                    DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(20, 20)),
                    DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(5, 5)),
                    "Naples",
                    Airline.RYANAIR,
                    'D',
                    null,
                    Status.ARRIVED,
                    new ArrayList<>() {{
                        for (int i = 1; i <= 200; i++) {
                            this.add(new Ticket(i, "econom", null));
                        }
                    }}
            ),
            new Flight("LH 1492",
                    DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(20, 35)),
                    DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(0, 10)),
                    "Frankfurt",
                    Airline.LUFTHANSA,
                    'D',
                    null,
                    Status.EXPECTED,
                    new ArrayList<>() {{
                        for (int i = 1; i <= 200; i++) {
                            this.add(new Ticket(i, "econom", null));
                        }
                    }}
            ),
            new Flight("FR 7854",
                    DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(20, 45)),
                    DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(23, 25)),
                    "Catania",
                    Airline.RYANAIR,
                    'D',
                    null,
                    Status.EXPECTED,
                    new ArrayList<>() {{
                        for (int i = 1; i <= 200; i++) {
                            this.add(new Ticket(i, "econom", null));
                        }
                    }}
            ),
            new Flight("FR 9515",
                    "21:00",
                    "02:50",
                    "Athens",
                    Airline.RYANAIR,
                    'D',
                    null,
                    Status.EXPECTED,
                    new ArrayList<>() {{
                        for (int i = 1; i <= 200; i++) {
                            this.add(new Ticket(i, "econom", null));
                        }
                    }}
            ),

    };

    @Override
    public String toString() {
        return "Flight: %s Airline: %s".formatted(this.flight, this.airline);
    }

    public Flight(
            String flight, String departureTime, String arrivalTime, String arrivalStation, Airline airline,
            char terminal, Gate gate, Status status, List<Ticket> tickets) {
        this.flight = flight;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.arrivalStation = arrivalStation;
        this.airline = airline;
        this.terminal = terminal;
        this.gate = gate;
        this.status = status;
        this.tickets = tickets;
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

    public List<Ticket> getTickets() {
        return this.tickets;
    }
}
