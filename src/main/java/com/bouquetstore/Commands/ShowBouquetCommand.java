package com.bouquetstore.Commands;

import com.bouquetstore.Bouquet;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.VBox;

public class ShowBouquetCommand implements Command {
    private final Bouquet bouquet;

    public ShowBouquetCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bouquet details");
        alert.setHeaderText(null);

        Label label = new Label(bouquet.toString());
        label.setWrapText(false);
        label.setPrefWidth(500);

        //Copy button
        ButtonType copyButton = new ButtonType("Copy", ButtonBar.ButtonData.OK_DONE);
        alert.getButtonTypes().add(copyButton);

        // Set the content to a VBox to contain the result and the copy button
        VBox vbox = new VBox(label);
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER_LEFT);
        alert.getDialogPane().setContent(vbox);

        // Copy the text to the clipboard when clicked
        Node copyNode = alert.getDialogPane().lookupButton(copyButton);
        if (copyNode instanceof Button) {
            Button copyButtonNode = (Button) copyNode;
            copyButtonNode.setOnAction(event -> {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(bouquet.toString());
                clipboard.setContent(content);
                alert.close();
            });
        }

        alert.showAndWait();
    }
}



