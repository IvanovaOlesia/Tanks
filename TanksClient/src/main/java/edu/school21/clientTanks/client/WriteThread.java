package edu.school21.clientTanks.client;

import javafx.scene.Scene;

import java.io.BufferedWriter;
import java.io.IOException;
public class WriteThread implements Runnable{
    private BufferedWriter out;
    private Scene scene;
    public WriteThread(BufferedWriter out, Scene scene) {
        this.out = out;
        this.scene = scene;
    }
    @Override
    public void run() {
        while (true){
            scene.setOnKeyPressed(event -> {
                try {
                    out.write(event.getCode().toString());
                    out.newLine();
                    out.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
