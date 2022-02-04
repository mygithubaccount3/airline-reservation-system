package com.airlinereservationsystem.databases;

import com.airlinereservationsystem.Airline;
import com.airlinereservationsystem.Status;
import com.airlinereservationsystem.flights.Flight;
import com.airlinereservationsystem.flights.NewFlight;
import com.airlinereservationsystem.tickets.Ticket;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

public final class DatabaseConnection {
    public static final Database<List<Flight>, Flight> flightDB = new FlightDatabase(
            List.of(
                    new NewFlight("PQ 762",
                            DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(20, 15)),
                            DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(1, 10)),
                            "Madrid",
                            Airline.SKY_UP_AIRLINES,
                            'D',
                            null,
                            Status.EXPECTED
                    ),
                    new NewFlight("FR 2740",
                            DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(20, 15)),
                            DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(4, 35)),
                            "Karlsruhe/Baden Baden",
                            Airline.RYANAIR,
                            'D',
                            null,
                            Status.ARRIVED
                    ),
                    new NewFlight("PQ 7524",
                            DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(20, 20)),
                            DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(3, 20)),
                            "Sharm El Sheikh",
                            Airline.SKY_UP_AIRLINES,
                            'D',
                            null,
                            Status.ARRIVED
                    ),
                    new NewFlight("FR 3825",
                            DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(20, 20)),
                            DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(5, 5)),
                            "Naples",
                            Airline.RYANAIR,
                            'D',
                            null,
                            Status.ARRIVED
                    ),
                    new NewFlight("LH 1492",
                            DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(20, 35)),
                            DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(0, 10)),
                            "Frankfurt",
                            Airline.LUFTHANSA,
                            'D',
                            null,
                            Status.EXPECTED
                    ),
                    new NewFlight("FR 7854",
                            DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(20, 45)),
                            DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.of(23, 25)),
                            "Catania",
                            Airline.RYANAIR,
                            'D',
                            null,
                            Status.EXPECTED
                    ),
                    new NewFlight("FR 9515",
                            "21:00",
                            "02:50",
                            "Athens",
                            Airline.RYANAIR,
                            'D',
                            null,
                            Status.EXPECTED
                    )
            )
    );
    public static final Database<List<Ticket>, Flight> ticketDB = new TicketDatabase(flightDB);
}
