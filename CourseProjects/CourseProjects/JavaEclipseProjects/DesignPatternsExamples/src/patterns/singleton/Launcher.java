package patterns.singleton;

public class Launcher {
    public static void main(String[] args) {
        ErrorLog log1 = ErrorLog.getInstance();
        log1.write("message one");
        log1.write("message two");
        log1.write("message three");
        
        ErrorLog log2 = ErrorLog.getInstance();
        log2.write("message four");
        log2.write("message five");
        log2.write("message six");
        
        ErrorLog log3 = ErrorLog.getInstance();
        log3.write("message seven");
        log3.write("message eight");
        log3.write("message nine");
        
        if(log1 == log2 && log2 == log3) {
            System.out.println("Logs are identical");
        }
        
        log3.print();
    }
}
