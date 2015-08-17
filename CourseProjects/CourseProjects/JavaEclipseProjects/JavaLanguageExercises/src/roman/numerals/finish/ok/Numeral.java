package roman.numerals.finish.ok;

class Numeral {
	Numeral(int value, String numeral) {
		super();
		this.value = value;
		this.numeral = numeral;
	}
	public String getNumeral() {
		return numeral;
	}
	public int getValue() {
		return value;
	}
	private int value;
	private String numeral;
}
