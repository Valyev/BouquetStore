module com.bouquetstore {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.bouquetstore to javafx.fxml;
    exports com.bouquetstore;
}