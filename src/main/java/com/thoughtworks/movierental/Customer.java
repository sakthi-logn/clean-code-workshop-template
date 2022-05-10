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
        String result = "Rental Record for " + getName() + "\n";
        result += rentals.transform(rental ->
                "\t" + rental.title() + "\t" + rental.amount() + "\n");

        //add footer lines result
        result += "Amount owed is " + rentals.totalAmount() + "\n";
        result += "You earned " + rentals.frequentRenterPoints()
                + " frequent renter points";
        return result;
    }

    public String htmlStatement() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Rental Records</title>\n" +
                "</head>\n" +
                "<body>\n" +
                String.format("<h1>Rental Record for <b>%s</b></h1>\n", getName()) +
                rentals.transform(rental -> String.format("%s&ensp;%s<br>\n", rental.title(), rental.amount())) +
                String.format("Amount owed is <b>%s</b><br>\n", rentals.totalAmount()) +
                String.format("You earned <b>%s</b> frequent renter points<br>\n", rentals.frequentRenterPoints()) +
                "</body>\n" +
                "</html>";
    }
}
