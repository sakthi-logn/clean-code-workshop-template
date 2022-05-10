package com.thoughtworks.movierental;

import java.util.List;

public class Rentals {

    private List<Rental> rentals;

    public Rentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public void add(Rental rental) {
        rentals.add(rental);
    }
}
