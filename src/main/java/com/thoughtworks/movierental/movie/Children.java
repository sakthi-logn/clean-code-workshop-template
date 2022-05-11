package com.thoughtworks.movierental.movie;

public class Children extends Movie {
    public Children(String title) {
        super(title, Movie.CHILDREN);
    }

    @Override
    public double amount(int daysRented) {
        double thisAmount = super.amount(daysRented) + 1.5;
        if (daysRented > 3)
            thisAmount += (daysRented - 3) * 1.5;
        return thisAmount;
    }
}
