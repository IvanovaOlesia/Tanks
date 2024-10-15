package edu.school21.clientTanks.controller;

import edu.school21.clientTanks.view.View;
import edu.school21.clientTanks.JSONModel.GameData;

import java.util.Scanner;
import com.google.gson.Gson;

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
            view.moveTank(playerData);
        }
    }
}
