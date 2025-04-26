package edu.westga.lab02shoppinglist;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.api.FxRobot;

public class ShoppingListAddItemTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        new ShoppingListApp().start(stage);
    }

    @Test
    public void testAddItemSuccessfully() {
        FxRobot robot = new FxRobot();

        robot.clickOn("#itemNameField");
        robot.write("Milk");
        robot.clickOn("#addButton");

        assertTrue(robot.lookup("#itemListView")
                         .queryListView()
                         .getItems()
                         .stream()
                         .anyMatch(item -> item.toString().contains("Milk")));
    }

}
