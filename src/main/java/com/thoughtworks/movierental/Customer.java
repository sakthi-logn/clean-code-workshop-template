package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();
    private final Rentals rentals1 = new Rentals(new ArrayList<>());

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
        rentals1.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : rentals) {
            //show figures for this rental
            result += "\t" + rental.title() + "\t" +
                    rental.amount() + "\n";
        }

        //add footer lines result
        result += "Amount owed is " + totalAmount() + "\n";
        result += "You earned " + frequentRenterPoints()
                + " frequent renter points";
        return result;
    }

    private double totalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.amount();
        }
        return totalAmount;
    }

    private int frequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.frequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    public String htmlStatement() {
        return "";
    }
}
