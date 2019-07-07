module kfryc.ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires kfryc.db;

    opens ui to javafx.fxml;

    exports ui to javafx.graphics;
}