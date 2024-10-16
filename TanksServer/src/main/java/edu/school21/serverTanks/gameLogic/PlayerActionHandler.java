package edu.school21.serverTanks.gameLogic;

import edu.school21.serverTanks.model.GameData;
import edu.school21.serverTanks.server.ClientHandler;
import edu.school21.serverTanks.server.Server;

import java.io.IOException;

public class PlayerActionHandler {
    public static synchronized void handlePlayerAction(ClientHandler clientHandler, String action, GameData playerData, GameData enemyData) throws IOException {
        if (action.equals("LEFT")){
            PlayerMovementHandler.moveLeft(playerData, enemyData);
            clientHandler.sendMessageToPlayer(playerData);
            clientHandler.sendMessageToEnemy(enemyData);
        } else if (action.equals("RIGHT")) {
            PlayerMovementHandler.moveRight(playerData, enemyData);
            clientHandler.sendMessageToPlayer(playerData);
            clientHandler.sendMessageToEnemy(enemyData);
        } else if (action.equals("SPACE")) {
            BulletLogicHandler.updateBulletPosition(clientHandler,playerData, enemyData);

        }
    }
}
