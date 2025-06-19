package org;

import org.controler.VendingMachine;
import org.exceptions.AmountEnteredIsLessThenItemPrice;
import org.exceptions.OperationNotAllowedOnCurrentState;
import org.exceptions.itemNotFoundException;
import org.helper.VendingMachineHelper;
import org.models.CoinType;

public class VendingMachineController {
    public static void main(String[] args) throws OperationNotAllowedOnCurrentState, AmountEnteredIsLessThenItemPrice, itemNotFoundException {
        VendingMachine machine = new VendingMachine(new VendingMachineHelper());

        machine.BuildInventory();
        machine.displayInventory();

        System.out.println("Currently in idela state");

        System.out.println("pressing insert money button");

        machine.getCurrentState().pressInsertCoinButton(machine);

        machine.getCurrentState().insertCoin(machine, CoinType.MEDIUM, 2);
        System.out.println("Pressing product selection button");

        machine.getCurrentState().pressProductSelectionButton(machine);
        System.out.println("selecting product");
        machine.getCurrentState().selectProduct(machine, "110");


        machine.getCurrentState().dispenseProduct(machine);

    }
}
