package strategy;

import models.Location;

public interface PriceStrategy {
    public double getPrice(Location startLocation, Location endLocation);
}
