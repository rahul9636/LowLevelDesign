package org.controler;

import org.exceptions.AmountEnteredIsLessThenItemPrice;
import org.exceptions.itemNotFoundException;
import org.helper.VendingMachineHelper;
import org.models.Amount;
import org.models.Inventory;
import org.models.Item;
import org.statemachine.IdealState;
import org.statemachine.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VendingMachine {
    State currentState;
    Inventory inventory;
    List<Amount> amountList;
    final VendingMachineHelper vendingMachineHelper;
    Item currentItem;

    public VendingMachine(VendingMachineHelper vendingMachineHelper) {
        this.vendingMachineHelper = vendingMachineHelper;
        this.currentState = new IdealState();
        this.inventory = new Inventory(10);
        this.amountList = new ArrayList<>();
        currentItem = null;
    }

    public void BuildInventory() {
        vendingMachineHelper.buildInventory(inventory);
    }

    public State getCurrentState() {
        return currentState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public List<Amount> getAmountList() {
        return amountList;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setAmountList(List<Amount> amountList) {
        this.amountList = amountList;
    }

    public void refundAmount() {
        amountList.clear();
    }

    public void selectProduct(String productId) throws itemNotFoundException, AmountEnteredIsLessThenItemPrice {
        Optional<Item> itemOptional = vendingMachineHelper.isProductAvailable(productId, inventory);
        if(!itemOptional.isPresent()) {
            throw new itemNotFoundException("item is not available in inventory");
        }

        Item item =  itemOptional.get();
        int amountEntered = vendingMachineHelper.getTotalAmount(amountList);

        if(amountEntered  < item.getPrice()) {
            System.out.println("amount entered is less then item price");
           throw new AmountEnteredIsLessThenItemPrice("please enter sufficient sufficient amount to get the product");

        } else if(amountEntered  > item.getPrice()) {
            refundRemainingAmount(-item.getPrice() + amountEntered);
        }
        currentItem = item;
        System.out.println("Product selected Successfully : ");
    }

    private void refundRemainingAmount(int i) {
        System.out.println("refunding remaining amount : "+i);
    }

    public void updateInventory() {
        vendingMachineHelper.updateInventory(inventory, currentItem);
    }

    public void displayInventory() {
        vendingMachineHelper.displayInventory(inventory);
    }
}
