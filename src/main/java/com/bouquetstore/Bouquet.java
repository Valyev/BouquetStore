package com.bouquetstore;

import com.bouquetstore.Accessories.Ribbon;
import com.bouquetstore.Accessories.Vase;
import com.bouquetstore.Accessories.WrappingPaper;
import com.bouquetstore.Flowers.Flower;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;

import java.sql.*;
import java.util.*;

public class Bouquet {
    private final List<Flower> flowers;
    private Vase vase;
    private final List<WrappingPaper> wrappingPapers;
    private final List<Ribbon> ribbons;
    private final List<Flower> availableFlowers;
    private final List<Vase> availableVases;
    private final List<Ribbon> availableRibbons;
    private final List<WrappingPaper> availableWrappingPaper;
    private double price;

    public Bouquet() {
        flowers = new ArrayList<>();
        ribbons = new ArrayList<>();
        wrappingPapers = new ArrayList<>();
        availableFlowers = new ArrayList<>();
        availableVases = new ArrayList<>();
        availableRibbons = new ArrayList<>();
        availableWrappingPaper = new ArrayList<>();

    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
        price += flower.getPrice();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Add flower");
        alert.setHeaderText(null);
        alert.setContentText("Flower added successfully.");
        alert.showAndWait();
    }

    public void addVase(Vase vase) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Add vase");
        alert.setHeaderText(null);

