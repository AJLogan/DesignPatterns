package patterns.decorator;

public class ThreadSafeList implements List {
    public ThreadSafeList(List list) {
        wrappedList = list;
    } 
    public void add(Object item) {
        synchronized(wrappedList) {
            wrappedList.add(item);
        }
    }
    public Object get(int index) {
        synchronized(wrappedList) {
            return wrappedList.get(index);
        }
    } 
    public boolean exists(Object item) {
        synchronized(wrappedList) {
            return wrappedList.exists(item);
        }
    }
    public int find(Object item) {
        synchronized(wrappedList) {
            return wrappedList.find(item);
        }
    }
    public void remove(Object item) {
        synchronized(wrappedList) {
            wrappedList.remove(item);
        }
    }
    public void remove(int index) {
        synchronized(wrappedList) {
            wrappedList.remove(index);
        }
    }
    List wrappedList;
}
