package org.statemachine;

import org.controler.VendingMachine;
import org.exceptions.OperationNotAllowedOnCurrentState;
import org.models.Amount;
import org.models.CoinType;
import org.models.Item;

import java.util.List;

public class InsertCointState implements State {

    public InsertCointState() {
    }

    @Override
    public void pressInsertCoinButton(VendingMachine vendingMachine) throws OperationNotAllowedOnCurrentState {
        System.out.println("Please insert coins....\n");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, CoinType coinType, int quantity) throws OperationNotAllowedOnCurrentState {
        System.out.println("Coins Accepted....\n");
        vendingMachine.getAmountList().add(new Amount(coinType, quantity));
    }

    @Override
    public void pressProductSelectionButton(VendingMachine vendingMachine) throws OperationNotAllowedOnCurrentState {
        if(!vendingMachine.getAmountList().isEmpty()) {
            vendingMachine.setCurrentState(new ProductSelectionState());
        } else {
            System.out.println("Please insert a Money first...\n");
        }
    }

    @Override
    public void cancel(VendingMachine vendingMachine) throws OperationNotAllowedOnCurrentState {
        List<Amount> amountList  = vendingMachine.getAmountList();
        if(!amountList.isEmpty()) {
            vendingMachine.refundAmount();
            System.out.println("You have been refunded.");
        }

        System.out.println("Moving back to ideal state...\n");
        vendingMachine.setCurrentState(new IdealState());
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, String productId) throws OperationNotAllowedOnCurrentState {
    //
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) throws OperationNotAllowedOnCurrentState {
        //
    }
}
