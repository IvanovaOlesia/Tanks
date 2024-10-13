package edu.school21.clientTanks.app;
import edu.school21.clientTanks.controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        URL fxmlUrl = getClass().getResource("/view.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
        Scene scene = new Scene(fxmlLoader.load(),1024, 1024);
        Controller controller = fxmlLoader.getController();
        scene.setOnKeyPressed(event -> {
            controller.moveImageLeft(event.getCode());
        });
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
