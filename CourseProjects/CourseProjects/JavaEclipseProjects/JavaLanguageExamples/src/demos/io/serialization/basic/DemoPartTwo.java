package demos.io.serialization.basic;

import java.io.*;
import java.util.Scanner;

public class DemoPartTwo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("Enter the file to read the object from:");
		Scanner scanner = new Scanner(System.in);
		
		File f = new File(scanner.nextLine());
		ObjectInputStream is = new ObjectInputStream(new FileInputStream(f));
		Object obj = is.readObject();
		System.out.println(obj.toString());
		is.close();

	}

}
