package edu.school21.clientTanks.controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class Controller {
    @FXML
    private ImageView player;

    @FXML
    private ImageView field;
    @FXML
    public void initialize() {

    }
    public  void moveImageLeft( KeyCode keyCode) {
        if (keyCode == KeyCode.LEFT) {
            enemy.setTranslateX(enemy.getTranslateX() - 10);
        } else if (keyCode == KeyCode.RIGHT) {
            enemy.setTranslateX(enemy.getTranslateX() + 10);
        }

    }
}
