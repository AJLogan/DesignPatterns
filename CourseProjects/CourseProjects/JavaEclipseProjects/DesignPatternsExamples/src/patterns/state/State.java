package patterns.state;

public class State {
    public void enter(Transaction t) {
        System.out.println("Just entered: " + getClass().getName());
    }
    public void exit(Transaction t) {
        System.out.println("Just exited: " + getClass().getName());
    }
    public boolean canCommit() {
        return true;
    }
}
