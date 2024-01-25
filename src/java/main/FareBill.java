package src.java.main;

import java.util.List;

public class FareBill {

    public Bill calculateTotalFareBreakdown(List<Ride> rides) {
        double totalDistanceFare = 0.0;
        double totalWaitingTimeFare = 0.0;
        double totalServiceFee = 0.0;
        double totalFare = 0.0;

        for (Ride ride : rides) {
            Bill breakdown = ride.calculateFareAndBreakdown();
            totalDistanceFare += breakdown.getDistanceFare();
            totalWaitingTimeFare += breakdown.getWaitingTimeFare();
            totalServiceFee += breakdown.getServiceFee();
            totalFare += breakdown.getTotalFare();
        }

        return new Bill(totalDistanceFare, totalWaitingTimeFare, totalServiceFee, totalFare);
    }
}
