package org.manager;

import org.models.Expense;
import org.models.User;
import org.startegy.SplitStrategy;

import java.util.HashMap;
import java.util.List;

public class DebtManager {
    HashMap<User , List<Expense>> userDebtMap = new HashMap<>();
    UserManager userManager;
    SplitStrategy splitStrategy;

    public DebtManager(UserManager userManager, SplitStrategy splitStrategy) {
        this.userManager = userManager;
        this.splitStrategy = splitStrategy;
    }


}
