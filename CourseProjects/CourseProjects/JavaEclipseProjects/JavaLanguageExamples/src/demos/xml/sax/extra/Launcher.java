package demos.xml.sax.extra;

import java.io.File;

public class Launcher {

	public static void main(String[] args) {
		File f = new File("input" + File.separator + "config.xml");
		if(!f.exists()) {
			System.out.println("Cannot find config.xml at: " + f.getPath());
			System.exit(0);
		}
		Configuration sc = null;

		try {
			sc = SystemConfiguration.getInstance(f.getPath());
		} catch(Exception ex) {
			System.out.println("Cannot create SAX parser: " + ex);
		}

		System.out.println("\n\nParsed config file and found:\n");
		System.out.println("Number of threads is:\t" + sc.queryThreads());
		System.out.println("Cache size is:\t\t" + sc.queryCacheSize());
		System.out.println("Server IP is:\t\t" + sc.queryServerIP());
		System.out.println("Debugging is:\t\t" + (sc.isDebugOn() ? "on" : "off"));
		System.out.println("Error logging is:\t" + (sc.isErrorLogOn() ? "on" : "off"));
		System.out.println("User dmccotter:\t\t" + (sc.userExists("dmccotter") ? "exists" : "does not exist"));
		System.out.println("User dmccotter:\t\t" + (sc.validateUser("dmccotter","chdje1d4") ? "is valid" : "is invalid"));
	}
}
