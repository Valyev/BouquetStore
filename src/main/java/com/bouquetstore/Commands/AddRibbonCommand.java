package com.bouquetstore.Commands;

import com.bouquetstore.Accessories.Ribbon;
import com.bouquetstore.Bouquet;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;


public class AddRibbonCommand implements Command {
    private final Bouquet bouquet;

    public AddRibbonCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        Dialog<Ribbon> dialog = new Dialog<>();
        dialog.setTitle("Add ribbon");
        dialog.setHeaderText("Enter ribbon information");

        // Set up the buttons
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        TextInputDialog nameInput = new TextInputDialog();
        nameInput.setTitle("Add ribbon");
        nameInput.setHeaderText("Enter ribbon name:");
        Optional<String> nameResult = nameInput.showAndWait();

        if (nameResult.isPresent()) {
            String name = nameResult.get();

            TextInputDialog priceInput = new TextInputDialog();
            priceInput.setTitle("Add ribbon");
            priceInput.setHeaderText("Enter ribbon price:");
            Optional<String> priceResult = priceInput.showAndWait();
            if (priceResult.isPresent()) {
                double price = Double.parseDouble(priceResult.get());
                bouquet.addRibbon(new Ribbon(price, name));
            }
        }
    }
}
