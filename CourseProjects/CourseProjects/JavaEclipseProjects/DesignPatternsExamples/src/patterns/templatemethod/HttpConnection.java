package patterns.templatemethod;

public class HttpConnection extends Connection {
    void openConnection() {
        System.out.println("HttpConnection.openConnection");
    }
    void sendData(byte[] data) {
        System.out.println("HttpConnection.sendData");
    }
    void closeConnection() {
        System.out.println("HttpConnection.closeConnection");
    }
}
