package org.statemachine;

import org.controler.VendingMachine;
import org.exceptions.AmountEnteredIsLessThenItemPrice;
import org.exceptions.OperationNotAllowedOnCurrentState;
import org.exceptions.itemNotFoundException;
import org.models.CoinType;
import org.models.Item;

public interface State {
    public void pressInsertCoinButton(VendingMachine vendingMachine) throws OperationNotAllowedOnCurrentState;
    public void insertCoin(VendingMachine vendingMachine , CoinType coinType, int quantity) throws OperationNotAllowedOnCurrentState;
    public void pressProductSelectionButton(VendingMachine vendingMachine) throws OperationNotAllowedOnCurrentState;
    public void cancel(VendingMachine vendingMachine) throws OperationNotAllowedOnCurrentState;
    public void selectProduct(VendingMachine vendingMachine, String productId) throws OperationNotAllowedOnCurrentState, AmountEnteredIsLessThenItemPrice, itemNotFoundException;
    public void dispenseProduct(VendingMachine vendingMachine) throws OperationNotAllowedOnCurrentState;
}
