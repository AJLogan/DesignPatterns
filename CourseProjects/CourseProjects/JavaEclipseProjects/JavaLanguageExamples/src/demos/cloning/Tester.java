package demos.cloning;

public class Tester {

	public static void main(String[] args) {
		try {
			ShallowClone shallowOriginal = new ShallowClone("abcdefg");
			ShallowClone shallowCopy = (ShallowClone)shallowOriginal.clone();

			shallowOriginal.change("hijklmnop");

			System.out.println("Shallow: " + shallowOriginal + " " + " " + shallowCopy);

			DeepClone deepOriginal = new DeepClone("abcdefg");
			DeepClone deepCopy = (DeepClone)deepOriginal.clone();

			deepOriginal.change("hijklmnop");

			System.out.println("Deep: " + deepOriginal + " " + " " + deepCopy);

		}catch(CloneNotSupportedException ex) {
			System.out.println(ex);
		}
	}

}






