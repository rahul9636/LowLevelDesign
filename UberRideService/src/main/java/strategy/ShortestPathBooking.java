package strategy;

import models.CabDetails;
import models.Rider;

import java.util.List;
import java.util.Optional;

public class ShortestPathBooking implements BookingStrategy {
    @Override
    public Optional<CabDetails> getCabDetails(Rider rider, List<CabDetails> cabDetails) {
        double minDistance = Double.MAX_VALUE;
        CabDetails cab = null;
        for(CabDetails cabDetail : cabDetails) {
            if(cabDetail.isAvailable()) {
                double distance = rider.getCurrentLocation().getDistance(cabDetail.getCurrentLocation());
                if(distance < minDistance) {
                    cab = cabDetail;
                    minDistance = distance;
                }
            }
        }

        return cab;
    }
}
