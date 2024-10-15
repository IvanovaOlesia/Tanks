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
            enemyData.setLayoutEnemyX(enemyData.getLayoutEnemyX() + 10);
            sendMessageToPlayer(playerData);
            sendMessageToEnemy(enemyData);
        } else if (action.equals("RIGHT")) {
            playerData.setLayoutPlayerX(playerData.getLayoutPlayerX() + 10);
            enemyData.setLayoutEnemyX(enemyData.getLayoutEnemyX() - 10);
            sendMessageToPlayer(playerData);
            sendMessageToEnemy(enemyData);
        } else if (action.equals("SPACE")) {
            playerData.isShot();
            enemyData.isShot();
            playerData.setLayoutBulletUpX(playerData.getLayoutPlayerX() + 38);
            enemyData.setLayoutBulletUpX(enemyData.getLayoutPlayerX() + 38);
            playerData.setLayoutBulletUpY(863);
            enemyData.setLayoutBulletUpY(149);
            sendMessageToPlayer(playerData);
            sendMessageToEnemy(enemyData);
            playerData.isNotShot();
            enemyData.isNotShot();
            playerData.startBulletMoving();
            enemyData.startBulletMoving();
            while (playerData.isMoveBullet()){
                playerData.setLayoutBulletUpY(playerData.getLayoutBulletUpY() - 1);
                enemyData.setLayoutBulletUpY(enemyData.getLayoutBulletUpY() + 1);
                if(isHittingTarget()){
                    playerData.stopBulletMoving();
                    enemyData.stopBulletMoving();
                }
                sendMessageToPlayer(playerData);
                sendMessageToEnemy(enemyData);

            }
        }
    }

    private boolean isHittingTarget() {
        return ((playerData.getLayoutEnemyX() <= playerData.getLayoutBulletUpX() && playerData.getLayoutEnemyX() + 81 >= playerData.getLayoutBulletUpX() )
                && (playerData.getLayoutBulletUpY() == 149 ));
    }

    private void sendMessageToPlayer(GameData playerData) throws IOException {
        String json = new Gson().toJson(playerData);
        playerBufferedWriter.write(json);
        playerBufferedWriter.newLine();
        playerBufferedWriter.flush();
    }
    private void sendMessageToEnemy(GameData enemyData) throws IOException {
        String json = new Gson().toJson(enemyData);
        enamyBufferedWriter.write(json);
        enamyBufferedWriter.newLine();
        enamyBufferedWriter.flush();
    }
}
