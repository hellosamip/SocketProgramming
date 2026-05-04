package fundamentals;

public class ServerStatus {
    private static int status = 0;

    public static int getStatus() {
        return status;
    }

    public static void setStatus(int status) {
        ServerStatus.status = status;
    }
}
