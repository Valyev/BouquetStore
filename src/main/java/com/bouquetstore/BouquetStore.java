package com.bouquetstore;

import com.bouquetstore.Commands.*;
import javafx.application.Application;
import javafx.css.converter.LadderConverter;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class BouquetStore extends Application {
    private List<Command> commands;
    private Bouquet bouquet;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        commands = new ArrayList<>();
        bouquet = new Bouquet();
        //Initializing the database
        LoadFromDatabaseCommand load = new LoadFromDatabaseCommand(bouquet);
        load.execute();

        commands.add(new AddExistingFlowerCommand(bouquet));
        commands.add(new AddFlowerCommand(bouquet));
        commands.add(new RemoveFlowerCommand(bouquet));
        commands.add(new AddExistingWrappingPaperCommand(bouquet));
        commands.add(new AddWrappingPaperCommand(bouquet));
        commands.add(new DeleteWrappingPaperCommand(bouquet));
        commands.add(new AddExistingRibbonCommand(bouquet));
        commands.add(new AddRibbonCommand(bouquet));
        commands.add(new DeleteRibbonCommand(bouquet));
        commands.add(new AddExistingVaseCommand(bouquet));
        commands.add(new AddVaseCommand(bouquet));
        commands.add(new DeleteVaseCommand(bouquet));
        commands.add(new ShowBouquetCommand(bouquet));
        commands.add(new GetPriceCommand(bouquet));
        commands.add(new SortBouquetByFreshnessCommand(bouquet));
        commands.add(new FindFlowerByStemLengthCommand(bouquet));
        commands.add(new SaveBouquetCommand(bouquet));
        commands.add(new LoadBouquetCommand(bouquet));

        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Bouquet.fxml"));
        VBox root = loader.load();
        Controller controller = loader.getController();
        controller.initialize(commands);

        Scene scene = new Scene(root);
        stage.setTitle("Bouquet Store");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        // Cleaning up resources
        super.stop();
    }
}
