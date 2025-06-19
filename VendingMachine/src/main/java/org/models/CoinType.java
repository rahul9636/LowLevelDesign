package org.models;

public enum CoinType {
    SMALL(5),
    MEDIUM(10),
    LARGE(15);

    final int amount;

    CoinType(int amount) {
        this.amount = amount;
    }

    public int getValue() {
        return amount;
    }
}
