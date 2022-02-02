package com.airlinereservationsystem;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FlightDatabase {
    private final Flight[] flights = {
            new Flight("PQ 762",
                    DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(20, 15)),
                    DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(1, 10)),
                    "Madrid",
                    Airline.SKY_UP_AIRLINES,
                    'D',
                    null,
                    Status.EXPECTED
            ),
            new Flight("FR 2740",
                    DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(20, 15)),
                    DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(4, 35)),
                    "Karlsruhe/Baden Baden",
                    Airline.RYANAIR,
                    'D',
                    null,
                    Status.ARRIVED
            ),
            new Flight("PQ 7524",
                    DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(20, 20)),
                    DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(3, 20)),
                    "Sharm El Sheikh",
                    Airline.SKY_UP_AIRLINES,
                    'D',
                    null,
                    Status.ARRIVED
            ),
            new Flight("FR 3825",
                    DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(20, 20)),
                    DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(5, 5)),
                    "Naples",
                    Airline.RYANAIR,
                    'D',
                    null,
                    Status.ARRIVED
            ),
            new Flight("LH 1492",
                    DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(20, 35)),
                    DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(0, 10)),
                    "Frankfurt",
                    Airline.LUFTHANSA,
                    'D',
                    null,
                    Status.EXPECTED
            ),
            new Flight("FR 7854",
                    DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(20, 45)),
                    DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(23, 25)),
                    "Catania",
                    Airline.RYANAIR,
                    'D',
                    null,
                    Status.EXPECTED
            ),
            new Flight("FR 9515",
                    "21:00",
                    "02:50",
                    "Athens",
                    Airline.RYANAIR,
                    'D',
                    null,
                    Status.EXPECTED
            ),
    };

    public Flight[] getFlights() {
        return flights;
    }
}
