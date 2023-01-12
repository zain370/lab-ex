module com.example.parta {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.parta to javafx.fxml;
    exports com.example.parta;
}