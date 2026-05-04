package AbhayRedkarAcademy;

import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 12345);

        BufferedReader userInput =
                new BufferedReader(new InputStreamReader(System.in));

        PrintWriter out =
                new PrintWriter(socket.getOutputStream(), true);

        BufferedReader in =
                new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String str;

        do {
            System.out.print("Enter: ");
            str = userInput.readLine();

            out.println(str);

            String response = in.readLine();
            System.out.println(response);

        } while (true);

        // close garne code xaina
    }
}