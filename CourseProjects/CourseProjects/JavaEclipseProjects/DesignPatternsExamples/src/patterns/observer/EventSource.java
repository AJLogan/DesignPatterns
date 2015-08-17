package patterns.observer;

import java.util.*;

public class EventSource {
    public EventSource() {
        handlers = new ArrayList<CustomListener>();
    }
    public void addCustomListener(CustomListener cl) {
        handlers.add(cl);
    }
    public void removeCustomListener(CustomListener cl) {
        handlers.remove(cl);
    }
    public void triggerEvent() {
        Iterator<CustomListener> iter = handlers.iterator();
        EventObject event = new EventObject(this);
        while(iter.hasNext()) {
            CustomListener cl = iter.next();
            cl.callbackMethod(event);
        }
    }
    private List<CustomListener> handlers;
}
