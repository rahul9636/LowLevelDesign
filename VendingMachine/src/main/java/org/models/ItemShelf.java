package org.models;

public class ItemShelf {
    String code;
    Item item;
    boolean isSold = false;

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public ItemShelf(String code, Item item, boolean isSold) {
        this.code = code;
        this.item = item;
        this.isSold = isSold;
    }

    public String getCode() {
        return code;
    }

    public Item getItem() {
        return item;
    }

    public boolean isSold() {
        return isSold;
    }
}
