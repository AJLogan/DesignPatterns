package exercises.fp.lambdas.loans.finish;

import java.io.File;

import static exercises.fp.lambdas.loans.finish.FileUtils.doWithFileWriter;

public class Program {
	public static void main(String[] args) {
		File validPath = new File("output/loansSolution.txt");
		File invalidPath = new File("~/nonsense/foo.txt");
		
		doWithFileWriter(validPath, () -> "wibble", (ex) -> System.err.println(ex.getMessage()));
		doWithFileWriter(validPath, Program::helper, (ex) -> System.err.println(ex.getMessage()));
		
		doWithFileWriter(invalidPath, () -> "wobble", (ex) -> System.err.println(ex.getMessage()));
		doWithFileWriter(invalidPath, () -> "wobble", Program::handler);
		doWithFileWriter(invalidPath, Program::helper, Program::handler);
		
		System.out.println("All done...");
	}
	private static String helper() {
		return "supercalafragilisticexpyalidotious";
	}
	private static void handler(Exception ex) {
		System.err.println("Cant write to file because: " + ex.getMessage());
	}
}
