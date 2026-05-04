package ServerClient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {

    public void start(final int portNumber, final Scanner scanner) {

        try (Socket socket = new Socket("localhost", portNumber);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Socket Created");

            for (String userInput; !(userInput = scanner.nextLine()).isEmpty(); ) {
                writer.println(userInput);
            }

            System.out.println("Connection closed");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new MyClient().start(12345, scanner);
    }
}