package managers;

import exceptions.RiderNotFoundException;
import models.Rider;

import java.util.HashMap;

public class RiderManager {
    private HashMap<String, Rider> riderHashMap = new HashMap<>();

    public Rider getRider(String id) throws RiderNotFoundException {
        if(!riderHashMap.containsKey(id)) {
            throw new RiderNotFoundException();
        }

        return riderHashMap.get(id);
    }

    public void addRider(Rider rider) {
        riderHashMap.put(rider.getId(), rider);
    }
}
