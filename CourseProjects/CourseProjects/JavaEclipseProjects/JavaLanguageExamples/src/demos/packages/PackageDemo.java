package demos.packages;

//legal but never required
//import java.lang.*;

//import a type by its fully qualified name
import demos.packages.packageA.MyClassA;

//import all public types within a package
import demos.packages.packageB.*;

//public classes can be seen outside the package
public class PackageDemo {

	MyClassA mca = new MyClassA();	//explicitly brought in
	MyClassB mcb = new MyClassB();	//available via second import statement

	//explicitly declare class name in code
	demos.packages.packageC.MyClassC mcc
								= new demos.packages.packageC.MyClassC();

	public static void main(String[] args) {
		System.out.println("Application works!");
	}
}
