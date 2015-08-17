package patterns.state;

import javax.transaction.xa.*;

public class DBMS implements XAResource {
    public int getTransactionTimeout() throws XAException {
        return 0;
    }
    public boolean setTransactionTimeout(int arg0) throws XAException {
        return false;
    }
    public boolean isSameRM(XAResource arg0) throws XAException {
        return false;
    }
    public Xid[] recover(int arg0) throws XAException {
        return null;
    }
    public int prepare(Xid arg0) throws XAException {
        return 0;
    }
    public void forget(Xid arg0) throws XAException {
    }
    public void rollback(Xid arg0) throws XAException {
    }
    public void end(Xid arg0, int arg1) throws XAException {
    }
    public void start(Xid arg0, int arg1) throws XAException {
    }
    public void commit(Xid arg0, boolean arg1) throws XAException {
    }
}
