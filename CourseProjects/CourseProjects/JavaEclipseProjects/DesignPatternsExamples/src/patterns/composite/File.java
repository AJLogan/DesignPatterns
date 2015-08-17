package patterns.composite;

public class File extends Node {
    public File(String name, long size) {
        super(name);
        this.size = size;
    }
    public String toString() {
        return name + "(" + size + ")";
    }
    public long length() {
        return size;
    }
    protected void print(int depth) {
        printPrefix(depth);
        System.out.println(this);
    }
    private long size;
}
