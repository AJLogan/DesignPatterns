package demos.strings;

public class StringConcatenation {
	public static void main(String[] args) {
		String[] data = {"ab","cd","ef","gh","ij","kl","mo","op","qr","st","uv","wx","yz"};

		long stringTime = timeStringConcatenation(data);
		long stringBufferTime = timeStringBufferConcatenation(data);
		long stringBuilderTime = timeStringBuilderConcatenation(data);

		System.out.println("Concatenating using String objects took: " + stringTime);
		System.out.println("Concatenating using a StringBuffer took: " + stringBufferTime);
		System.out.println("Concatenating using a StringBuilder took: " + stringBuilderTime);

	}
	private static long timeStringConcatenation(String[] data) {
		@SuppressWarnings("unused")
		String testString = new String("");

		long startTime = System.currentTimeMillis();
		for(int i=0;i<ITERATIONS;i++) {
			for(int x=0; x<data.length; x++) {
				testString += data[x];
			}
		}
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
	private static long timeStringBufferConcatenation(String[] data) {
		StringBuffer buffer = new StringBuffer();

		long startTime = System.currentTimeMillis();
		for(int i=0;i<ITERATIONS;i++) {
			for(int x=0; x<data.length; x++) {
				buffer.append(data[x]);
			}
		}
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
	private static long timeStringBuilderConcatenation(String[] data) {
		StringBuilder builder = new StringBuilder();

		long startTime = System.currentTimeMillis();
		for(int i=0;i<ITERATIONS;i++) {
			for(int x=0; x<data.length; x++) {
				builder.append(data[x]);
			}
		}
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
	private static final int ITERATIONS = 1000;
}
