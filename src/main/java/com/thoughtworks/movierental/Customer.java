package com.thoughtworks.movierental;

import java.util.ArrayList;

public class Customer {
    private final String name;
    private final Rentals rentals = new Rentals(new ArrayList<>());
    private final Statement htmlStatement;

    public Customer(String name) {
        this.name = name;
        this.htmlStatement = new HtmlStatement(name, rentals);
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
        return htmlStatement.generate();
    }

    private String htmlStatementBody() {
        return rentals.transform(rental -> String.format("%s&ensp;%s<br>\n", rental.title(), rental.amount()));
    }

    private String htmlStatementHeader() {
        return String.format("<h1>Rental Record for <b>%s</b></h1>\n", getName());
    }

    private String htmlStatementFooter() {
        return String.format("Amount owed is <b>%s</b><br>\n", rentals.totalAmount()) +
                String.format("You earned <b>%s</b> frequent renter points<br>\n", rentals.frequentRenterPoints());
    }
}
