package com.airlinereservationsystem.auth;

public interface AuthService {
    boolean signIn(String email, String password);
}
