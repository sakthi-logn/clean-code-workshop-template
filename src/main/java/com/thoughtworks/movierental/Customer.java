package com.thoughtworks.movierental;

import java.util.ArrayList;

public class Customer {
    private final String name;
    private final Rentals rentals = new Rentals(new ArrayList<>());
    private final Statement textStatement;
    private final Statement htmlStatement;

    public Customer(String name) {
        this.name = name;
        this.textStatement = new TextStatement(name, rentals);
        this.htmlStatement = new HtmlStatement(name, rentals);
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return this.textStatement.generate();
    }

    public String htmlStatement() {
        return htmlStatement.generate();
    }

}
