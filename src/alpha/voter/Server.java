package alpha.voter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static void main(String[] args) {
        try (ServerSocket socket = new ServerSocket(8080)) {
            System.out.println("Server starts at " +  socket.getLocalPort());
            Socket client = socket.accept();

            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

            System.out.println("Client Connected: " + client.getLocalPort());

            if (Integer.parseInt(reader.readLine()) >= 18) {
                System.out.println("Valid Voter\n");
                writer.println("Valid Voter");
            }
            else {
                writer.println("Invalid Voter");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
