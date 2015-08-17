package demos.guava.brandnew.collections;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

public class DemoNewCollections {
	public static void main(String[] args) {
		demoMultimap();
		demoBiMap();
	}
	private static void demoBiMap() {
		BiMap<String,Manager> biMap = HashBiMap.create();
		
		biMap.put("IT", new Manager("Jane"));
		biMap.put("HR", new Manager("Pete"));
		biMap.put("Accounts", new Manager("Susan"));
		biMap.put("Sales", new Manager("Dave"));
		
		try {
			biMap.put("Test", new Manager("Pete"));
		} catch(IllegalArgumentException ex) {
			System.out.println("BiMaps cant contain duplicate values!");
		}
		
		BiMap<Manager, String> inverted = biMap.inverse();
		System.out.println("Contents of inverted BiMap are:");
		for(Manager m : inverted.keySet()) {
			System.out.printf("\t%s indexes %s\n", m, inverted.get(m));
		}
	}
	private static void demoMultimap() {
		Multimap<String,String> multimap = ArrayListMultimap.create();
		multimap.get("scifi").addAll(Lists.newArrayList("Aliens","Dune","The Matrix","2010"));
		multimap.get("comedy").addAll(Lists.newArrayList("The Birdcage","A Fish Called Wanda","Dodgeball","Dr Strangelove"));
		multimap.get("action").addAll(Lists.newArrayList("Commando","Taken","The Bourne Identity","Casino Royale"));
		
		System.out.println("Contents of Multimap are:");
		for(String key : multimap.keySet()) {
			System.out.printf("\t'%s' indexes:\n\t\t", key);
			for(String value : multimap.get(key)) {
				System.out.printf("'%s' ", value);
			}
			System.out.println();
		}
	}

}
