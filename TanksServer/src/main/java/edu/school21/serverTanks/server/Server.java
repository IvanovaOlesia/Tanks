package edu.school21.serverTanks.server;

import edu.school21.serverTanks.model.GameData;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Component
public class Server {
    private final int PORT = 8081;
    private GameData playerData;
    private GameData enemyData;


    public void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket player = serverSocket.accept();
        Socket enemy = serverSocket.accept();
        playerData = new GameData(472,472);
        enemyData = new GameData(472,472);
        new Thread(new ClientHandler(player, enemy, playerData,enemyData )).start();
        new Thread(new ClientHandler(enemy,player, enemyData,playerData )).start();
    }
}
