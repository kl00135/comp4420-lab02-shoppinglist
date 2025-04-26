package edu.westga.lab02shoppinglist;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a shopping list containing items and quantities of said items.
 *
 * @author KadeLevy
 */
public class ShoppingList {

  private String name;
  private List<ShoppingItem> items;

  /**
  * Creates a new ShoppingList.
  *
  * @param name the name of the shopping list
  * @throws IllegalArgumentException if name is null or blank
  */
  public ShoppingList(String name) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("Shopping list name must not be empty.");
    }
    this.name = name;
    this.items = new ArrayList<>();
  }

  /**
  * Adds a new item to the shopping list.
  *
  * @param itemName the name of the item to add
  */
  public void addItem(String itemName) {
    ShoppingItem newItem = new ShoppingItem(itemName);
    this.items.add(newItem);
  }

  /**
  * Removes an item from the shopping list.
  *
  * @param item the item to remove
  * @throws IllegalArgumentException if the item is null
  */
  public void removeItem(ShoppingItem item) {
    if (item == null) {
      throw new IllegalArgumentException("Must select an item to remove.");
    }
    this.items.remove(item);
  }

  /**
  * Updates the quantity of an item in the shopping list.
  *
  * @param item     the item to update
  * @param quantity the new quantity
  * @throws IllegalArgumentException if the item is null
  */
  public void updateItemQuantity(ShoppingItem item, int quantity) {
    if (item == null) {
      throw new IllegalArgumentException("Must select an item to update.");
    }
    item.setQuantity(quantity);
  }

  /**
  * Gets a copy of the list of shopping items.
  *
  * @return the list of shopping items
  */
  public List<ShoppingItem> getItems() {
    return new ArrayList<>(this.items);
  }

  /**
  * Gets the name of the shopping list.
  *
  * @return the name of the shopping list
  */
  public String getName() {
    return this.name;
  }
}
