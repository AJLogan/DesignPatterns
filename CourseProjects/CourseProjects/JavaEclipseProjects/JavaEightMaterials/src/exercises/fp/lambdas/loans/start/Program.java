package exercises.fp.lambdas.loans.start;

import java.io.File;

import static exercises.fp.lambdas.loans.start.FileUtils.doWithFileWriter;

public class Program {
	public static void main(String[] args) {
		File validPath = new File("output/loansExercise.txt");
		File invalidPath = new File("~/nonsense/foo.txt");
		
		doWithFileWriter(validPath, () -> "wibble");
		doWithFileWriter(validPath, Program::helper);
		doWithFileWriter(invalidPath, () -> "wobble");
		
		System.out.println("All done...");
	}
	private static String helper() {
		return "supercalafragilisticexpyalidotious";
	}
}
