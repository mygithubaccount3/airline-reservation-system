package com.airlinereservationsystem.tickets;

import com.airlinereservationsystem.flights.Flight;

public class NewTicket implements Ticket {
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

    public NewTicket(int seat, String seatClass, Flight flight) {
        this.seat = seat;
        this.price = seatClass.equals("econom") ? ECONOM_PRICE : PREMIUM_PRICE;
        this.seatClass = seatClass;
        this.flight = flight;
        status = "available";
    }

    public NewTicket() {
        status = "available";
    }

    @Override
    public void buy(String owner) {
        status("sold");
        owner(owner);
        System.out.println("Ticket is bought");
    }

    @Override
    public int seat() {
        return seat;
    }

    @Override
    public float price() {
        return price;
    }

    @Override
    public String status() {
        return status;
    }

    @Override
    public void status(String status) {
        this.status = status;
    }

    @Override
    public Flight flight() {
        return flight;
    }

    @Override
    public void owner(String owner) {
        this.owner = owner;
    }
}
