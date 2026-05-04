package ServerClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    public void start(int portNumber) {
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {

            System.out.println("Server started. Waiting for Client...");

            try (Socket client = serverSocket.accept();
                 BufferedReader reader = new BufferedReader(
                         new InputStreamReader(client.getInputStream()));
                 PrintWriter writer = new PrintWriter(client.getOutputStream(), true)
            ) {

                System.out.println("Client connected: " + client.getInetAddress() + "\nPort Number: " + client.getLocalPort());

                String msg;

                while ((msg = reader.readLine()) != null) {
                    System.out.println("Client: " + msg);
                }

                System.out.println("Client disconnected");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}