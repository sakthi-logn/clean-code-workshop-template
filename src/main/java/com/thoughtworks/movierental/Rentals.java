package com.thoughtworks.movierental;

import java.util.List;
import java.util.function.Function;

public class Rentals {

    private final List<Rental> rentals;

    public Rentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public void add(Rental rental) {
        rentals.add(rental);
    }

    public double totalAmount() {
        return rentals.stream().map(Rental::amount).mapToDouble(amount -> amount).sum();
    }

    public int frequentRenterPoints() {
        return rentals.stream().map(Rental::frequentRenterPoints).mapToInt(points -> points).sum();
    }

    public String transform(Function<Rental, String> transformer) {
        return rentals.stream().map(transformer).reduce("", (r1, r2) -> r1 + r2);
    }
}
