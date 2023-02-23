package com.bouquetstore;

import javafx.fxml.FXML;
import com.bouquetstore.Commands.Command;
import javafx.scene.control.Button;

import javafx.scene.control.ListView;

import java.io.IOException;

import java.util.List;


public class Controller {
    public Button executeCommandButton;

    @FXML
    private ListView<String> menuOptionsListView;

    private List<Command> commands;

    @FXML
    protected void initialize(List<Command> commands) {
        this.commands = commands;

        // menu options ListView
        String[] menuOptions = {
                "Add flower",
                "Add custom flower",
                "Remove flower",
                "Add wrapping paper",
                "Add custom wrapping paper",
                "Delete wrapping paper",
                "Add ribbons",
                "Add custom ribbons",
                "Delete ribbons",
                "Add vase",
                "Add custom vase",
                "Delete vase",
                "Show bouquet",
                "Show bouquet price",
                "Sort by freshness in bouquet",
                "Find flower by stem length in bouquet",
                "Save bouquet",
                "Load bouquet"
        };
        menuOptionsListView.getItems().addAll(menuOptions);
    }

    @FXML
    protected void executeCommand() throws IOException {

        int selectedOption = menuOptionsListView.getSelectionModel().getSelectedIndex();
        if (selectedOption >= 0 && selectedOption < commands.size()) {
            commands.get(selectedOption).execute();
        } else {
            System.out.println("Invalid option.");
        }
    }
}

