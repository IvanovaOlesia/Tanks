package edu.school21.clientTanks.view;

import edu.school21.clientTanks.JSONModel.GameData;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class View {
    @FXML
    private ImageView player;
    @FXML
    private ImageView enemy;
    @FXML
    private AnchorPane field;
    private Scene scene;
    private  String resourcePathToBulletDown = getClass().getResource("/bulletDown.png").toExternalForm();
    private  String getResourcePathToBulletUp = getClass().getResource("/bulletUp.png").toExternalForm();
    private ImageView imageViewBulletDown;
    private ImageView imageViewBulletUp;


    public View() {
    }

    public View(Scene scene) {
        this.scene = scene;
    }

    @FXML
    public void initialize() {

    }
    public void moveTank(GameData playerData) {
        player.setLayoutX(playerData.getLayoutPlayerX());
        enemy.setLayoutX(playerData.getLayoutEnemyX());

    }
    public void setBulletToField(GameData playerData){
        Image imageBulletUp = new Image(getResourcePathToBulletUp);
        imageViewBulletUp = new ImageView(imageBulletUp);
        imageViewBulletUp.setLayoutX(playerData.getLayoutBulletUpX());
        imageViewBulletUp.setLayoutY(863);
        field.getChildren().add(imageViewBulletUp);
        Image imageBulletDown = new Image(resourcePathToBulletDown);
        imageViewBulletDown = new ImageView(imageBulletDown);
        imageViewBulletDown.setLayoutX(playerData.getLayoutBulletUpX());
        imageViewBulletDown.setLayoutY(149);
        field.getChildren().add(imageViewBulletDown);
    }
    public void moveBullet(GameData playerData){

        imageViewBulletUp.setLayoutY(playerData.getLayoutBulletUpY());


        imageViewBulletDown.setLayoutY(playerData.getLayoutBulletDownY());


    }
}
