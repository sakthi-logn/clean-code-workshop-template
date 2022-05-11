package com.thoughtworks.movierental.movie;

public class Regular extends Movie {
    public Regular(String title) {
        super(title, Movie.REGULAR);
    }

    @Override
    public double amount(int daysRented) {
        double thisAmount = super.amount(daysRented);
        thisAmount += 2;
        if (daysRented > 2)
            thisAmount += (daysRented - 2) * 1.5;
        return thisAmount;
    }
}
