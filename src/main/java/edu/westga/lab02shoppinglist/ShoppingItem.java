package edu.westga.lab02shoppinglist;

/**
 * Represents an item with a name and quantity.
 *
 * @author Kade Levy
 */
public class ShoppingItem {
  
  private String name;
  private int quantity;

  /**
   * Creates a item with a name.
   *
   * @param name the name of the item
   * @throws IllegalArgumentException if name is null or blank
   */
  public ShoppingItem(String name) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("Item name must not be empty.");
    }
    this.name = name;
    this.quantity = 0;
  }

  /**
   * Gets the name of the item.
   *
   * @return the item name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets the quantity of the item.
   *
   * @return the quantity
   */
  public int getQuantity() {
    return this.quantity;
  }

  /**
   * Sets the quantity of the item.
   *
   * @param quantity the quantity to set
   * @throws IllegalArgumentException to keep quantity from being negative
   */
  public void setQuantity(int quantity) {
    if (quantity <= 0) {
      throw new IllegalArgumentException("Quantity must be positive.");
    }
    this.quantity = quantity;
  }
  
  /**
   * Returns a string representation of the item to post onto the list view.
   *
   * @return the string representation
   */
  @Override
  public String toString() {
    return this.name + " (" + this.quantity + ")";
  }
}
