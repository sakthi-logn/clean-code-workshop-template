package com.thoughtworks.movierental.movie;

public class NewRelease extends Movie {
    public NewRelease(String title) {
        super(title, Movie.NEW_RELEASE);
    }

    @Override
    public int frequentRenterPoints(int daysRented) {
        if (daysRented > 1) return super.frequentRenterPoints(daysRented) + 1;
        else return super.frequentRenterPoints(daysRented);
    }
}
