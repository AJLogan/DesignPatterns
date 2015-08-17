package demos.procedural;

@SuppressWarnings("unused")
public class Conversions {

	public static void main(String[] args) {
		String strInt = "123";
		String strFloat = "12.345";
		String strBoolean = "true";
		
		int intVal = Integer.parseInt(strInt);
		float floatVal = Float.parseFloat(strFloat);
		boolean booleanVal = Boolean.valueOf(strBoolean).booleanValue();
		boolean booleanVal2 = new Boolean(strBoolean).booleanValue();
		
		intVal += 1;
		floatVal += 1;
		booleanVal = !booleanVal;
		
		strInt = String.valueOf(intVal);
		strFloat = String.valueOf(floatVal);
		strBoolean = String.valueOf(booleanVal);
		
		System.out.println("Results are: " + strInt + " " + strFloat + " " + strBoolean);
		
	}
}
