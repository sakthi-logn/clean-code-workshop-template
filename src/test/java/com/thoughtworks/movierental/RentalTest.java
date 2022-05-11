package com.thoughtworks.movierental;

import com.thoughtworks.movierental.movie.Movie;
import com.thoughtworks.movierental.movie.UltraHd;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RentalTest {

    @Test
    void frequentRenterPointsForUltraHD() {
        Movie ultraHdMovie1 = new UltraHd("Avatar-2");
        Rental rental1 = new Rental(ultraHdMovie1, 4);
        assertEquals(3, rental1.frequentRenterPoints());
    }

    @Test
    void amountForUltraHD(){
        Movie ultraHdMovie1 = new UltraHd("Avatar-2");
        Rental rental1 = new Rental(ultraHdMovie1, 4);
        assertEquals(16, rental1.amount());
    }
}