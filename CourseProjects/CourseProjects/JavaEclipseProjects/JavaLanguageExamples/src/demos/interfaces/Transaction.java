package demos.interfaces;

public interface Transaction {
	void start();
	void add(Resource r);
	void commit();
	void rollback();
}
