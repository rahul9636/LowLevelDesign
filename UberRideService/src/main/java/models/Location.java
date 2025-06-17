package models;

public class Location {
    private final double latitude;
    private final double longitude;

    public Location(double _latitude, double _longitude) {
        this.latitude = _latitude;
        this.longitude = _longitude;
    }

    public double getDistance(Location location) {
        return Math.sqrt(Math.pow(this.latitude - location.latitude, 2) + Math.pow(this.longitude - location.longitude, 2));
    }
}
