package com.bouquetstore.Commands;

import com.bouquetstore.Bouquet;
import com.bouquetstore.Flowers.Flower;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;


public class RemoveFlowerCommand implements Command {
    private final Bouquet bouquet;

    public RemoveFlowerCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        Dialog<Flower> dialog = new Dialog<>();
        dialog.setTitle("Remove flower");
        dialog.setHeaderText("Select the flower to remove:");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        for (Flower flower : bouquet.getFlowers()) {
            choiceBox.getItems().add(flower.getName());
        }

        dialog.getDialogPane().setContent(choiceBox);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == ButtonType.OK) {
                String selectedName = choiceBox.getValue();
                bouquet.deleteFlower(selectedName);
            }
            return null;
        });

        dialog.showAndWait();
    }
}
