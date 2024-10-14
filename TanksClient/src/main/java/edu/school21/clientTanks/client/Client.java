package edu.school21.clientTanks.client;

import edu.school21.clientTanks.controller.Controller;
import javafx.scene.Scene;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final int PORT = 8080;
    private Scene scene;
    private Controller controller;
    private Socket client;
    private Scanner in;
    private BufferedWriter out;
    public Client(Controller controller, Scene scene) throws IOException {
        this.controller = controller;
        this.scene = scene;
        this.client = new Socket("localhost", PORT);
        this.in = new Scanner(new InputStreamReader(client.getInputStream()));
        this.out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
    }
    public void startClient(){
        ReadThread readThread = new ReadThread(in, controller);
        WriteThread writeThread = new WriteThread(out, scene);
        new Thread(readThread).start();
        new Thread(writeThread).start();
    }
}
