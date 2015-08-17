package demos.tdd.testng.basic;

public class Math {
	public Math(int no1, int no2) {
		if (no1 == 0 || no2 == 0) {
			throw new IllegalArgumentException("Zero not allowed");
		}
		this.no1 = no1;
		this.no2 = no2;
	}
	public int add() {
		return no1 + no2;
	}
	public int subtract() {
		return no1 - no2;
	}
	public int multiply() {
		return no1 * no2;
	}
	private int no1;
	private int no2;
}