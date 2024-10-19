package edu.school21.serverTanks.gameLogic;

import edu.school21.serverTanks.model.GameData;

public class ShootingImpactChecker {
    public static boolean isHittingTargetPlayer(GameData playerData) {
        return (((playerData.getLayoutEnemyX() <= playerData.getLayoutBulletUpX()) && (playerData.getLayoutEnemyX() + 81.00 >= playerData.getLayoutBulletUpX()) )
                && (playerData.getLayoutBulletUpY() <= 130.00 ));
    }
    public static boolean isHittingTargetEnemy(GameData enemyData) {
        return (((enemyData.getLayoutPlayerX() <= enemyData.getLayoutBulletUpX()) && (enemyData.getLayoutPlayerX() + 81.00 >= enemyData.getLayoutBulletUpX()) )
                && (enemyData.getLayoutBulletDownY() >= 880.00 ));
    }
}
