package com.thoughtworks.movierental.movie;

public class UltraHd extends Movie {
    public UltraHd(String title) {
        super(title, Movie.ULTRA_HD);
    }

    @Override
    public int frequentRenterPoints(int daysRented) {
        return 3;
    }
}
