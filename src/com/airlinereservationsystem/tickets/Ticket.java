package com.airlinereservationsystem.tickets;

public class Ticket {
    ///Inheritance: Ticket -> Econom, Premium
    //calculate price depend on class, in setter
    public static final float ECONOM_PRICE = 5.0f;
    public static final float PREMIUM_PRICE = 9.0f;
    private int seat;
    private float price;
    private String seatClass;

    private String status;

    private String owner;

    public Ticket(int seat, String seatClass, String owner) {
        this.seat = seat;
        this.price = seatClass.equals("econom") ? ECONOM_PRICE : PREMIUM_PRICE;
        this.seatClass = seatClass;
        this.owner = owner;
        this.status = "available";
    }
    public Ticket(String owner) {
        this.owner = owner;
        this.status = "available";
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

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
