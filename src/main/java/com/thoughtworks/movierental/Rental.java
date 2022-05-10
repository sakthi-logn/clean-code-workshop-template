package com.thoughtworks.movierental;

public class Rental {
    private int daysRented;
    private Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int frequentRenterPoints() {
        // add frequent renter points
        int frequentRenterPoints = 1;
        // add bonus for a two day new release rental
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE)
                &&
                getDaysRented() > 1) frequentRenterPoints++;
        return frequentRenterPoints;
    }
}