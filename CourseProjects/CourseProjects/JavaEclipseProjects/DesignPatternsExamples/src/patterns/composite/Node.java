package patterns.composite;

public abstract class Node { 
    public Node(String name) {
        super();
        this.name = name;
    }
    public String toString() {
        return name;
    }
    public void print() {
        print(0);
    }
    public abstract long length();
    protected abstract void print(int depth);
    protected void printPrefix(int depth) {
        for(int i=0;i<depth;i++) {
            System.out.print("----");
        }
        System.out.print("->");
    }
    protected String name;
}
