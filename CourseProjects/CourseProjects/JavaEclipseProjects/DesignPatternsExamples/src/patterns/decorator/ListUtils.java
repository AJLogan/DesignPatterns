package patterns.decorator;

public class ListUtils {
    public static List makeThreadSafe(List list) {
        return new ThreadSafeList(list);
    }
}
