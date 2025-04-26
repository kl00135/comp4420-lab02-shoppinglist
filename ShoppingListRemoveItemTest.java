package edu.westga.lab02shoppinglist;

import static org.junit.jupiter.api.Assertions.assertFalse;

import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.api.FxRobot;

public class ShoppingListRemoveItemTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        new ShoppingListApp().start(stage);
    }

    @Test
    public void testRemoveItemSuccessfully() {
        FxRobot robot = new FxRobot();

        robot.clickOn("#itemNameField");
        robot.write("Juice");
        robot.clickOn("#addButton");
        
        robot.interact(() -> {
            robot.lookup("#itemListView")
                 .queryListView()
                 .getSelectionModel()
                 .select(0);
        });
        
        robot.clickOn("#removeButton");

        assertFalse(robot.lookup("#itemListView")
                         .queryListView()
                         .getItems()
                         .stream()
                         .anyMatch(item -> item.toString().contains("Juice")));
    }

}
