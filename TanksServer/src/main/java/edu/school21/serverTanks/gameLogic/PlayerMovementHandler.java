package edu.school21.serverTanks.gameLogic;

import edu.school21.serverTanks.model.GameData;

public class PlayerMovementHandler {
    public static void moveLeft(GameData playerData, GameData enemyData){
        playerData.setLayoutPlayerX(playerData.getLayoutPlayerX() - 10);
        enemyData.setLayoutEnemyX(enemyData.getLayoutEnemyX() + 10);
    }
    public static void moveRight(GameData playerData, GameData enemyData){
        playerData.setLayoutPlayerX(playerData.getLayoutPlayerX() + 10);
        enemyData.setLayoutEnemyX(enemyData.getLayoutEnemyX() - 10);
    }
}
