package org.models;

public class Item {
    ItemType type;
    int price;

    public Item(ItemType type, int price) {
        this.type = type;
        this.price = price;
    }

    public ItemType getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }
}
