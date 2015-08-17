package patterns.state;

public class ClosedState extends State {
    public void enter(Transaction t) {
        super.enter(t);
    }
    public void exit(Transaction t) {
        super.exit(t);
    }
}
