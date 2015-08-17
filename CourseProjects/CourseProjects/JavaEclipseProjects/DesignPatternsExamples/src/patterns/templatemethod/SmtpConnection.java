package patterns.templatemethod;

public class SmtpConnection extends Connection {
    void openConnection() {
        System.out.println("SmtpConnection.openConnection");
    }
    void sendData(byte[] data) {
        System.out.println("SmtpConnection.sendData");
    }
    void closeConnection() {
        System.out.println("SmtpConnection.closeConnection");
    }
}
