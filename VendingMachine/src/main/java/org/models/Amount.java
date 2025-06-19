package org.models;

public class Amount {
    final CoinType coinType;
    final int quantity;

    public Amount(CoinType coinType, int quantity) {
        this.coinType = coinType;
        this.quantity = quantity;
    }

    public CoinType getCoinType() {
        return coinType;
    }

    public int getQuantity() {
        return quantity;
    }
}
