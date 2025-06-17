package models;

enum TripStatus {
    IN_PROGRESS,
    FINISHED,
}
public class Rides {
    final Rider rider;
    TripStatus tripStatus;
    final Location startLocation;
    Location endLocation;
    final double price;
    final CabDetails cabDetails;

    public Rides(Rider rider, Location startLocation, Location endLocation, double price, CabDetails cabDetails) {
        this.rider = rider;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.price = price;
        this.cabDetails = cabDetails;
        this.tripStatus = TripStatus.IN_PROGRESS;
    }


    public void endTrip() {
        this.tripStatus = TripStatus.FINISHED;
        rider.addRide(this);
    }

    public void endEarlyTrip(Location location) {
        this.tripStatus = TripStatus.FINISHED;
        this.endLocation = location;
        rider.addRide(this);
    }
}
