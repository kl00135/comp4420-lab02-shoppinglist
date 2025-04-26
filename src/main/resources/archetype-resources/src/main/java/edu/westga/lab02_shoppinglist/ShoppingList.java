package edu.westga.lab02_shoppinglist;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
    private String name;
    private List<ShoppingItem> items;

    public ShoppingList(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Shopping list name must not be empty.");
        }
        this.name = name;
        this.items = new ArrayList<>();
    }

    
    public void addItem(String itemName) {
        ShoppingItem newItem = new ShoppingItem(itemName);
        this.items.add(newItem);
    }

    public void removeItem(ShoppingItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Must select an item to remove.");
        }
        this.items.remove(item);
    }

    
    public void updateItemQuantity(ShoppingItem item, int quantity) {
        if (item == null) {
            throw new IllegalArgumentException("Must select an item to update.");
        }
        item.setQuantity(quantity);
        
    }

    public List<ShoppingItem> getItems() {
        return new ArrayList<>(this.items);
    }

    public String getName() {
        return this.name;
    }
}
