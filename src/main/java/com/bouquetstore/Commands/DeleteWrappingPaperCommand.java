package com.bouquetstore.Commands;

import com.bouquetstore.Accessories.WrappingPaper;
import com.bouquetstore.Bouquet;

import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;



public class DeleteWrappingPaperCommand implements Command {
    private final Bouquet bouquet;

    public DeleteWrappingPaperCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        Dialog<WrappingPaper> dialog = new Dialog<>();
        dialog.setTitle("Remove wrapping paper");
        dialog.setHeaderText("Select the wrapping paper to remove:");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        for (WrappingPaper paper : bouquet.getWrappingPapers()) {
            choiceBox.getItems().add(paper.getName());
        }

        dialog.getDialogPane().setContent(choiceBox);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == ButtonType.OK) {
                String selectedName = choiceBox.getValue();
                bouquet.deleteWrappingPaper(selectedName);
            }
            return null;
        });

        dialog.showAndWait();
    }
}
