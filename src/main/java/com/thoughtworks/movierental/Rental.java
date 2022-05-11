package com.thoughtworks.movierental;

import com.thoughtworks.movierental.movie.Movie;

public class Rental {
    private final int daysRented;
    private final Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public String title() {
        return movie.getTitle();
    }

    public int frequentRenterPoints() {
        return movie.frequentRenterPoints(daysRented);
    }

    public double amount() {
        double thisAmount = movie.amount(daysRented);
        return thisAmount;
    }
}