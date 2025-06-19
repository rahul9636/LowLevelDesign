package org.statemachine;

import org.controler.VendingMachine;
import org.exceptions.OperationNotAllowedOnCurrentState;
import org.models.CoinType;
import org.models.Item;

public class IdealState implements State {
    @Override
    public void pressInsertCoinButton(VendingMachine vendingMachine) {
        vendingMachine.setCurrentState(new InsertCointState());
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine ,CoinType coinType, int quantity) throws OperationNotAllowedOnCurrentState {
        System.out.println("Please press insert coin button");
        throw new OperationNotAllowedOnCurrentState();
    }

    @Override
    public void pressProductSelectionButton(VendingMachine vendingMachine) throws OperationNotAllowedOnCurrentState {
        System.out.println("Please press insert coin button");
        throw new OperationNotAllowedOnCurrentState();
    }

    @Override
    public void cancel(VendingMachine vendingMachine) throws OperationNotAllowedOnCurrentState {
        System.out.println("Already on IdealState \n press insert coin button to start transaction");
        throw new OperationNotAllowedOnCurrentState();
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, String productId) throws OperationNotAllowedOnCurrentState {
        System.out.println("Insert money for selecting product " + productId);
        throw new OperationNotAllowedOnCurrentState();
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) throws OperationNotAllowedOnCurrentState {
        System.out.println("Insert money and select product to get it dispensed");
        throw new OperationNotAllowedOnCurrentState();
    }
}
