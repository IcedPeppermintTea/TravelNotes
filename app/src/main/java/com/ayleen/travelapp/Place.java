package com.ayleen.travelapp;

public class Place {
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String description;

    public Place(String name, String address, String city, String state, String zip, String description) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.description = description;
    }

    // Getters for each property
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getDescription() {
        return description;
    }
}
