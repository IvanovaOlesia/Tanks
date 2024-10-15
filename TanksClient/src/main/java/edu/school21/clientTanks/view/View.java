package edu.school21.clientTanks.view;

import edu.school21.clientTanks.JSONModel.GameData;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

public class View {
    @FXML
    private ImageView player;
    @FXML
    private ImageView enemy;
    private Scene scene;

    public View() {
    }

    public View(Scene scene) {
        this.scene = scene;
    }

    @FXML
    public void initialize() {

    }
    public void moveTank(GameData playerData) {
        player.setTranslateX(playerData.getLayoutPlayerX());
        enemy.setTranslateX(playerData.getLayoutEnemyX());
    }
}
