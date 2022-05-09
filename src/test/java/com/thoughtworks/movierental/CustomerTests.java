package com.thoughtworks.movierental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    public void shouldReturnStatement() {
        Customer customer = new Customer("bob");

        customer.addRental(new Rental(new Movie("movie-1", Movie.REGULAR), 4));
        customer.addRental(new Rental(new Movie("movie-2", Movie.CHILDRENS), 5));
        customer.addRental(new Rental(new Movie("movie-3", Movie.NEW_RELEASE), 6));

        assertEquals("Rental Record for bob\n" +
                "\tmovie-1\t5.0\n" +
                "\tmovie-2\t4.5\n" +
                "\tmovie-3\t18.0\n" +
                "Amount owed is 27.5\n" +
                "You earned 4 frequent renter points", customer.statement());
    }
}