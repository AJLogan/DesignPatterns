package linkedlist.start;

import static org.junit.Assert.*;
import org.junit.*;


public class LinkedListTest {
	@Before
	public void start() throws Exception {
		list = new LinkedList();
	}
	@Test
	public void newListShouldBeEmpty() {
		assertTrue("list should be empty",list.isEmpty());
		assertEquals("size should be 0",0,list.size());
	}
	@Test
	public void nonEmptyLisHasItemst() {
		addTestData();
		assertFalse("list should NOT be empty",list.isEmpty());
		assertEquals("size should be 5",5,list.size());
	}
	@Test
	public void singleItemsCanBeRetrieved() {
		list.add("abc");
		assertEquals("Item not found","abc",list.get(0));
	}
	@Test
	public void multipleItemsCanBeRetrieved() {
		addTestData();
		assertEquals("Item 1 not found","abc",list.get(0));
		assertEquals("Item 2 not found","def",list.get(1));
		assertEquals("Item 3 not found","ghi",list.get(2));
		assertEquals("Item 4 not found","jkl",list.get(3));
		assertEquals("Item 5 not found","mno",list.get(4));
	}
	private void addTestData() {
		String[] data = {"abc","def","ghi","jkl","mno"};
		for(String s:  data) {
			list.add(s);
		}
	}
	private LinkedList list;
}
