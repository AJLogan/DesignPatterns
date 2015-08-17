package patterns.state;

public class Launcher {
    public static void main(String[] args) {
        Transaction t = new Transaction();
        t.addResource(new DBMS());
        t.setRollbackOnly();
        t.commit();
    }
}
