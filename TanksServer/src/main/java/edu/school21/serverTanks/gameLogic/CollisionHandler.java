package edu.school21.serverTanks.gameLogic;

import edu.school21.serverTanks.model.GameData;

public class CollisionHandler {
   public static boolean isHittingTarget(GameData playerData) {
        return ((playerData.getLayoutEnemyX() <= playerData.getLayoutBulletUpX() && playerData.getLayoutEnemyX() + 81 >= playerData.getLayoutBulletUpX() )
                && (playerData.getLayoutBulletUpY() == 149 ));
    }
}