        if (this.vase == null) {
            this.vase = vase;
            price += vase.getPrice();

            alert.setContentText("Vase added successfully.");
            alert.showAndWait();
        } else {
            alert.setContentText("A bouquet can only have one vase.");
            alert.showAndWait();
        }
    }


    public void addWrappingPaper(WrappingPaper wrappingPaper) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Add wrapping paper");
        alert.setHeaderText(null);


        wrappingPapers.add(wrappingPaper);
        price += wrappingPaper.getPrice();
        alert.setContentText("Wrapping paper added successfully.");
        alert.showAndWait();

    }

    public void addRibbon(Ribbon ribbon) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Add ribbon");
        alert.setHeaderText(null);

        ribbons.add(ribbon);
        price += ribbon.getPrice();
        alert.setContentText("Ribbon added successfully.");
        alert.showAndWait();


    }

    public void sortByFreshness() {
        flowers.sort((f1, f2) -> (int) (f2.getFreshness() - f1.getFreshness()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sort flowers");
        alert.setHeaderText(null);
        alert.setContentText("Sorted Flowers in the Bouquet:");

        StringBuilder sb = new StringBuilder();
        for (Flower flower : flowers) {
            sb.append(flower.toString()).append("\n");
        }

        alert.getDialogPane().setContentText(sb.toString());
        alert.showAndWait();
    }


    public void findByStemLength(double minLength, double maxLength) {
        List<Flower> foundFlowers = new ArrayList<Flower>();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Find flowers by stem length in bouquet");
        alert.setHeaderText(null);
        for (Flower flower : flowers) {
            if (flower.getStem_length() >= minLength && flower.getStem_length() <= maxLength) {
                foundFlowers.add(flower);
            }
        }
        if (foundFlowers.isEmpty()) {
            alert.setContentText("No flowers found with stem length between " + minLength + " and " + maxLength + ".");
            alert.showAndWait();
            ;
        } else {
            alert.setContentText("Found flowers:");

            StringBuilder sb = new StringBuilder();
            for (Flower flower : foundFlowers) {
                sb.append(flower.toString()).append("\n");
            }
            alert.getDialogPane().setContentText(sb.toString());
            alert.showAndWait();
        }
    }


    public void deleteFlower(String name) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Remove flower");
        alert.setHeaderText(null);
        boolean is_deleted = false;
        for (Flower flower : flowers) {
            if (Objects.equals(flower.getName(), name)) {
                this.price = this.price - flower.getPrice();
                flowers.remove(flower);
                is_deleted = true;
                alert.setContentText("Flower " + flower.getName() + " removed successfully.");
                alert.showAndWait();
                break;
            }
        }
        if (!is_deleted) {
            alert.setContentText("Flower not found.");
            alert.showAndWait();
        }
    }

    public void deleteVase() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Removing vase");
        if (this.vase != null) {
            this.price = this.price - vase.getPrice();
            this.vase = null;
            alert.setContentText("Vase removed successfully.");
            alert.showAndWait();
        } else {
            alert.setContentText("The bouquet doesn't have a vase.");
            alert.showAndWait();
        }
    }

    public void deleteRibbon(String name) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Removing ribbon");
        boolean is_deleted = false;
        for (Ribbon ribbon : ribbons) {
            if (Objects.equals(ribbon.getName(), name)) {
                this.price = this.price - ribbon.getPrice();
                ribbons.remove(ribbon);
                is_deleted = true;
                alert.setContentText(ribbon.getName() + " ribbon deleted successfully.");
                alert.showAndWait();
                break;
            }
        }
        if (!is_deleted) {
            alert.setContentText("Ribbon not found.");
            alert.showAndWait();
        }
    }

    public void deleteWrappingPaper(String name) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Removing wrapping paper");
        boolean is_deleted = false;
        for (WrappingPaper wrap : wrappingPapers) {
            if (Objects.equals(wrap.getName(), name)) {
                this.price = this.price - wrap.getPrice();
                wrappingPapers.remove(wrap);
                is_deleted = true;
                alert.setContentText(wrap.getName() + " wrapping paper deleted successfully.");
                alert.showAndWait();
                break;
            }
        }
        if (!is_deleted) {
            System.out.println("Typed wrapper not found");
        }
    }

    public void showPrice() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Price of bouquet");
        alert.setContentText("The bouquet price is: " + price);
        alert.showAndWait();
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public double getPrice() {
        return price;
    }

    public Vase getVase() {
        return vase;
    }

    public List<Ribbon> getRibbons() {
        return ribbons;
    }

    public List<WrappingPaper> getWrappingPapers() {
        return wrappingPapers;
    }

    public void ReadFromDatabase() {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/Bouquet";
        String user = "root";
        String password = "My32sql";


        try (Connection con = DriverManager.getConnection(url, user, password)) {
            // Read Flowers and put availableFlowers list
            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM Flowers");
                while (rs.next()) {
                    String name = rs.getString("Name");
                    float price = rs.getFloat("Price");
                    float freshness = rs.getFloat("Freshness");
                    float stemLength = rs.getFloat("Stem_length");
                    Flower flower = new Flower(name, price, freshness, stemLength);
                    availableFlowers.add(flower);
                }
            }

            // into availableRibbons
            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM Ribbons");
                while (rs.next()) {
                    float price = rs.getFloat("Price");
                    String name = rs.getString("Name");
                    Ribbon ribbon = new Ribbon(price, name);
                    availableRibbons.add(ribbon);
                }
            }

            // into availableVases
            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM Vases");
                while (rs.next()) {
                    float price = rs.getFloat("Price");
                    String name = rs.getString("Name");
                    Vase vase = new Vase(price, name);
                    availableVases.add(vase);
                }
            }

            // Read Wrapping_Papers data and store in availableWrappingPaper list
            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM Wrapping_Papers");
                while (rs.next()) {
                    float price = rs.getFloat("Price");
                    String name = rs.getString("Name");
                    WrappingPaper wrappingPaper = new WrappingPaper(price, name);
                    availableWrappingPaper.add(wrappingPaper);
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void LoadBouquet() {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/Bouquet";
        String user = "root";
        String password = "My32sql";
        flowers.clear();
        vase = null;
        wrappingPapers.clear();
        ribbons.clear();

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            // Read Flowers and put Flowers list
            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM bouquetflowers");
                while (rs.next()) {
                    String name = rs.getString("Name");
                    float price = rs.getFloat("Price");
                    float freshness = rs.getFloat("Freshness");
                    float stemLength = rs.getFloat("Stem_length");
                    Flower flower = new Flower(name, price, freshness, stemLength);
                    flowers.add(flower);
                }
            }

            // into Ribbons
            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM bouquetribbons");
                while (rs.next()) {
                    float price = rs.getFloat("Price");
                    String name = rs.getString("Name");
                    Ribbon ribbon = new Ribbon(price, name);
                    ribbons.add(ribbon);
                }
            }

            // into availableVases
            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM bouquetvase");
                while (rs.next()) {
                    float price = rs.getFloat("Price");
                    String name = rs.getString("Name");
                    vase = new Vase(price, name);
                }
            }

            // Read Wrapping_Papers data and store in WrappingPaper list
            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM bouquetwrappingpaper");
                while (rs.next()) {
                    float price = rs.getFloat("Price");
                    String name = rs.getString("Name");
                    WrappingPaper wrapping = new WrappingPaper(price, name);
                    wrappingPapers.add(wrapping);
                }
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Load bouquet");
            alert.setContentText("Bouquet loaded successfully.");
            alert.showAndWait();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void SaveBouquet() {
        String url = "jdbc:mysql://localhost:3306/Bouquet";
        String user = "root";
        String password = "My32sql";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement stmt = con.prepareStatement("TRUNCATE TABLE bouquetflowers")) {
                stmt.executeUpdate();
            }
            try (PreparedStatement stmt = con.prepareStatement("TRUNCATE TABLE bouquetribbons")) {
                stmt.executeUpdate();
            }
            try (PreparedStatement stmt = con.prepareStatement("TRUNCATE TABLE bouquetvase")) {
                stmt.executeUpdate();
            }
            try (PreparedStatement stmt = con.prepareStatement("TRUNCATE TABLE bouquetwrappingpaper")) {
                stmt.executeUpdate();
            }
            // Save Flowers to database
            if(!flowers.isEmpty()){
            for (Flower flower : flowers) {
                try (PreparedStatement stmt = con.prepareStatement("INSERT INTO bouquetflowers (Name, Price, Freshness, Stem_length) VALUES (?, ?, ?, ?)")) {
                    stmt.setString(1, flower.getName());
                    stmt.setFloat(2, (float) flower.getPrice());
                    stmt.setFloat(3, (float) flower.getFreshness());
                    stmt.setFloat(4, (float) flower.getStem_length());
                    stmt.executeUpdate();
                }
            }}

            // Save Ribbons to database
            if(!ribbons.isEmpty()){
            for (Ribbon ribbon : ribbons) {
                try (PreparedStatement stmt = con.prepareStatement("INSERT INTO bouquetribbons (Price, Name) VALUES (?, ?)")) {
                    stmt.setFloat(1, (float) ribbon.getPrice());
                    stmt.setString(2, ribbon.getName());
                    stmt.executeUpdate();
                }
            }}

            // Save Vase to database
            if(vase != null) {
                try (PreparedStatement stmt = con.prepareStatement("INSERT INTO bouquetvase (Price, Name) VALUES (?, ?)")) {
                    stmt.setFloat(1, (float) vase.getPrice());
                    stmt.setString(2, vase.getName());
                    stmt.executeUpdate();
                }
            }
            // Save Wrapping Papers to database
            if(!wrappingPapers.isEmpty()){
            for (WrappingPaper wrapping : wrappingPapers) {
                try (PreparedStatement stmt = con.prepareStatement("INSERT INTO bouquetwrappingpaper (Price, Name) VALUES (?, ?)")) {
                    stmt.setFloat(1, (float) wrapping.getPrice());
                    stmt.setString(2, wrapping.getName());
                    stmt.executeUpdate();
                }
            }}
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Load bouquet");
            alert.setContentText("Bouquet saved successfully.");
            alert.showAndWait();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void AddExistingFlower() {

        ChoiceDialog<Flower> dialog = new ChoiceDialog<>(availableFlowers.get(0), availableFlowers);
        dialog.setTitle("Add Existing Flower");
        dialog.setHeaderText("Choose a flower to add to the bouquet:");
        dialog.setContentText("Flower:");


        Optional<Flower> result = dialog.showAndWait();

        if (result.isPresent()) {
            Flower chosenFlower = result.get();
            addFlower(chosenFlower);
        }
    }

    public void AddExistingVase() {

        ChoiceDialog<Vase> dialog = new ChoiceDialog<>(availableVases.get(0), availableVases);
        dialog.setTitle("Add Existing Vase");
        dialog.setHeaderText("Choose a vase to add to the bouquet:");
        dialog.setContentText("Vase:");


        Optional<Vase> result = dialog.showAndWait();
        if (result.isPresent()) {
            Vase chosenVase = result.get();
            addVase(chosenVase);
        }
    }

    public void AddExistingRibbon() {

        ChoiceDialog<Ribbon> dialog = new ChoiceDialog<>(availableRibbons.get(0), availableRibbons);
        dialog.setTitle("Add existing ribbon");
        dialog.setHeaderText("Choose a ribbon to add to the bouquet:");
        dialog.setContentText("Ribbon:");

        Optional<Ribbon> result = dialog.showAndWait();

        if (result.isPresent()) {
            Ribbon chosenRibbon = result.get();
            addRibbon(chosenRibbon);
        }

    }

    public void AddExistingWrappingPaper() {
        ChoiceDialog<WrappingPaper> dialog = new ChoiceDialog<>(availableWrappingPaper.get(0), availableWrappingPaper);
        dialog.setTitle("Add existing wrapping paper");
        dialog.setHeaderText("Choose a wrapping paper to add to the bouquet:");
        dialog.setContentText("Paper:");

        Optional<WrappingPaper> result = dialog.showAndWait();

        if (result.isPresent()) {
            WrappingPaper chosenPaper = result.get();
            addWrappingPaper(chosenPaper);

        }
    }


    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Bouquet: \n");
        output.append("Flowers: \n");
        for (Flower flower : flowers) {
            output.append("\t" + flower.toString() + "\n");
        }
        output.append("Vase: " + vase + "\n");
        output.append("Wrapping papers: \n");
        for (WrappingPaper wrappingPaper : wrappingPapers) {
            output.append("\t" + wrappingPaper.toString() + "\n");
        }
        output.append("Ribbons: \n");
        for (Ribbon ribbon : ribbons) {
            output.append("\t" + ribbon.toString() + "\n");
        }
        return output.toString();
    }


}
