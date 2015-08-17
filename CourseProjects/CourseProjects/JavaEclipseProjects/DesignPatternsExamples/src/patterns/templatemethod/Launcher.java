package patterns.templatemethod;

public class Launcher {
    public static void main(String[] args) {
        byte [] data = "abcdefgh".getBytes();
        Connection c1 = new HttpConnection();
        Connection c2 = new SmtpConnection();
        c1.sendMessage(data);
        System.out.println("----------------");
        c2.sendMessage(data);
    }
}
