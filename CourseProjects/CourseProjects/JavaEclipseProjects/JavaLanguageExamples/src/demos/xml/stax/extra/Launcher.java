package demos.xml.stax.extra;

import java.io.File;

public class Launcher {
    public static void main(String[] args) throws Exception {
		StAXDemo demo = new StAXDemo("output" + File.separator + "config.xml");
		demo.process();
		demo.displayUsers();
	}
}
