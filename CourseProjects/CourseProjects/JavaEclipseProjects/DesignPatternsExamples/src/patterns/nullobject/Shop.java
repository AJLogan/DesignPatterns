package patterns.nullobject;

public class Shop {
	SpecialOffer getSpecialOffer(String day) {
		if(day.equals("Monday")) {
			return new DiscountSpecialOffer(10);
		} else {
			return new NullSpecialOffer();
		}
	}
}
