package demos.io.files;

import java.io.File;
import java.util.Scanner;

public class ViewDirectoryStructureBasic {

	public static void main(String[] args) {
		System.out.println("Enter a folder to display its contents...");
		Scanner scanner = new Scanner(System.in);
		String directory = scanner.next();
		display(new File(directory),1);
	}
	private static void display(File file, int depth) {
		printArrows(depth);
		if(file.isDirectory()) {
			System.out.println("Directory " + file.getName() + " with contents:");
			for(File f : file.listFiles()) {
				display(f, depth + 1);
			}
		} else if(file.isFile()) {
			System.out.println("File " + file.getName() + " of size " + file.length());
		} else {
			System.out.println("Unknown resource called " + file.getAbsolutePath());
		}
	}
	private static void printArrows(int depth) {
		for (int i = 0; i < depth; i++) {
			System.out.print("-->");
		}
	}

}
