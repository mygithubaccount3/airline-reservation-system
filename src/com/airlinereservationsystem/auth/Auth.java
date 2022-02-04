package com.airlinereservationsystem.auth;

import com.airlinereservationsystem.utils.Utils;

public class Auth implements AuthService {
    private final Utils utils;

    public Auth(Utils utils) {
        this.utils = utils;
    }

    @Override
    public boolean signIn(String email, String password) {
        if (!utils.checkInput(email, "^[\\w+.-]+@(.+)$")) {
            System.out.println("Invalid email. Try again");
            return false;
        } else if(!utils.checkInput(password, ".*")) {
            System.out.println("Invalid password. Try again");
            return false;
        }

        return true;
    }
}
