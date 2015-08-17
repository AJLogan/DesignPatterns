package patterns.decorator;

public class ListImpl implements List {
    public void add(Object item) {
        System.out.println("ListImpl.add");
    }
    public Object get(int index) {
        System.out.println("ListImpl.get");
        return null;
    }
    public boolean exists(Object item) {
        System.out.println("ListImpl.exists");
        return false;
    }
    public int find(Object item) {
        System.out.println("ListImpl.find");
        return 0;
    }
    public void remove(Object item) {
        System.out.println("ListImpl.remove(Object)");
    }
    public void remove(int index) {
        System.out.println("ListImpl.remove(int)");
    }
}
