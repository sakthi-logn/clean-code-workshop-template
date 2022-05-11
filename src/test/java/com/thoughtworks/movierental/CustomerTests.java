package com.thoughtworks.movierental;

import com.thoughtworks.movierental.movie.Children;
import com.thoughtworks.movierental.movie.Movie;
import com.thoughtworks.movierental.movie.NewRelease;
import com.thoughtworks.movierental.movie.Regular;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    public void shouldReturnStatement() {
        Customer customer = new Customer("bob");

        customer.addRental(new Rental(new Regular("movie-1"), 4));
        customer.addRental(new Rental(new Children("movie-2"), 5));
        customer.addRental(new Rental(new NewRelease("movie-3"), 6));

        assertEquals("Rental Record for bob\n" +
                "\tmovie-1\t5.0\n" +
                "\tmovie-2\t4.5\n" +
                "\tmovie-3\t18.0\n" +
                "Amount owed is 27.5\n" +
                "You earned 4 frequent renter points", customer.statement());
    }

    @Test
    public void shouldReturnHtmlStatement() {
        Customer customer = new Customer("bob");

        customer.addRental(new Rental(new Regular("movie-1"), 4));
        customer.addRental(new Rental(new Children("movie-2"), 5));
        customer.addRental(new Rental(new NewRelease("movie-3"), 6));

        String htmlStatement = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Rental Records</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Rental Record for <b>bob</b></h1>\n" +
                "movie-1&ensp;5.0<br>\n" +
                "movie-2&ensp;4.5<br>\n" +
                "movie-3&ensp;18.0<br>\n" +
                "Amount owed is <b>27.5</b><br>\n" +
                "You earned <b>4</b> frequent renter points<br>\n" +
                "</body>\n" +
                "</html>";

        assertEquals(htmlStatement, customer.htmlStatement());
    }
}