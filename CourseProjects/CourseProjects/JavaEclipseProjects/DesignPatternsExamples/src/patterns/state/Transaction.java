package patterns.state;

import javax.transaction.xa.XAResource;

public class Transaction {
    public Transaction() {
        changeState(new EmptyState());
    }
    public void addResource(XAResource resource) {
        if(state instanceof EmptyState) {
            changeState(new OpenState());
        }
    }
    public void setRollbackOnly() {
        changeState(new RollbackOnlyState());
    }
    public void rollback() {
        changeState(new ClosedState());
    }
    public void commit() {
        if(state instanceof RollbackOnlyState) {
            changeState(new ClosedState());
        } else {
            changeState(new CommittedState());
        }
    }
    private void changeState(State newState) {
        if(state != null) {
            state.exit(this);
        }
        state = newState;
        state.enter(this);
    }
    private State state;
}
