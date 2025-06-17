package models;

public class CabDetails {

    String cabName;
    String driverId;

    Location currentLocation;
    boolean isAvailable;

    public CabDetails(String cabName, String driverId, Location currentLocation) {
        this.cabName = cabName;
        this.driverId = driverId;
        this.currentLocation = currentLocation;
        this.isAvailable = true;
    }

    public String getCabName() {
        return cabName;
    }

    public String getDriverId() {
        return driverId;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
