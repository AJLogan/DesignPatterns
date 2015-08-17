package patterns.singleton;

import java.util.*;

public class ErrorLog {
    private ErrorLog() {
        errors = new ArrayList<String>();
    }
    public void write(String error) {
        errors.add(error);
    }
    public void print() {
        Iterator<String> iter = errors.iterator();
        System.out.println("Errors are:");
        while(iter.hasNext()) {
            System.out.println("\t" + iter.next());
        }
    }
    public static synchronized ErrorLog getInstance() {
        if(instance == null) {
            instance = new ErrorLog();
        }
        return instance;
    }
    private List<String> errors;
    private static ErrorLog instance;
}
