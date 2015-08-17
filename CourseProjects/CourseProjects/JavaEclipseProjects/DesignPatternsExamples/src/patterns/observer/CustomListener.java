package patterns.observer;

import java.util.*;

public interface CustomListener extends EventListener {
    void callbackMethod(EventObject obj);
}
