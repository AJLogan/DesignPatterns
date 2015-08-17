package patterns.templatemethod;

public abstract class Connection {
    public final void sendMessage(byte[] data) {
        openConnection();
        sendData(data);
        closeConnection();
    }
    abstract void openConnection();
    abstract void sendData(byte[] data);
    abstract void closeConnection();
}
