package edu.school21.serverTanks.model;

public class GameData {
    private volatile int layoutPlayerX;
    private volatile int layoutEnemyX;
    private volatile boolean shot;
    private volatile boolean moveBullet;
    private volatile int layoutBulletDownX;
    private volatile int layoutBulletUpX;
    private volatile int layoutBulletDownY;
    private volatile int layoutBulletUpY;

    public GameData() {
    }

    public GameData(int layoutPlayerX, int layoutEnemyX) {
        this.layoutEnemyX = layoutEnemyX;
        this.layoutPlayerX = layoutPlayerX;
        this.shot = false;
        this.moveBullet = false;
    }

    public synchronized int getLayoutPlayerX() {
        return layoutPlayerX;
    }

    public synchronized int getLayoutEnemyX() {
        return layoutEnemyX;
    }

    public synchronized void setLayoutPlayerX(int layoutPlayerX) {
        this.layoutPlayerX = layoutPlayerX;
    }

    public synchronized void setLayoutEnemyX(int layoutEnemyX) {
        this.layoutEnemyX = layoutEnemyX;
    }

    public synchronized void isShot() {
        shot = true;
    }
    public synchronized void isNotShot() {
        shot = false;
    }
    public synchronized void startBulletMoving(){
        moveBullet = true;
    }
    public synchronized void stopBulletMoving(){
        moveBullet = false;
    }
    public synchronized boolean isMoveBullet(){
        return moveBullet;
    }

    public synchronized boolean wasShot() {
        return shot;
    }

    public synchronized int getLayoutBulletDownX() {
        return layoutBulletDownX;
    }

    public synchronized int getLayoutBulletUpX() {
        return layoutBulletUpX;
    }

    public synchronized void setLayoutBulletDownX(int layoutBulletDownX) {
        this.layoutBulletDownX = layoutBulletDownX;
    }

    public synchronized void setLayoutBulletUpX(int layoutBulletUpX) {
        this.layoutBulletUpX = layoutBulletUpX;
    }

    public synchronized int getLayoutBulletDownY() {
        return layoutBulletDownY;
    }

    public synchronized int getLayoutBulletUpY() {
        return layoutBulletUpY;
    }

    public synchronized void setLayoutBulletDownY(int layoutBulletDownY) {
        this.layoutBulletDownY = layoutBulletDownY;
    }

    public synchronized void setLayoutBulletUpY(int layoutBulletUpY) {
        this.layoutBulletUpY = layoutBulletUpY;
    }
}
