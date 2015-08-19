package patterns.proxy;

import java.lang.reflect.*;

public class Launcher {
	public static void main(String[] args) {
		Object proxy = buildProxy();

		Maths maths = (Maths) proxy;
		System.out.println(maths.add(2, 3));
		System.out.println(maths.multiply(2, 3));
		System.out.println(maths.subtract(2, 3));
		System.out.println(maths.divide(2, 3));

		Words words = (Words) proxy;
		System.out.println("Concatenate: " + words.concatenate("a", "B"));

		Finance finance = (Finance) proxy;
		System.out.println(finance.calculateVat(200));
		System.out.println(finance.calculateTax(200));

	}

	private static Object buildProxy() {
		ClassLoader loader = Maths.class.getClassLoader();
		Class<?>[] interfaces = new Class[] { Maths.class, Finance.class, Words.class };
		ProxyImpl implementation = new ProxyImpl();
		return Proxy.newProxyInstance(loader, interfaces, implementation);
	}
}
