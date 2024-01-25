package src.java.main;

public class Ride {

    private final double distance;
    private final int waitingTime;

    private enum Constant {
        RATE_PER_KM(12.0),
        RATE_PER_MIN_WAITING(2.0),
        MIN_FARE(25.0),
        BASE(2.0),
        SERVICE_CHARGE(0.01);

        private final double value;

        Constant(double value) {
            this.value = value;
        }
    }

    public Ride(double distance, int waitingTime) {
        this.distance = distance;
        this.waitingTime = waitingTime;
    }

    public Bill calculateFareAndBreakdown() {
        double distanceFare = distance * Constant.RATE_PER_KM.value;
        double waitingTimeFare = waitingTime * Constant.RATE_PER_MIN_WAITING.value;
        double fareWithoutServiceFee = Constant.BASE.value + distanceFare + waitingTimeFare;
        double serviceFee = (fareWithoutServiceFee > 100) ? fareWithoutServiceFee * Constant.SERVICE_CHARGE.value : 0;
        double totalFare = fareWithoutServiceFee + serviceFee;

        double finalFare = Math.max(totalFare, Constant.MIN_FARE.value);

        return new Bill(distanceFare, waitingTimeFare, serviceFee, finalFare);
    }
}

