module com.example.ikkunat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.ikkunat to javafx.fxml;
    exports com.example.ikkunat;
}