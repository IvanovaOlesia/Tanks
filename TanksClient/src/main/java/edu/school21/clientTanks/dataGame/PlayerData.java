package edu.school21.clientTanks.dataGame;



public class PlayerData {
    private int layoutPlayerX;
    private int layoutEnemyX;

    public PlayerData() {
    }

    public PlayerData(int layoutPlayerX, int layoutEnemyX) {
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
