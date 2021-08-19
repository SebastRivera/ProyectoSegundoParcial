module espol.proyecto {
    requires javafx.controls;
    requires javafx.fxml;
    

    opens espol.proyecto to javafx.fxml;
    opens espol.model to javafx.fxml;
    exports espol.proyecto;
    exports espol.model;
}
