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
        int frequentRenterPoints = movie.frequentRenterPoints(daysRented);
        if (movie.getPriceCode() == Movie.ULTRA_HD) return 3;
        if (movie.getPriceCode() == Movie.NEW_RELEASE) frequentRenterPoints = movie.frequentRenterPoints(daysRented);
        return frequentRenterPoints;
    }

    public double amount() {
        double thisAmount = 0;
        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (daysRented > 2)
                    thisAmount += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;
            case Movie.CHILDREN:
                thisAmount += 1.5;
                if (daysRented > 3)
                    thisAmount += (daysRented - 3) * 1.5;
                break;
        }
        return thisAmount;
    }
}