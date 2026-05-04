package fundamentals;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 9090)) {
            try (DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream())) {
                dataOutputStream.writeUTF("Hello From Client");
                dataOutputStream.flush();

                try (DataInputStream dataInputStream = new DataInputStream(socket.getInputStream())) {
                    System.out.println(dataInputStream.readUTF());
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
