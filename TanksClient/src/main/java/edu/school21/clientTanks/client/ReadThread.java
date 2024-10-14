package edu.school21.clientTanks.client;

import edu.school21.clientTanks.controller.Controller;
import edu.school21.clientTanks.dataGame.PlayerData;

import java.util.Scanner;
import com.google.gson.Gson;

public class ReadThread implements Runnable{
    private Scanner in;
    private Controller controller;
    public ReadThread(Scanner in, Controller controller) {
        this.in = in;
        this.controller = controller;
    }

    @Override
    public void run() {
        while (in.hasNext()){
            PlayerData playerData = new Gson().fromJson(in.nextLine(), PlayerData.class);
            controller.moveTank(playerData);
        }
    }
}
