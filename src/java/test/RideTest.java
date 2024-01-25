package src.java.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.java.main.Bill;
import src.java.main.Ride;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RideTest {

    private Ride ride;
    private List<Ride> rides;

    @BeforeEach
    void setUp() {
        rides = new ArrayList<>();
        rides.add(new Ride(0, 0));
        rides.add(new Ride(2, 0));
        rides.add(new Ride(0, 10));
    }

    @Test
    void testCalcFare_shouldReturnMinimumFair_ForZeroDistance() {
        ride = new Ride(0, 0);
        Bill fare = ride.calculateFareAndBreakdown();
        assertEquals(25, fare.getTotalFare(), 0.01);
    }

    @Test
    void testCalcFare_shouldIncludeDistanceCharge() {
        ride = new Ride(2, 0);
        Bill fare = ride.calculateFareAndBreakdown();
        assertEquals(26, fare.getTotalFare(), 0.01);
    }

    @Test
    void testCalcFare_shouldIncludeWaitingTimeCharge() {
        ride = new Ride(0, 10);
        Bill fare = ride.calculateFareAndBreakdown();
        assertEquals(25, fare.getTotalFare(), 0.01);
    }

    @Test
    void testCalcFare_shouldIncludeDistanceAndWaitingTimeCharge() {
        ride = new Ride(1, 10);
        Bill fare = ride.calculateFareAndBreakdown();
        assertEquals(34, fare.getTotalFare(), 0.01);
    }

    @Test
    void testCalculateFareAndBreakdownForRide() {
        Ride ride = new Ride(3, 8);
        Bill breakdown = ride.calculateFareAndBreakdown();
        assertEquals(36, breakdown.getDistanceFare(), 0.01);
        assertEquals(16, breakdown.getWaitingTimeFare(), 0.01);
        assertEquals(0.0, breakdown.getServiceFee(), 0.01);
        assertEquals(54, breakdown.getTotalFare(), 0.01);
    }
}
