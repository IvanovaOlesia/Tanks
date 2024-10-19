package edu.school21.serverTanks.model;

import java.util.ArrayList;
import java.util.List;

public class GameData {
    private  double layoutPlayerX;
    private  double layoutEnemyX;
    private  boolean shot;
    private boolean destroyBullet;
    private  boolean moveBullet;
    private  double layoutBulletDownX;
    private  double layoutBulletUpX;
    private  double layoutBulletDownY;
    private  double layoutBulletUpY;
    private List<Bullet> bulletUpList;
    private List<Bullet> bulletDownList;

    public GameData() {
    }

    public List<Bullet> getBulletUpList() {
        return bulletUpList;
    }

    public void setBulletUpList(List<Bullet> bulletUpList) {
        this.bulletUpList = bulletUpList;
    }

    public List<Bullet> getBulletDownList() {
        return bulletDownList;
    }

    public void setBulletDownList(List<Bullet> bulletDownList) {
        this.bulletDownList = bulletDownList;
    }

    public void setDestroyBullet(boolean destroyBullet) {
        this.destroyBullet = destroyBullet;
    }

    public GameData(double layoutPlayerX, double layoutEnemyX) {
        this.layoutEnemyX = layoutEnemyX;
        this.layoutPlayerX = layoutPlayerX;
        this.shot = false;
        this.moveBullet = false;
        this.destroyBullet = false;
        layoutBulletDownX = -1;
        layoutBulletUpX = -1;
        layoutBulletDownY = -1;
        layoutBulletUpY = -1;
        bulletUpList = new ArrayList<>();
        bulletDownList = new ArrayList<>();
    }

    public  double getLayoutPlayerX() {
        return layoutPlayerX;
    }

    public  double getLayoutEnemyX() {
        return layoutEnemyX;
    }

    public  void setLayoutPlayerX(double layoutPlayerX) {
        this.layoutPlayerX = layoutPlayerX;
    }

    public  void setLayoutEnemyX(double layoutEnemyX) {
        this.layoutEnemyX = layoutEnemyX;
    }

    public  void isShot() {
        shot = true;
    }
    public  void isNotShot() {
        shot = false;
    }
    public  void startBulletMoving(){
        moveBullet = true;
    }
    public  void stopBulletMoving(){
        moveBullet = false;
    }
    public  boolean isMoveBullet(){
        return moveBullet;
    }

    public  boolean wasShot() {
        return shot;
    }

    public  double getLayoutBulletDownX() {
        return layoutBulletDownX;
    }

    public  double getLayoutBulletUpX() {
        return layoutBulletUpX;
    }

    public  void setLayoutBulletDownX(double layoutBulletDownX) {
        this.layoutBulletDownX = layoutBulletDownX;
    }

    public  void setLayoutBulletUpX(double layoutBulletUpX) {
        this.layoutBulletUpX = layoutBulletUpX;
    }

    public  double getLayoutBulletDownY() {
        return layoutBulletDownY;
    }

    public  double getLayoutBulletUpY() {
        return layoutBulletUpY;
    }

    public  void setLayoutBulletDownY(double layoutBulletDownY) {
        this.layoutBulletDownY = layoutBulletDownY;
    }

    public  void setLayoutBulletUpY(double layoutBulletUpY) {
        this.layoutBulletUpY = layoutBulletUpY;
    }
}
