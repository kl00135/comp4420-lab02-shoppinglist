package edu.westga.lab02shoppinglist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Controller for the Shopping List application.
 * Handles adding, updating, and removing items from the list.
 *
 * @author Kade Levy
 */
public class ShoppingListController {

  @FXML
  private ListView<ShoppingItem> itemListView;

  @FXML
  private TextField itemNameField;

  @FXML
  private TextField itemQuantityField;

  @FXML
  private Button updateButton;

  @FXML
  private Button removeButton;
  
  @FXML
  private Button addButton;

  private ShoppingList shoppingList;

  @FXML
  private void initialize() {
    this.shoppingList = new ShoppingList("My Shopping List");
    this.itemListView.setItems(FXCollections.observableArrayList());
    this.updateButton.setDisable(true);
    this.removeButton.setDisable(true);

    this.itemListView.getSelectionModel().selectedItemProperty().addListener(
          (observable, oldValue, newValue) -> {
            boolean itemSelected = newValue != null;
            this.updateButton.setDisable(!itemSelected);
            this.removeButton.setDisable(!itemSelected);
          }
    );
  }

  @FXML
  private void handleAddItem() {
    String itemName = this.itemNameField.getText().trim();
    if (!itemName.isEmpty()) {
      this.shoppingList.addItem(itemName);
      this.refreshListView();
      this.itemNameField.clear();
    } else {
      this.showAlert("Please enter an item name.");
    }
  }

  @FXML
  private void handleRemoveItem() {
    ShoppingItem selectedItem = this.itemListView.getSelectionModel().getSelectedItem();
    if (selectedItem != null) {
      this.shoppingList.removeItem(selectedItem);
      this.refreshListView();
    } else {
      this.showAlert("Please select an item to remove.");
    }
  }

  @FXML
  private void handleUpdateQuantity() {
    ShoppingItem selectedItem = this.itemListView.getSelectionModel().getSelectedItem();
    if (selectedItem != null) {
      try {
        int quantity = Integer.parseInt(this.itemQuantityField.getText().trim());
        this.shoppingList.updateItemQuantity(selectedItem, quantity);
        this.refreshListView();
        this.itemQuantityField.clear();
      } catch (NumberFormatException e) {
        this.showAlert("Please enter a valid number for quantity.");
      }
    } else {
      this.showAlert("Please select an item to update.");
    }
  }

  private void refreshListView() {
    ObservableList<ShoppingItem> items = 
        FXCollections.observableArrayList(this.shoppingList.getItems());
    this.itemListView.setItems(items);
  }

  private void showAlert(String message) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }
}
