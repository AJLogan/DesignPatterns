package demos.tdd.self.shunt;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.*;

public class ItemsManagerTest implements ItemsList {
	@Before
	public void start() {
		list = new LinkedList<Item>();
		manager = new ItemsManager(this);
	}
	@Test
	public void addingUniqueElement() {
		String value = "test1";
		manager.add(value);
		assertEquals(list.size(),1);
		assertEquals(new Item(value), list.get(0));
	}
	@Test
	public void addingNonUniqueElement() {
		String value = "test1";
		manager.add(value);
		manager.add(value);
		assertEquals(list.size(),1);
		assertEquals(new Item(value), list.get(0));
	}
	public void add(Item item) {
		list.add(item);
	}
	public boolean exists(Item item) {
		return list.contains(item);
	}
	private List<Item> list;
	private ItemsManager manager;
}
