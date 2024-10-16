package edu.school21.serverTanks.gameLogic;

import edu.school21.serverTanks.model.GameData;
import edu.school21.serverTanks.server.ClientHandler;

import java.io.IOException;

public class BulletLogicHandler {
   public static void updateBulletPosition(ClientHandler clientHandler,GameData playerData, GameData enemyData) throws IOException {
       playerData.isShot();
       enemyData.isShot();
       updateBulletPositionPlayer(playerData);
       updateBulletPositionEnemy(enemyData);
       clientHandler.sendMessageToPlayer(playerData);
       clientHandler.sendMessageToEnemy(enemyData);
       playerData.isNotShot();
       enemyData.isNotShot();
       playerData.startBulletMoving();
       enemyData.startBulletMoving();
       while (playerData.isMoveBullet()){
           playerData.setLayoutBulletUpY(playerData.getLayoutBulletUpY() - 0.016);
           enemyData.setLayoutBulletDownY(enemyData.getLayoutBulletDownY() + 0.016);
           if(ShootingImpactChecker.isHittingTarget(playerData)){
               playerData.stopBulletMoving();
               enemyData.stopBulletMoving();
               playerData.setDestroyBullet(true);
               enemyData.setDestroyBullet(true);
           }
           clientHandler.sendMessageToPlayer(playerData);
           clientHandler.sendMessageToEnemy(enemyData);

       }
       playerData.setDestroyBullet(false);
       enemyData.setDestroyBullet(false);
       playerData.setLayoutBulletUpX(-1.00);
       playerData.setLayoutBulletDownX(-1.00);
       enemyData.setLayoutBulletDownX(-1.00);
       enemyData.setLayoutBulletUpX(-1.00);
       playerData.setLayoutBulletUpY(-1.00);
       playerData.setLayoutBulletDownY(-1.00);
       enemyData.setLayoutBulletDownY(-1.00);
       enemyData.setLayoutBulletUpY(-1.00);
   }

    private static void updateBulletPositionEnemy(GameData enemyData) {
        enemyData.setLayoutBulletDownX(enemyData.getLayoutEnemyX() + 38.00);
        enemyData.setLayoutBulletDownY(149.00);
        enemyData.setLayoutBulletUpX(-1.00);
        enemyData.setLayoutBulletUpY(-1.00);

    }

    private static void updateBulletPositionPlayer(GameData playerData) {
        playerData.setLayoutBulletUpX(playerData.getLayoutPlayerX() + 38.00);
        playerData.setLayoutBulletUpY(863.00);
        playerData.setLayoutBulletDownX(-1.00);
        playerData.setLayoutBulletDownY(-1.00);
    }
}
