package org.startegy;

import org.models.Expense;
import org.models.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EqualSplit implements SplitStrategy {
    @Override
    public List<Expense> split(double amount , List<User> users, User paidBy) {

        int size = users.size();
        List<Expense> expenses = new ArrayList<Expense>();
        double splitValue = amount / size;
        for(User user : users) {
            if(user.equals(paidBy)) {
                continue;
            }

            Expense expense = new Expense(paidBy, user, splitValue);
            expenses.add(expense);
        }

        return expenses;
    }
}
