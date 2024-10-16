package edu.school21.serverTanks.gameLogic;

import edu.school21.serverTanks.model.GameData;
import edu.school21.serverTanks.server.ClientHandler;

import java.io.IOException;

public class BulletLogicHandler {
   public static void updateBulletPosition(ClientHandler clientHandler,GameData playerData, GameData enemyData) throws IOException {
       playerData.isShot();
       enemyData.isShot();
       playerData.setLayoutBulletUpX(playerData.getLayoutPlayerX() + 38);
       enemyData.setLayoutBulletUpX(enemyData.getLayoutPlayerX() + 38);
       playerData.setLayoutBulletUpY(863);
       enemyData.setLayoutBulletUpY(149);
       clientHandler.sendMessageToPlayer(playerData);
       clientHandler.sendMessageToEnemy(enemyData);
       playerData.isNotShot();
       enemyData.isNotShot();
       playerData.startBulletMoving();
       enemyData.startBulletMoving();
       while (playerData.isMoveBullet()){
           playerData.setLayoutBulletUpY(playerData.getLayoutBulletUpY() - 1);
           enemyData.setLayoutBulletUpY(enemyData.getLayoutBulletUpY() + 1);
           if(CollisionHandler.isHittingTarget(playerData)){
               playerData.stopBulletMoving();
               enemyData.stopBulletMoving();
           }
           clientHandler.sendMessageToPlayer(playerData);
           clientHandler.sendMessageToEnemy(enemyData);

       }
   }
}
