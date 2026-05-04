package alpha.voter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            System.out.println("Age: ");
            writer.println(userInput.readLine());
            System.out.println(reader.readLine());
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
