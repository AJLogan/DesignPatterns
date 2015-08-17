package patterns.nullobject;

public class Item {
	public Item(String catalogNo, double unitPrice, int quantity) {
		super();
		this.catalogNo = catalogNo;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}
	public double price() {
		return unitPrice * quantity;
	}
	@Override
	public String toString() {
		return catalogNo + ", " + quantity + " at " + unitPrice;
	}
	private String catalogNo;
	private double unitPrice;
	private int quantity;
}
