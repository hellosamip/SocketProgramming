// yo code syntax ko reference ko lagi matra ho
package AbhayRedkarAcademy;

import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {

        System.out.println("Waiting for Client...");

        ServerSocket serverSocket = new ServerSocket(12345);
        Socket socket = serverSocket.accept();

        System.out.println("Client connected");

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        String str;

        while ((str = reader.readLine()) != null) {
            System.out.println("Client: " + str);
            writer.println("Server: " + str);
        }

        socket.close();
        serverSocket.close();

        System.out.println("Connection closed");
    }
}