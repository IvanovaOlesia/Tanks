package edu.school21.serverTanks.server;

import com.google.gson.Gson;
import edu.school21.serverTanks.model.GameData;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private GameData playerData;
    private GameData enemyData;
    private Socket player;
    private Socket enemy;
    private BufferedReader playerBufferedReader;
    private BufferedWriter playerBufferedWriter;
    private BufferedReader enamyBufferedReader;
    private BufferedWriter enamyBufferedWriter;
    public ClientHandler(Socket player, Socket enemy) throws IOException {
        this.player = player;
        this.enemy = enemy;
        this.playerBufferedReader = new BufferedReader(new InputStreamReader(player.getInputStream()));
        this.playerBufferedWriter = new BufferedWriter(new OutputStreamWriter(player.getOutputStream()));
        this.enamyBufferedReader = new BufferedReader(new InputStreamReader(enemy.getInputStream()));
        this.enamyBufferedWriter = new BufferedWriter(new OutputStreamWriter(enemy.getOutputStream()));
        this.playerData = new GameData(14,14);
        this.enemyData = new GameData(14,14);
    }


    @Override
    public void run() {
        try {
            sendMessageToPlayer(playerData);
            sendMessageToEnemy(enemyData);
            while (true){
                getActionClient();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void getActionClient() throws IOException {
        String action = playerBufferedReader.readLine();
        if (action.equals("LEFT")){
            playerData.setLayoutPlayerX(playerData.getLayoutPlayerX() - 10);
            enemyData.setLayoutEnemyX(enemyData.getLayoutEnemyX() - 10);
            sendMessageToPlayer(playerData);
            sendMessageToEnemy(enemyData);
        } else if (action.equals("RIGHT")) {
            playerData.setLayoutPlayerX(playerData.getLayoutPlayerX() + 10);
            enemyData.setLayoutEnemyX(enemyData.getLayoutEnemyX() + 10);
            sendMessageToPlayer(playerData);
            sendMessageToEnemy(enemyData);

        }
    }

    private void sendMessageToPlayer(GameData playerData) throws IOException {
        String json = new Gson().toJson(playerData);
        playerBufferedWriter.write(json);
        playerBufferedWriter.newLine();
        playerBufferedWriter.flush();
    }
    private void sendMessageToEnemy(GameData playerData) throws IOException {
        String json = new Gson().toJson(playerData);
        enamyBufferedWriter.write(json);
        enamyBufferedWriter.newLine();
        enamyBufferedWriter.flush();
    }
}
