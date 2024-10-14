package edu.school21.serverTanks.server;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Component
public class Server {
    private final int PORT = 8080;


    public void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket player = serverSocket.accept();
        Socket enemy = serverSocket.accept();
        new Thread(new ClientHandler(player, enemy)).start();
        new Thread(new ClientHandler(enemy,player)).start();
    }
}
