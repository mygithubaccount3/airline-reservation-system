package com.airlinereservationsystem.databases;

public interface Database<T, U> {//how to name second argument
    T get();
    T get(U el);
}
