package demos.tdd.self.shunt;

public class Item {
	public Item(String name) {
		super();
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Item) {
			return ((Item)obj).name.equals(name);
		} else {
			return false;
		}
	}
	@Override
	public String toString() {
		return "Item holding: " + name;
	}

	private String name;
}
