package edu.westga.lab02_shoppinglist;

public class ShoppingItem {
    private String name;
    private int quantity;

    public ShoppingItem(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Item name must not be empty.");
        }
        this.name = name;
        this.quantity = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        this.quantity = quantity;
    }
}
