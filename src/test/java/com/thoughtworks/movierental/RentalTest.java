package com.thoughtworks.movierental;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RentalTest {

    @Test
    @Disabled
    void frequentRenterPointsForUltraHD() {
        Movie ultraHdMovie1 = new Movie("Avatar-2", Movie.ULTRA_HD);
        Rental rental1 = new Rental(ultraHdMovie1, 4);
        assertEquals(3, rental1.frequentRenterPoints());
    }
}