package edu.westga.lab02_shoppinglist;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.*;

public class ShoppingListController {

    @FXML
    private ListView<ShoppingItem> itemListView;

    @FXML
    private TextField itemNameField;

    @FXML
    private TextField itemQuantityField;

    private ShoppingList shoppingList;

    @FXML
    private void initialize() {
        this.shoppingList = new ShoppingList("My Shopping List");
        this.itemListView.setItems(FXCollections.observableArrayList());
    }

    @FXML
    private void handleAddItem() {
        String itemName = this.itemNameField.getText().trim();
        if (!itemName.isEmpty()) {
            this.shoppingList.addItem(itemName);
            this.refreshListView();
            this.itemNameField.clear();
        } else {
            showAlert("Please enter an item name.");
        }
    }

    @FXML
    private void handleRemoveItem() {
        ShoppingItem selectedItem = this.itemListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            this.shoppingList.removeItem(selectedItem);
            this.refreshListView();
        } else {
            showAlert("Please select an item to remove.");
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
                showAlert("Please enter a valid number for quantity.");
            }
        } else {
            showAlert("Please select an item to update.");
        }
    }

    private void refreshListView() {
        ObservableList<ShoppingItem> items = FXCollections.observableArrayList(this.shoppingList.getItems());
        this.itemListView.setItems(items);
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
