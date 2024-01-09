package org.example.repository;

import org.example.Controller.Authorities;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public List<Authorities> getUserAuthorities(String user, String password) {

        if (user.equals("john") && password.equals("password123")) {
            List<Authorities> authorities = new ArrayList<>();
            authorities.add(Authorities.READ);
            authorities.add(Authorities.WRITE);
            return authorities;
        } else {
            return new ArrayList<>();
        }
    }
}