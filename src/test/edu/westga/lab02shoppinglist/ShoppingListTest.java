package edu.westga.lab02shoppinglist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

class ShoppingListTest {

    @Test
    void testCreateShoppingList() {
        ShoppingList list = new ShoppingList("Groceries");
        assertEquals("Groceries", list.getName());
        assertTrue(list.getItems().isEmpty());
    }

    @Test
    void testAddValidItem() {
        ShoppingList list = new ShoppingList("Groceries");
        list.addItem("Banana");

        List<ShoppingItem> items = list.getItems();
        assertEquals(1, items.size());
        assertEquals("Banana", items.get(0).getName());
        assertEquals(0, items.get(0).getQuantity());
    }

    @Test
    void testAddInvalidItemThrows() {
        ShoppingList list = new ShoppingList("Groceries");
        assertThrows(IllegalArgumentException.class, () -> list.addItem(""));
    }

    @Test
    void testRemoveExistingItem() {
        ShoppingList list = new ShoppingList("Groceries");
        list.addItem("Banana");

        ShoppingItem banana = list.getItems().get(0);
        list.removeItem(banana);

        assertTrue(list.getItems().isEmpty());
    }

    @Test
    void testRemoveWithoutSelectionThrows() {
        ShoppingList list = new ShoppingList("Groceries");
        assertThrows(IllegalArgumentException.class, () -> list.removeItem(null));
    }

    @Test
    void testUpdateQuantitySuccessfully() {
        ShoppingList list = new ShoppingList("Groceries");
        list.addItem("Apple");

        ShoppingItem apple = list.getItems().get(0);
        list.updateItemQuantity(apple, 3);

        assertEquals(3, apple.getQuantity());
    }

    @Test
    void testUpdateQuantityWithInvalidItemThrows() {
        ShoppingList list = new ShoppingList("Groceries");
        assertThrows(IllegalArgumentException.class, () -> list.updateItemQuantity(null, 2));
    }
}
