package edu.school21.clientTanks.view;

import edu.school21.clientTanks.dataGame.PlayerData;
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
    public void moveTank(PlayerData playerData) {
        player.setTranslateX(playerData.getLayoutPlayerX());
        enemy.setTranslateX(playerData.getLayoutEnemyX());
    }
}
