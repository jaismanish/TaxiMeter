package src.java.main;

public class Bill {

    private final double distanceFare;
    private final double waitingTimeFare;
    private final double serviceFee;
    private final double totalFare;

    public Bill(double distanceFare, double waitingTimeFare, double serviceFee, double totalFare) {
        this.distanceFare = distanceFare;
        this.waitingTimeFare = waitingTimeFare;
        this.serviceFee = serviceFee;
        this.totalFare = totalFare;
    }

    public double getDistanceFare() {
        return distanceFare;
    }

    public double getWaitingTimeFare() {
        return waitingTimeFare;
    }

    public double getServiceFee() {
        return serviceFee;
    }

    public double getTotalFare() {
        return totalFare;
    }

}