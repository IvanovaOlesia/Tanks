module edu.school21.clientTanks {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.dlsc.formsfx;
    requires com.google.gson;

    opens edu.school21.clientTanks.app to javafx.fxml;
    exports edu.school21.clientTanks.app ;

    opens edu.school21.clientTanks.view to javafx.fxml;
    exports edu.school21.clientTanks.view;

}