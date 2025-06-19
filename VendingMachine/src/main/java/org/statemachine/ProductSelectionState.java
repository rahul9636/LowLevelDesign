package org.statemachine;

import org.controler.VendingMachine;
import org.exceptions.AmountEnteredIsLessThenItemPrice;
import org.exceptions.OperationNotAllowedOnCurrentState;
import org.exceptions.itemNotFoundException;
import org.models.Amount;
import org.models.CoinType;
import org.models.Item;

import java.util.List;

public class ProductSelectionState implements State {
    @Override
    public void pressInsertCoinButton(VendingMachine vendingMachine) throws OperationNotAllowedOnCurrentState {
        //not possible
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, CoinType coinType, int quantity) throws OperationNotAllowedOnCurrentState {
        //not possible
    }

    @Override
    public void pressProductSelectionButton(VendingMachine vendingMachine) throws OperationNotAllowedOnCurrentState {
        //not possible
    }

    @Override
    public void cancel(VendingMachine vendingMachine) throws OperationNotAllowedOnCurrentState {
        vendingMachine.refundAmount();
        System.out.println("You have been refunded.");

        System.out.println("Moving back to ideal state...");
        vendingMachine.setCurrentState(new IdealState());
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, String productId) throws OperationNotAllowedOnCurrentState, AmountEnteredIsLessThenItemPrice, itemNotFoundException {
        vendingMachine.selectProduct(productId);
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) throws OperationNotAllowedOnCurrentState {
        vendingMachine.setCurrentState(new DispenseState());
        vendingMachine.updateInventory();
    }
}
