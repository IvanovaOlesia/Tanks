package edu.school21.serverTanks.model;

public class GameData {
    private int layoutPlayerX;
    private int layoutEnemyX;

    public GameData() {
    }

    public GameData(int layoutPlayerX, int layoutEnemyX) {
        this.layoutEnemyX = layoutEnemyX;
        this.layoutPlayerX = layoutPlayerX;
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
}
