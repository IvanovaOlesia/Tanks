package edu.school21.clientTanks.controller;

import edu.school21.clientTanks.view.View;
import edu.school21.clientTanks.JSONModel.GameData;

import java.util.Scanner;
import com.google.gson.Gson;
import javafx.application.Platform;

public class ReadThread implements Runnable{
    private Scanner in;
    private View view;
    public ReadThread(Scanner in, View view) {
        this.in = in;
        this.view = view;
    }

    @Override
    public void run() {
        while (in.hasNext()){
            GameData playerData = new Gson().fromJson(in.nextLine(), GameData.class);
            if (playerData.wasShot()) {
                Platform.runLater(() -> {
                    view.setBulletToField(playerData);
                });
            }
            if (playerData.isMoveBullet()){
                Platform.runLater(() -> {
                    view.moveBullet(playerData);
                });
            }
            if (playerData.isDestroyBullet()) {
                Platform.runLater(() -> {
                    view.destroyBullet();
                });
            }
                Platform.runLater(() -> {
                    view.moveTank(playerData);
                });

        }
    }
}
