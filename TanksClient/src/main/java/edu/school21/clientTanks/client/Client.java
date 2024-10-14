package edu.school21.clientTanks.client;

import edu.school21.clientTanks.controller.Controller;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.Socket;

public class Client {
    private final int PORT = 8080;
    private Scene scene;
    private Controller controller;
    private Socket socket;
    public Client(Controller controller, Scene scene) throws IOException {
        this.controller = controller;
        this.scene = scene;
        this.socket = new Socket("localhost", PORT);

    }
    public void startClient(){
        scene.setOnKeyPressed(event -> {
            controller.moveImageLeft(event.getCode());
        });
    }
}
