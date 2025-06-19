package org.models;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<ItemShelf> itemShelves;
    public Inventory(int itemCount) {
        itemShelves = new ArrayList<>(itemCount);
    }

    public List<ItemShelf> getItemShelves() {
        return itemShelves;
    }

    public void setItemShelves(List<ItemShelf> itemShelves) {
        this.itemShelves = itemShelves;
    }
}
