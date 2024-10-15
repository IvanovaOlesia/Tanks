package edu.school21.clientTanks.JSONModel;


public class GameData {
    private int layoutPlayerX;
    private int layoutEnemyX;
    private boolean shot;
    private boolean moveBullet;
    private int layoutBulletDownX;
    private int layoutBulletUpX;
    private int layoutBulletDownY;
    private int layoutBulletUpY;

    public GameData() {
    }

    public GameData(int layoutPlayerX, int layoutEnemyX) {
        this.layoutEnemyX = layoutEnemyX;
        this.layoutPlayerX = layoutPlayerX;
        this.shot = false;
    }

    public int getLayoutPlayerX() {
        return layoutPlayerX;
    }

    public int getLayoutEnemyX() {
        return layoutEnemyX;
    }

    public void setLayoutPlayerX(int layoutPlayerX) {
        this.layoutPlayerX = layoutPlayerX;
    }

    public void setLayoutEnemyX(int layoutEnemyX) {
        this.layoutEnemyX = layoutEnemyX;
    }

    public void isShot() {
        shot = true;
    }
    public void startBulletMoving(){
        moveBullet = true;
    }
    public void stopBulletMoving(){
        moveBullet = false;
    }
    public boolean isMoveBullet(){
        return moveBullet;
    }

    public boolean wasShot() {
        return shot;
    }

    public int getLayoutBulletDownX() {
        return layoutBulletDownX;
    }

    public int getLayoutBulletUpX() {
        return layoutBulletUpX;
    }

    public void setLayoutBulletDownX(int layoutBulletDownX) {
        this.layoutBulletDownX = layoutBulletDownX;
    }

    public void setLayoutBulletUpX(int layoutBulletUpX) {
        this.layoutBulletUpX = layoutBulletUpX;
    }

    public int getLayoutBulletDownY() {
        return layoutBulletDownY;
    }

    public int getLayoutBulletUpY() {
        return layoutBulletUpY;
    }

    public void setLayoutBulletDownY(int layoutBulletDownY) {
        this.layoutBulletDownY = layoutBulletDownY;
    }

    public void setLayoutBulletUpY(int layoutBulletUpY) {
        this.layoutBulletUpY = layoutBulletUpY;
    }
}
