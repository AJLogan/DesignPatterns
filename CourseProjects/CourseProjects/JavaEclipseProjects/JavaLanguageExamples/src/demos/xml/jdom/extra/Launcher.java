package demos.xml.jdom.extra;

import java.io.*;

public class Launcher {
	public static void main(String[] args) {
		ConfigFile config = new ConfigFile();
		String fileName = "output" + File.separator + "config.xml";
		buildConfigFile(config);
		try {
			config.saveDoc(fileName);
		} catch (IOException ex) {
			System.out.println("Saving file failed with: " + ex);
		}
		System.out.println("Output saved to: " + fileName);
	}
	private static void buildConfigFile(ConfigFile file) {
		file.addResources("7","192.168.1.36","32");
		file.addErrorLog("on","high","file","errors.txt");
		file.addDebugLog("off","medium","file","debug.txt");
		file.addAccount("power-user","Dave","wn1hgb");
		file.addAccount("end-user","Fred","010978");
	}
}
