package file.access.finish;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileAccessSolution {
	public static void main(String[] args) throws Exception  {
		String inputFile = "input" + File.separator + "shakespeare.txt";
		String outputFile = "output" + File.separator + "results.txt";
		File file = new File(inputFile);
		if(!file.canRead()) {
			System.out.println("Cant read: " + file.getAbsolutePath());
			return;
		}
		BufferedReader reader = new BufferedReader(new FileReader(file));
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
		String current;
		while(null != (current = reader.readLine())) {
			System.out.print(">> ");
			writer.write(">> ");
			System.out.println(current);
			writer.write(current);
			writer.newLine();
		}
		reader.close();
		writer.close();
	}
}
