package edu.school21.serverTanks.app;

import edu.school21.serverTanks.config.SocketApplicationConfig;
import edu.school21.serverTanks.server.Server;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SocketApplicationConfig.class);
        Server server = context.getBean(Server.class);
        server.startServer();
    }
}
