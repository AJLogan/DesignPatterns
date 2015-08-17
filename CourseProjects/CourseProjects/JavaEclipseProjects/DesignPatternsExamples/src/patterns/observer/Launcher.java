package patterns.observer;


public class Launcher {
    public static void main(String[] args) {
        EventSource source = new EventSource();
        for(int i=0;i<listeners.length;i++) {
            source.addCustomListener(listeners[i]);
        }
        source.triggerEvent();
    }
    private static CustomListener [] listeners = {
													new FirstCustomListenerImpl("listener one"),
													new FirstCustomListenerImpl("listener two"),
													new FirstCustomListenerImpl("listener three"),
													new SecondCustomListenerImpl("listener four"),
													new SecondCustomListenerImpl("listener five"),
													new SecondCustomListenerImpl("listener six")
												  };
}
