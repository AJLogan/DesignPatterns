package patterns.nullobject;

public class DiscountSpecialOffer extends SpecialOffer {
	public DiscountSpecialOffer(int discount) {
		this.discount = discount;
	}
	public double apply(Item[] purchases) {
		double cost = 0;
		for(int i=0;i<purchases.length;i++) {
			cost += purchases[i].price();
		}
		return cost * discount / 100;
	}
	private int discount;
}
