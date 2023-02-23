package com.bouquetstore.Commands;


import com.bouquetstore.Accessories.Vase;
import com.bouquetstore.Bouquet;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;


public class AddVaseCommand implements Command {
    private final Bouquet bouquet;

    public AddVaseCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        Dialog<Vase> dialog = new Dialog<>();
        dialog.setTitle("Add vase");
        dialog.setHeaderText("Enter vase information");

        // Set up the buttons
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        TextInputDialog nameInput = new TextInputDialog();
        nameInput.setTitle("Add vase");
        nameInput.setHeaderText("Enter vase name:");
        Optional<String> nameResult = nameInput.showAndWait();

        if (nameResult.isPresent()) {
            String name = nameResult.get();

            TextInputDialog priceInput = new TextInputDialog();
            priceInput.setTitle("Add vase");
            priceInput.setHeaderText("Enter vase price:");
            Optional<String> priceResult = priceInput.showAndWait();
            if (priceResult.isPresent()) {
                double price = Double.parseDouble(priceResult.get());
                bouquet.addVase(new Vase(price, name));
            }
        }
    }
}
