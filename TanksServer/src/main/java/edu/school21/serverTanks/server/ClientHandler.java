package edu.school21.serverTanks.server;

import com.google.gson.Gson;
import edu.school21.serverTanks.gameLogic.PlayerActionHandler;
import edu.school21.serverTanks.model.GameData;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private GameData playerData;
    private GameData enemyData;
    private Socket player;
    private Socket enemy;
    private String action;
    private BufferedReader playerBufferedReader;
    private BufferedWriter playerBufferedWriter;
    private BufferedReader enamyBufferedReader;
    private BufferedWriter enamyBufferedWriter;
    public ClientHandler(Socket player, Socket enemy, GameData playerData, GameData enemyData) throws IOException {
        this.player = player;
        this.enemy = enemy;
        this.playerBufferedReader = new BufferedReader(new InputStreamReader(player.getInputStream()));
        this.playerBufferedWriter = new BufferedWriter(new OutputStreamWriter(player.getOutputStream()));
        this.enamyBufferedReader = new BufferedReader(new InputStreamReader(enemy.getInputStream()));
        this.enamyBufferedWriter = new BufferedWriter(new OutputStreamWriter(enemy.getOutputStream()));
        this.playerData = playerData;
        this.enemyData = enemyData;
    }


    @Override
    public void run() {
        try {
            sendMessageToPlayer(playerData);
            sendMessageToEnemy(enemyData);
//            while (true){
//                getActionClient();
//            }

                startReading();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void startReading() {
        Thread inputThread = new Thread(() -> {
            try {
                while (true) {
                    action = playerBufferedReader.readLine();

                    if (action == null) {
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        inputThread.start();
    }

    private void handlePlayerAction(String action) throws IOException {
        PlayerActionHandler.handlePlayerAction(this,action,playerData,enemyData);
    }



    public void sendMessageToPlayer(GameData playerData) throws IOException {
        String json = new Gson().toJson(playerData);
        playerBufferedWriter.write(json);
        playerBufferedWriter.newLine();
        playerBufferedWriter.flush();
    }
    public void sendMessageToEnemy(GameData enemyData) throws IOException {
        String json = new Gson().toJson(enemyData);
        enamyBufferedWriter.write(json);
        enamyBufferedWriter.newLine();
        enamyBufferedWriter.flush();
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
