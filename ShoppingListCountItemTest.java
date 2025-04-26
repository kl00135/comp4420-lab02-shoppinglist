package edu.westga.lab02shoppinglist;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.api.FxRobot;

public class ShoppingListCountItemTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        new ShoppingListApp().start(stage);
    }

    @Test
    public void testUpdateAmountSuccessfully() {
        FxRobot robot = new FxRobot();

        robot.clickOn("#itemNameField");
        robot.write("Eggs");
        robot.clickOn("#addButton");
        
        robot.interact(() -> {
            robot.lookup("#itemListView")
                 .queryListView()
                 .getSelectionModel()
                 .select(0);
        });
        
        robot.clickOn("#itemQuantityField");
        robot.write("34");
        robot.clickOn("#updateButton");

        assertTrue(robot.lookup("#itemListView")
                         .queryListView()
                         .getItems()
                         .stream()
                         .anyMatch(item -> item.toString().contains("Eggs") && item.toString().contains("34")));
    }

}
