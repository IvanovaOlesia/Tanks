package edu.school21.clientTanks.app;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.InputStream;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Tanks");
        stage.setWidth(800);
        stage.setHeight(600);
        InputStream iconStream = getClass().getClassLoader().getResourceAsStream("icon.png");
    }
}
