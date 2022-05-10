package com.thoughtworks.movierental;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";
        LocalDateTime timeBeforeLoopStart = LocalDateTime.now();
        int frequentRenterPoints = frequentRenterPoints();
        for (Rental rental : rentals) {
            //show figures for this rental
            result += "\t" + rental.title() + "\t" +
                    rental.amount() + "\n";
        }
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.amount();
        }
        LocalDateTime timeAfterLoopEnd = LocalDateTime.now();
        System.out.printf("time taken in milliseconds for iterating all rentals 3 times : %s\n",
                Duration.between(timeBeforeLoopStart, timeAfterLoopEnd).toMillis());

        //add footer lines result
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints
                + " frequent renter points";
        return result;
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
