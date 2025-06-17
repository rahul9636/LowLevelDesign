package strategy;

import models.CabDetails;
import models.Rider;

import java.util.List;
import java.util.Optional;

public interface BookingStrategy {
    public Optional<CabDetails> getCabDetails(Rider rider , List<CabDetails>cabDetails);
}
