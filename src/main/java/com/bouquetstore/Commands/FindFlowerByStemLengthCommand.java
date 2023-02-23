package com.bouquetstore.Commands;

import com.bouquetstore.Bouquet;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;


public class FindFlowerByStemLengthCommand implements Command {
    private final Bouquet bouquet;

    public FindFlowerByStemLengthCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        TextInputDialog LengthInput = new TextInputDialog();
        LengthInput.setTitle("Find flowers by stem length in bouquet");
        LengthInput.setHeaderText(null);
        LengthInput.setContentText("Enter the minimum stem length:");

        Optional<String> minLengthResult = LengthInput.showAndWait();
        if (minLengthResult.isPresent()) {
            double minLength = Double.parseDouble(minLengthResult.get());

            LengthInput.setHeaderText(null);
            LengthInput.setContentText("Enter the maximum stem length:");

            Optional<String> maxLengthResult = LengthInput.showAndWait();
            if (maxLengthResult.isPresent()) {
                double maxLength = Double.parseDouble(maxLengthResult.get());

                bouquet.findByStemLength(minLength, maxLength);

            }
        }
    }
}
