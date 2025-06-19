package org.statemachine;

import org.controler.VendingMachine;
import org.exceptions.OperationNotAllowedOnCurrentState;
import org.models.CoinType;
import org.models.Item;

public class DispenseState implements State {

    public DispenseState() {
        System.out.println("Dispensing the select product");
    }

    @Override
    public void pressInsertCoinButton(VendingMachine vendingMachine) throws OperationNotAllowedOnCurrentState {

    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, CoinType coinType, int quantity) throws OperationNotAllowedOnCurrentState {

    }

    @Override
    public void pressProductSelectionButton(VendingMachine vendingMachine) throws OperationNotAllowedOnCurrentState {

    }

    @Override
    public void cancel(VendingMachine vendingMachine) throws OperationNotAllowedOnCurrentState {

    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, String productId) throws OperationNotAllowedOnCurrentState {

    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) throws OperationNotAllowedOnCurrentState {

    }
}
