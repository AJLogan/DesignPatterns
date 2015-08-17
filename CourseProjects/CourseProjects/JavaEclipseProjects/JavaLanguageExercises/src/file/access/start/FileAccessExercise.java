package file.access.start;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileAccessExercise {
	public static void main(String[] args) throws Exception  {
		String inputFile = "input" + File.separator + "shakespeare.txt";
		File file = new File(inputFile);
		if(!file.canRead()) {
			System.out.println("Cant read: " + file.getAbsolutePath());
			return;
		}
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String current;
		while(null != (current = reader.readLine())) {
			System.out.print(">> ");
			System.out.println(current);
		}
		reader.close();
	}

}
