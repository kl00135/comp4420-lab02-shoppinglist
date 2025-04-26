package edu.westga.lab02shoppinglist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ShoppingItemTest {

    @Test
    void testCreateValidItem() {
        ShoppingItem item = new ShoppingItem("Banana");
        assertEquals("Banana", item.getName());
        assertEquals(0, item.getQuantity());
    }

    @Test
    void testCreateInvalidItemThrows() {
        assertThrows(IllegalArgumentException.class, () -> new ShoppingItem(""));
    }

    @Test
    void testSetPositiveQuantity() {
        ShoppingItem item = new ShoppingItem("Apple");
        item.setQuantity(5);
        assertEquals(5, item.getQuantity());
    }

    @Test
    void testSetInvalidQuantityThrows() {
        ShoppingItem item = new ShoppingItem("Milk");
        assertThrows(IllegalArgumentException.class, () -> item.setQuantity(0));
    }
}
