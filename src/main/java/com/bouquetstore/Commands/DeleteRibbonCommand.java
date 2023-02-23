package com.bouquetstore.Commands;

import com.bouquetstore.Accessories.Ribbon;

import com.bouquetstore.Bouquet;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;



public class DeleteRibbonCommand implements Command{
    private final Bouquet bouquet;

    public DeleteRibbonCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        Dialog<Ribbon> dialog = new Dialog<>();
        dialog.setTitle("Remove ribbon");
        dialog.setHeaderText("Select the ribbon to remove:");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        for (Ribbon ribbon : bouquet.getRibbons()) {
            choiceBox.getItems().add(ribbon.getName());
        }

        dialog.getDialogPane().setContent(choiceBox);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == ButtonType.OK) {
                String selectedName = choiceBox.getValue();
                bouquet.deleteRibbon(selectedName);
            }
            return null;
        });

        dialog.showAndWait();
    }
}
