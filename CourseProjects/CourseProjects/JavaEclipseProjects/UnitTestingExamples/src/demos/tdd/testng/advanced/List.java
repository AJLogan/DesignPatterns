package demos.tdd.testng.advanced;

public interface List<T> {
	int size();
	void clear();
	void add(T value);
	void addAll(T ...values);
	void remove(T value) throws ListEmptyException, ItemNotInListException;
	T get(int index) throws ListEmptyException, ItemNotInListException;
}
