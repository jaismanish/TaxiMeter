package src.java.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.java.main.Bill;
import src.java.main.FareBill;
import src.java.main.Ride;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FareBillTest {

    private FareBill calculator;
    private List<Ride> rides;

    @BeforeEach
    void setUp() {
        calculator = new FareBill();
        rides = new ArrayList<>();
        rides.add(new Ride(0, 0));
        rides.add(new Ride(2, 0));
        rides.add(new Ride(0, 10));
    }

    @Test
    void testCalcTotalFareWithEmptyRidesList() {
        Bill fare = calculator.calculateTotalFareBreakdown(new ArrayList<>());
        assertEquals(0.0, fare.getTotalFare(), 0.01);
    }

    @Test
    void testCalculateTotalFareWithMultipleRides() {
        Bill fare = calculator.calculateTotalFareBreakdown(rides);
        assertEquals(76, fare.getTotalFare(), 0.01);
    }
}
