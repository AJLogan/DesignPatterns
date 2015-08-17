package patterns.observer;

import java.util.EventObject;

public class FirstCustomListenerImpl implements CustomListener {
    public FirstCustomListenerImpl(String name) {
        this.name = name;
    }
    public void callbackMethod(EventObject obj) {
        System.out.println("FirstCustomListenerImpl.callbackMethod called on " + name);
    }
    private String name;
}
