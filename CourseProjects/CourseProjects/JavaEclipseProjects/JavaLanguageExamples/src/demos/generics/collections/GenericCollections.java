package demos.generics.collections;

import java.util.*;

public class GenericCollections {

	public static void main(String[] args) {
		demoGenericList();
		demoGenericMap();
	}

	private static void demoGenericMap() {
		Map<String,Employee> staff = new HashMap<String,Employee>();
		
		staff.put("ABC123",new Employee("ABC123","Joe Bloggs",20000));
		staff.put("DEF456",new Employee("DEF456","Fred Bloggs",30000));
		staff.put("GHI789",new Employee("GHI789","Dave Bloggs",40000));
		staff.put("JKL012",new Employee("JKL012","Peter Bloggs",50000));
		
		System.out.println("Map<String,Employee> contents are: ");
		Set<Map.Entry<String,Employee>> contents = staff.entrySet();
		for(Map.Entry<String,Employee> entry : contents) {
			System.out.println(entry.getKey() + " indexes " + entry.getValue());
		}
	}

	private static void demoGenericList() {
		List<String> strList = new LinkedList<String>();
		strList.add("abc");
		strList.add("def");
		strList.add("ghi");
		strList.add("jkl");
		strList.add("mno");
		strList.add("pqr");
		strList.add("stu");
		
		System.out.println("LinkedList<String> contents are: ");
		//NB no cast required
		for(String str : strList) {
			System.out.println(str);
		}
	}

}
