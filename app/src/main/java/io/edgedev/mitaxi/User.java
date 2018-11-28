package io.edgedev.mitaxi;

/**
 * Created by OPEYEMI OLORUNLEKE on 6/13/2017.
 */

public class User {

    private String name;
    private String email;
    private boolean rider;

    public User() {
    }

    public User(String name, String email, boolean rider) {
        this.name = name;
        this.email = email;

        this.rider = rider;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isRider() {
        return rider;
    }
}