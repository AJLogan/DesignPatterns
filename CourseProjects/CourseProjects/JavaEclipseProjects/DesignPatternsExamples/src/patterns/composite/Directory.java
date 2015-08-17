package patterns.composite;

import java.util.*;

public class Directory extends Node {
    public Directory(String name) {
        super(name);
        contents = new ArrayList<Node>();
    }
    public void add(Node n) {
        contents.add(n);
    }
    public Node[] contents() {
        Node[] stuff = new Node[contents.size()];
        return contents.toArray(stuff);
    }
    public long length() {
        long total = 0;
        Node[] content = contents();
        for(int i=0;i<content.length;i++) {
            total += content[i].length();
        }
        return total;
    }
    protected void print(int depth) {
        printPrefix(depth);
        depth++;
        System.out.println(toString() + ":");
        Node[] content = contents();
        for(int i=0;i<content.length;i++) {
            content[i].print(depth);
        }
    }
    private List<Node> contents;
}
