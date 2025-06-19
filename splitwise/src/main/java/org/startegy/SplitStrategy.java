package org.startegy;

import org.models.Expense;
import org.models.User;

import java.util.List;

public interface SplitStrategy {
    public List<Expense> split (double amount, List<User> users, User paidBy);
}
