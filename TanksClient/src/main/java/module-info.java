module edu.school21.clientTanks {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.dlsc.formsfx;

    opens edu.school21.clientTanks.app to javafx.fxml;
    exports edu.school21.clientTanks.app ;

    opens edu.school21.clientTanks.controller to javafx.fxml;
    exports edu.school21.clientTanks.controller;

}