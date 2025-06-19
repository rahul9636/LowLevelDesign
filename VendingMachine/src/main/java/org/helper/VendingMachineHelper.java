package org.helper;

import org.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VendingMachineHelper {

    public Optional<Item> isProductAvailable(String productId, Inventory inventory) {
        for (ItemShelf itemShelf : inventory.getItemShelves()) {
            if (itemShelf.getCode().equals(productId) && !itemShelf.isSold()) {
                return Optional.of(itemShelf.getItem());
            }
        }

        System.out.println("Item Not Available");
        return Optional.empty();
    }

    public int getTotalAmount(List<Amount> amountList) {
        int totalAmount = 0;
        for (Amount amount : amountList) {
            totalAmount += amount.getQuantity() * amount.getCoinType().getValue();
        }

        return totalAmount;
    }

    public void updateInventory(Inventory inventory, Item item) {
        for(ItemShelf itemShelf : inventory.getItemShelves()) {
            if(itemShelf.getItem().equals(item)) {
                itemShelf.setSold(true);
            }
        }
    }

    public void displayInventory(Inventory inventory) {
        for (ItemShelf itemShelf : inventory.getItemShelves()) {
            System.out.println("item: "+itemShelf.getItem().getType()
            + " with price: "+itemShelf.getItem().getPrice() + " with code: "+itemShelf.getCode() + " is soldOut : "+itemShelf.isSold());
        }
    }

    public void buildInventory(Inventory inventory) {
        int code = 101;
        List<ItemShelf> itemShelves = new ArrayList<>();
        for(int i = 0 ; i < 10; i++) {
            Item item = null;
            if(i < 3) {
                item = new Item(ItemType.COKE, 20);
            } else if(i < 6) {
                item = new Item(ItemType.LAYS , 10);
            } else if(i < 10) {
                item = new Item(ItemType.PEPSI, 15);
            }

            ItemShelf itemShelf = new ItemShelf(Integer.toString(code), item, false);
            code++;
            itemShelves.add(itemShelf);
        }
        inventory.setItemShelves(itemShelves);
    }
}
