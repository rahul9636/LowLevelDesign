package managers;

import exceptions.CabNotFoundException;
import models.CabDetails;
import models.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CabManager {
    HashMap<String, CabDetails> cabs = new HashMap<>();

    public void addCab(CabDetails cab) {
        cabs.put(cab.getDriverId(), cab);
    }

    public CabDetails getCab(String driverId) throws CabNotFoundException {
        if (!cabs.containsKey(driverId)) {
            throw new CabNotFoundException();
        }

        return cabs.get(driverId);
    }

    public List<CabDetails> getCabs(double maxDistance, Location location) {
        List<CabDetails> availableCabs = new ArrayList<>();
        for (CabDetails cab : cabs.values()) {
            if(cab.isAvailable() && cab.getCurrentLocation().getDistance(location) < maxDistance) {
                availableCabs.add(cab);
            }
        }

        return availableCabs;
    }
}
