package com.airlinereservationsystem.tickets;

import com.airlinereservationsystem.Flight;
import com.airlinereservationsystem.FlightDatabase;
import com.airlinereservationsystem.TicketDatabase;

public class Ticket {
    ///Inheritance: Ticket -> Econom, Premium
    //calculate price depend on class, in setter
    public static final float ECONOM_PRICE = 5.0f;
    public static final float PREMIUM_PRICE = 9.0f;
    private int seat;
    private float price;
    private String seatClass;
    private Flight flight;
    private String status;
    private String owner;

    private static final FlightDatabase flightDB = Flight.flightDB;
    public static final TicketDatabase ticketDB = new TicketDatabase(flightDB);

    public Ticket(int seat, String seatClass, Flight flight) {
        this.seat = seat;
        this.price = seatClass.equals("econom") ? ECONOM_PRICE : PREMIUM_PRICE;
        this.seatClass = seatClass;
        this.flight = flight;
        this.status = "available";
    }

    public Ticket() {
        this.status = "available";
    }

    public void buy(String owner) {
        this.setStatus("sold");
        this.setOwner(owner);
        System.out.println("Ticket is bought");
    }

    public int getSeat() {
        return seat;
    }

    public float getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
