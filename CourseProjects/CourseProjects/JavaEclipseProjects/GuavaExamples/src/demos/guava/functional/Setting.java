package demos.guava.functional;

public class Setting {
	public Setting(String value) {
		this.value = value;
	}
	public String toString() {
		return value.toUpperCase();
	}
	private String value;
}
