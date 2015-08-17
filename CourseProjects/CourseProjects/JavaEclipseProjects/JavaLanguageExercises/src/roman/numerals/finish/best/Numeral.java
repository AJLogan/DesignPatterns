package roman.numerals.finish.best;

public class Numeral {
	private final static Numeral[] numerals = {
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
	private int apply(int number, StringBuffer buffer) {
		int times = number / value;
		if(times > 0) {
			for(int i=0;i<times;i++) {
				buffer.append(numeral);
			}
			return number % value;
		} else {
			return number;
		}
	}
	public static String convert(int val) {
		StringBuffer result = new StringBuffer();
		for(Numeral numeral : numerals) {
			val = numeral.apply(val,result);
		}
		return result.toString();
	}
	private String numeral;
	private int value;
}
