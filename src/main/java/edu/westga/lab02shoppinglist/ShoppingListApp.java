package edu.westga.lab02shoppinglist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Starts the application.
 *
 * @author Kade Levy
 */
public class ShoppingListApp extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("ShoppingListView.fxml"));
    Scene scene = new Scene(root, 400, 500);
    primaryStage.setTitle("Kade Levy");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
