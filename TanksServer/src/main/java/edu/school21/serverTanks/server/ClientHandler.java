package edu.school21.serverTanks.server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private Socket player;
    private Socket enemy;
    private BufferedReader playerBufferedReader;
    private BufferedWriter playerBufferedWriter;
    private BufferedReader enamyBufferedReader;
    private BufferedWriter enamyBufferedWriter;
    public ClientHandler(Socket player, Socket enemy) throws IOException {
        this.player = player;
        this.enemy = enemy;
        this.playerBufferedReader = new BufferedReader(new InputStreamReader(player.getInputStream()));
        this.playerBufferedWriter = new BufferedWriter(new OutputStreamWriter(player.getOutputStream()));
        this.enamyBufferedReader = new BufferedReader(new InputStreamReader(enemy.getInputStream()));
        this.enamyBufferedWriter = new BufferedWriter(new OutputStreamWriter(enemy.getOutputStream()));
    }


    @Override
    public void run() {
        try {
            sendMessageToPlayer("Start game");
            sendMessageToEnemy("Start game");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendMessageToPlayer(String message) throws IOException {
        playerBufferedWriter.write(message);
        playerBufferedWriter.newLine();
        playerBufferedWriter.flush();
    }
    private void sendMessageToEnemy(String message) throws IOException {
        enamyBufferedWriter.write(message);
        enamyBufferedWriter.newLine();
        enamyBufferedWriter.flush();
    }
}
