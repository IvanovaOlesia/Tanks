package edu.school21.clientTanks.view;

import edu.school21.clientTanks.JSONModel.GameData;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

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
    private List<ImageView> imageViewBulletDownList = new ArrayList<>();
    private List<ImageView> imageViewBulletUpList = new ArrayList<>();


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
        if (playerData.getLayoutBulletUpX() > 0 ) {
            Image imageBulletUp = new Image(getResourcePathToBulletUp);
            ImageView imageViewBulletUp = new ImageView(imageBulletUp);
            imageViewBulletUp.setLayoutX(playerData.getLayoutBulletUpX());
            imageViewBulletUp.setLayoutY(playerData.getLayoutBulletUpY());
            field.getChildren().add(imageViewBulletUp);
            imageViewBulletUpList.add(imageViewBulletUp);
        }
        if(playerData.getLayoutBulletDownX() > 0) {
            Image imageBulletDown = new Image(resourcePathToBulletDown);
            ImageView imageViewBulletDown = new ImageView(imageBulletDown);
            imageViewBulletDown.setLayoutX(playerData.getLayoutBulletDownX());
            imageViewBulletDown.setLayoutY(playerData.getLayoutBulletDownY());
            field.getChildren().add(imageViewBulletDown);
            imageViewBulletDownList.add(imageViewBulletDown);
        }
    }
    public void moveBullet(GameData playerData){
        if (imageViewBulletUpList != null ) {
            imageViewBulletUpList.forEach(imageViewBulletUp -> imageViewBulletUp.setLayoutY(playerData.getLayoutBulletUpY()));
        }
        if (imageViewBulletDownList != null ) {
            imageViewBulletDownList.forEach(imageViewBulletDown -> imageViewBulletDown.setLayoutY(playerData.getLayoutBulletDownY()));
        }
    }
    public void destroyBullet(){
//        imageViewBulletDown = null;
//        imageViewBulletUp = null;
        if (imageViewBulletUpList != null ) {
            field.getChildren().remove(imageViewBulletUpList.get(0));
            imageViewBulletUpList.remove(0);
        }
        if (imageViewBulletDownList != null ) {
            field.getChildren().remove(imageViewBulletDownList.get(0));
            imageViewBulletDownList.remove(0);
        }
    }
}
