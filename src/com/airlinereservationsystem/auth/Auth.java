package com.airlinereservationsystem.auth;

import static com.airlinereservationsystem.utils.Utils.checkInput;

public abstract class Auth {

    public static boolean signIn(String email, String password) {
        if (!checkInput(email, "^[\\w+.-]+@(.+)$")) {
            System.out.println("Invalid email. Try again");
            return false;
        } else if(!checkInput(password, ".*")) {
            System.out.println("Invalid password. Try again");
            return false;
        }

        return true;
    }
}
