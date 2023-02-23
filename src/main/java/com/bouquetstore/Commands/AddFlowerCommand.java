package com.bouquetstore.Commands;

import com.bouquetstore.Bouquet;
import com.bouquetstore.Flowers.Flower;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class AddFlowerCommand implements Command {
    private final Bouquet bouquet;

    public AddFlowerCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        Dialog<Flower> dialog = new Dialog<>();
        dialog.setTitle("Add flower");
        dialog.setHeaderText("Enter flower information");

        // Set up the buttons
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        // Set up the input fields
        TextInputDialog nameInput = new TextInputDialog();
        nameInput.setTitle("Add flower");
        nameInput.setHeaderText("Enter flower name:");
        Optional<String> nameResult = nameInput.showAndWait();

        if (nameResult.isPresent()) {
            String name = nameResult.get();

            TextInputDialog priceInput = new TextInputDialog();
            priceInput.setTitle("Add flower");
            priceInput.setHeaderText("Enter flower price:");
            Optional<String> priceResult = priceInput.showAndWait();

            if (priceResult.isPresent()) {
                double price = Double.parseDouble(priceResult.get());

                TextInputDialog freshnessInput = new TextInputDialog();
                freshnessInput.setTitle("Add flower");
                freshnessInput.setHeaderText("Enter flower freshness level (1-100):");
                Optional<String> freshnessResult = freshnessInput.showAndWait();

                if (freshnessResult.isPresent()) {
                    double freshness = Double.parseDouble(freshnessResult.get());

                    TextInputDialog stemLengthInput = new TextInputDialog();
                    stemLengthInput.setTitle("Add flower");
                    stemLengthInput.setHeaderText("Enter flower stem length:");
                    Optional<String> stemLengthResult = stemLengthInput.showAndWait();

                    if (stemLengthResult.isPresent()) {
                        double stemLength = Double.parseDouble(stemLengthResult.get());

                        bouquet.addFlower(new Flower(name, price, freshness, stemLength));
                    }
                }
            }
        }
    }
}
