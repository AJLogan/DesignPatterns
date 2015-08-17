package demos.xml.sax.extra;

public interface Configuration {
	int queryThreads();
	int queryCacheSize();
	String queryServerIP();
	boolean isDebugOn();
	boolean isErrorLogOn();
	boolean userExists(String id);
	boolean validateUser(String id, String password);
}