package com.thoughtworks.movierental;

public class TextStatement implements Statement{

    private final String customerName;
    private final Rentals rentals;

    public TextStatement(String customerName, Rentals rentals) {
        this.customerName = customerName;
        this.rentals = rentals;
    }

    @Override
    public String generate() {
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
        return "Rental Record for " + customerName + "\n";
    }
}
