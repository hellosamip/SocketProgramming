package ServerClient;

import java.util.Scanner;

public class Main {
    static final int PORT_NUMBER = 12345;

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Is this a Server? (Y/N)");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("Y")) {
                new MyServer().start(PORT_NUMBER);
            } else {
                new MyClient().start(PORT_NUMBER, scanner);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}