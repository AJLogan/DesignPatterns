package roman.numerals.finish.better;

public class Numeral {
	public final static Numeral[] numerals = {
		new Numeral("C",100),
		new Numeral("XC",90),
		new Numeral("L",50),
		new Numeral("XL",40),
		new Numeral("X",10),
		new Numeral("IX",9),
		new Numeral("V",5),
		new Numeral("IV",4),
		new Numeral("I",1)
	};
	private Numeral(String numeral, int value) {
		super();
		this.numeral = numeral;
		this.value = value;
	}
	String apply(int number) {
		int times = number / value;
		if(times == 0) {
			return "";
		} else {
			String retval = numeral;
			for(int i=1;i<times;i++) {
				retval += numeral;
			}
			return retval;
		}
	}
	public int remainder(int number) {
		return number % value;
	}
	private String numeral;
	private int value;
}
