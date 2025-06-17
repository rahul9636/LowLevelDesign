package strategy;

import models.Location;

public class BasicPriceStrategy implements PriceStrategy {
    @Override
    public double getPrice(Location startLocation, Location endLocation) {
        //calculate price
        return 0.0;
    }
}
