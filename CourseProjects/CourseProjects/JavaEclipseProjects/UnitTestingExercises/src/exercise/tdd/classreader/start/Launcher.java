package exercise.tdd.classreader.start;

import java.io.File;

public class Launcher {
	public static void main(String[] args) throws Exception {
		ClassFileReader reader = new ClassFileReader();
		reader.read(buildFilePath("exercise","tdd","classreader","start","MyTest.class"));
	}
	private static String buildFilePath(String ... parts) {
		StringBuilder result = new StringBuilder();
		for(String str : parts) {
			result.append(File.separator);
			result.append(str);
		}
		return result.toString();
	}
}
