package com.airlinereservationsystem.flights;

import com.airlinereservationsystem.Airline;
import com.airlinereservationsystem.Gate;
import com.airlinereservationsystem.Status;

public interface Flight {
    @Override
    String toString();

    String flight();

    String arrivalTime();

    String departureTime();

    String arrivalStation();

    Airline airline();

    char terminal();

    Gate gate();

    Status status();
}
