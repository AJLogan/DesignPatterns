package demos.generics.list;

public interface List<T> {
	int size();
	void clear();
	void add(T value);
	void addAll(T ...values);
	void remove(T value) throws ListEmptyException, ItemNotInListException;
	T get(int index) throws ListEmptyException, ItemNotInListException;
}