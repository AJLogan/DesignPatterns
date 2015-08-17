package patterns.observer;

import java.util.EventObject;

public class SecondCustomListenerImpl implements CustomListener {
    public SecondCustomListenerImpl(String name) {
        this.name = name;
    }
    public void callbackMethod(EventObject obj) {
        System.out.println("SecondCustomListenerImpl.callbackMethod called on " + name);
    }
    private String name;
}
