package patterns.nullobject;

public class Launcher {
	public static void main(String[] args) throws Exception {
		Shop s = new Shop();
		Item [] purchases = { 
				new Item("AB12",3.20,2),
				new Item("CD34",4.80,2),
				new Item("EF56",5,1)
		};

		makePurchase(purchases, s.getSpecialOffer("Monday"));
		makePurchase(purchases, s.getSpecialOffer("Tuesday"));
	}
	private static void makePurchase(Item[] purchases, SpecialOffer specialOffer) {
		double cost = 0;
		for(int i=0;i<purchases.length;i++) {
			cost += purchases[i].price();
		}
		cost -= specialOffer.apply(purchases);
		System.out.println("Items purchased for: " + cost);
	}

}
