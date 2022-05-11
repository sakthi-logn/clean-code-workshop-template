package com.thoughtworks.movierental;

import java.util.ArrayList;

public class Customer {
    private final String name;
    private final Rentals rentals = new Rentals(new ArrayList<>());

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
        return header() + body() + footer();
    }

    private String footer() {
        return "Amount owed is " + rentals.totalAmount() + "\n"
                + "You earned " + rentals.frequentRenterPoints()
                + " frequent renter points";
    }

    private String body() {
        return rentals.transform(rental ->
                "\t" + rental.title() + "\t" + rental.amount() + "\n");
    }

    private String header() {
        return "Rental Record for " + getName() + "\n";
    }

    public String htmlStatement() {
        return "";
    }
}
