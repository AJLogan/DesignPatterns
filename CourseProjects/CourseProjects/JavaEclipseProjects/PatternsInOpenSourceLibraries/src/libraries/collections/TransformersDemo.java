package libraries.collections;

import java.util.*;
import org.apache.commons.collections.*;
import org.apache.commons.collections.functors.*;

@SuppressWarnings({"rawtypes","unchecked"})
public class TransformersDemo {

	public static void main(String[] args) {
		demoInvokeTransformer();
		demoChainedTransformer();	
	}
	private static void demoChainedTransformer() {
		List integersList = buildIntegersList();
		String msg = " sample message";
		Transformer chain = buildChainedTransformer(msg);
		Collection newList = CollectionUtils.collect(integersList,chain);
		printCollection(newList,"Chained Transformer");
	}
	private static Transformer buildChainedTransformer(String msg) {
		Transformer t1 = StringValueTransformer.getInstance();
		Transformer t2 = InvokerTransformer.getInstance("concat",new Class[]{String.class},new Object[]{msg});
		return ChainedTransformer.getInstance(new Transformer[]{t1,t2});
	}
	private static void demoInvokeTransformer() {
		List stringsList = buildStringsList();
		Collection stringLengths = createCollectionOfStringLengths(stringsList);
		printCollection(stringLengths,"Invoke Transformer");
	}
	private static Collection createCollectionOfStringLengths(List firstList) {
		Transformer t = InvokerTransformer.getInstance("length");
		return CollectionUtils.collect(firstList,t);
	}
	private static void printCollection(Collection c, String title) {
		System.out.println("\n----- Start of " + title + " -----");
		Iterator i = c.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		System.out.println("----- End of " + title + " -----\n");
	}
	private static List buildStringsList() {
		List list = new ArrayList();
		list.add("ab");
		list.add("cde");
		list.add("fghi");
		list.add("jklmo");
		list.add("opqrst");
		list.add("uvwxyza");
		list.add("bcdefghi");
		return list;
	}
	private static List buildIntegersList() {
		List list = new ArrayList();
		list.add(new Integer(20));
		list.add(new Integer(30));
		list.add(new Integer(40));
		list.add(new Integer(50));
		list.add(new Integer(60));
		list.add(new Integer(70));
		list.add(new Integer(80));
		return list;
	}
}
