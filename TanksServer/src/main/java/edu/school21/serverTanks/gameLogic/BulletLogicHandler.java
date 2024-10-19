package edu.school21.serverTanks.gameLogic;

import edu.school21.serverTanks.model.Bullet;
import edu.school21.serverTanks.model.GameData;
import edu.school21.serverTanks.server.ClientHandler;

import java.io.IOException;

public class BulletLogicHandler {
    public static void spawnBullet(ClientHandler clientHandler,GameData playerData, GameData enemyData) throws IOException {
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

    }
   public static void updateBulletPosition(ClientHandler clientHandler,GameData playerData, GameData enemyData) throws IOException {

       playerData.getBulletUpList().forEach(bullet -> {
           if (bullet.getY() > 0) {
               bullet.setY(bullet.getY() - 10);
           }

//           if (ShootingImpactChecker.isHittingTargetPlayer(playerData)){
//               playerData.stopBulletMoving();
//               playerData.setDestroyBullet(true);
//               resetCoordinates(bullet);
//           }

       });
       enemyData.getBulletDownList().forEach(bullet -> {
           if (bullet.getY() > 0) {
               bullet.setY(bullet.getY() + 10);
           }
//           if (ShootingImpactChecker.isHittingTargetEnemy(enemyData)){
//               enemyData.stopBulletMoving();
//               enemyData.setDestroyBullet(true);
//               resetCoordinates(bullet);
//           }
       });
       try {
           clientHandler.sendMessageToPlayer(playerData);
           clientHandler.sendMessageToPlayer(enemyData);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
//       enemyData.getBulletUpList().forEach(bullet -> bullet.setY(bullet.getY() - 0.16));
//       while (playerData.isMoveBullet()){
//           playerData.setLayoutBulletUpY(playerData.getLayoutBulletUpY() - 0.016);
//           enemyData.setLayoutBulletDownY(enemyData.getLayoutBulletDownY() + 0.016);
//           if(ShootingImpactChecker.isHittingTarget(playerData)){
//               playerData.stopBulletMoving();
//               enemyData.stopBulletMoving();
//               playerData.setDestroyBullet(true);
//               enemyData.setDestroyBullet(true);
//           }
//           clientHandler.sendMessageToPlayer(playerData);
//           clientHandler.sendMessageToEnemy(enemyData);
//
//       }

       playerData.setDestroyBullet(false);
       enemyData.setDestroyBullet(false);
//       playerData.setLayoutBulletUpX(-1.00);
//       playerData.setLayoutBulletDownX(-1.00);
//       enemyData.setLayoutBulletDownX(-1.00);
//       enemyData.setLayoutBulletUpX(-1.00);
//       playerData.setLayoutBulletUpY(-1.00);
//       playerData.setLayoutBulletDownY(-1.00);
//       enemyData.setLayoutBulletDownY(-1.00);
//       enemyData.setLayoutBulletUpY(-1.00);
   }

    private static void resetCoordinates(Bullet bullet) {
       bullet.setX(-1.00);
       bullet.setY(-1.00);
    }

    private static void updateBulletPositionEnemy(GameData enemyData) {
        Bullet bulletDown = new Bullet();
        bulletDown.setX(enemyData.getLayoutPlayerX() + 38.00);
        bulletDown.setY(149);
        enemyData.getBulletDownList().add(bulletDown);

        Bullet bulletUp = new Bullet();
        bulletUp.setX(-1.00);
        bulletUp.setY(-1.00);
        enemyData.getBulletUpList().add(bulletUp);

        enemyData.setLayoutBulletDownX(enemyData.getLayoutEnemyX() + 38.00);
        enemyData.setLayoutBulletDownY(149.00);

        enemyData.setLayoutBulletUpX(-1.00);
        enemyData.setLayoutBulletUpY(-1.00);

    }

    private static void updateBulletPositionPlayer(GameData playerData) {
        Bullet bulletUp = new Bullet();
        bulletUp.setX(playerData.getLayoutPlayerX() + 38.00);
        bulletUp.setY(863);
        playerData.getBulletUpList().add(bulletUp);

        Bullet bulletDown = new Bullet();
        bulletDown.setX(-1.00);
        bulletDown.setY(-1.00);
        playerData.getBulletDownList().add(bulletDown);

        playerData.setLayoutBulletUpX(playerData.getLayoutPlayerX() + 38.00);
        playerData.setLayoutBulletUpY(863.00);

        playerData.setLayoutBulletDownX(-1.00);
        playerData.setLayoutBulletDownY(-1.00);
    }
}
