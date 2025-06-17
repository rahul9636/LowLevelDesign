package managers;

import exceptions.CabNotAvaiableException;
import models.CabDetails;
import models.Location;
import models.Rider;
import models.Rides;
import strategy.BookingStrategy;
import strategy.PriceStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class TripManager {
    private static final double MAX_ALLOWED_RADIUS = 10.0;
    HashMap<String, List<Rides>> trips = new HashMap<>();

    final CabManager cabManager;
    final RiderManager riderManager;
    final PriceStrategy priceStrategy;
    final BookingStrategy bookingStrategy;

    public TripManager(CabManager cabManager, RiderManager riderManager, PriceStrategy priceStrategy, BookingStrategy bookingStrategy) {
        this.cabManager = cabManager;
        this.riderManager = riderManager;
        this.priceStrategy = priceStrategy;
        this.bookingStrategy = bookingStrategy;
    }

    void StartTrip(Rider rider, Location endLocation) throws CabNotAvaiableException {

        List<CabDetails> availableCabs = cabManager.getCabs(MAX_ALLOWED_RADIUS , rider.getCurrentLocation());
        Optional<CabDetails> cabDetails = bookingStrategy.getCabDetails(rider, availableCabs);

        if(!cabDetails.isPresent()) {
            throw new CabNotAvaiableException();
        }

        double price = priceStrategy.getPrice(rider.getCurrentLocation(), endLocation);

        Rides rides =  new Rides(rider, rider.getCurrentLocation() , endLocation , price , cabDetails.get());

        addRide(rides, rider);
    }

    private void addRide(Rides rides, Rider rider) {
        List<Rides> ridesList = trips.getOrDefault(rider.getId(), new ArrayList<>());
        ridesList.add(rides);
    }

    public List<Rides> getRides(Rider rider) {
        return trips.getOrDefault(rider.getId(), new ArrayList<>());
    }
}
