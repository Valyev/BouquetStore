package com.bouquetstore.Commands;

import com.bouquetstore.Accessories.Vase;
import com.bouquetstore.Accessories.WrappingPaper;
import com.bouquetstore.Bouquet;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;


public class AddWrappingPaperCommand implements Command {
    private final Bouquet bouquet;

    public AddWrappingPaperCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        Dialog<Vase> dialog = new Dialog<>();
        dialog.setTitle("Add wrapping paper");
        dialog.setHeaderText("Enter wrapping paper information");

        // Set up the buttons
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        TextInputDialog nameInput = new TextInputDialog();
        nameInput.setTitle("Add wrapping paper");
        nameInput.setHeaderText("Enter wrapping paper name:");
        Optional<String> nameResult = nameInput.showAndWait();

        if (nameResult.isPresent()) {
            String name = nameResult.get();

            TextInputDialog priceInput = new TextInputDialog();
            priceInput.setTitle("Add wrapping paper");
            priceInput.setHeaderText("Enter wrapping paper price:");
            Optional<String> priceResult = priceInput.showAndWait();
            if (priceResult.isPresent()) {
                double price = Double.parseDouble(priceResult.get());
                bouquet.addWrappingPaper(new WrappingPaper(price, name));
            }
        }
    }
}
