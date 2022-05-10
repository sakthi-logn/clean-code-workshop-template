package com.thoughtworks.movierental;

import java.util.List;

public class Rentals {

    private final List<Rental> rentals;

    public Rentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public void add(Rental rental) {
        rentals.add(rental);
    }

    public double totalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.amount();
        }
        return totalAmount;
    }

    public int frequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.frequentRenterPoints();
        }
        return frequentRenterPoints;
    }
}
