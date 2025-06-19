package org.models;

public class Expense {
    User userA;
    User userB;
    double amount;

    public Expense(User userA, User userB, double amount) {
        this.userA = userA;
        this.userB = userB;
        this.amount = amount;
    }
}
