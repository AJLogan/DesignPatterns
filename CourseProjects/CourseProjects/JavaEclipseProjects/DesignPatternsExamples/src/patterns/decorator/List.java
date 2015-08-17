package patterns.decorator;

public interface List {
   void add(Object item);
   Object get(int index);
   boolean exists(Object item);
   int find(Object item);
   void remove(Object item);
   void remove(int index);
}
