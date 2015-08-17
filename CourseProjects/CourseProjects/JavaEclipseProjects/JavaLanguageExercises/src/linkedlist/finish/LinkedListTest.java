package linkedlist.finish;

import static org.junit.Assert.*;
import org.junit.*;


public class LinkedListTest {
	@Before
	public void start() {
		list = new LinkedList();
	}
	@Test
	public void newListIsEmpty() {
		assertTrue("List should have 0 size",list.size() == 0);
	}
	@Test
	public void singleItemsCanBeAdded() {
		list.add("abc");
		assertEquals("Size should be 1",1,list.size());
	}
	@Test
	public void multipleItemsCanBeAdded() {
		insertTestData();
		assertEquals("Size should be 3",3,list.size());
	}
	@Test
	public void firstItemCanBeRemoved() throws ListEmptyException, ItemNotInListException {
		list.add("abc");
		list.remove("abc");
		assertEquals("Size should be 0",0,list.size());
	}
	@Test
	public void lastItemCanBeRemoved() throws ListEmptyException, ItemNotInListException {
		insertTestData();
		list.remove("ghi");
		assertEquals("Size should be 2",2,list.size());
	}
	@Test
	public void itemsCanBeRemovedFromMiddle() throws ListEmptyException, ItemNotInListException {
		insertTestData();
		list.remove("def");
		assertTrue("List should have 2 size",list.size() == 2);
	}
	@Test
	public void listCanBeCleared() {
		insertTestData();
		list.clear();
		assertTrue("List should have 0 size",list.size() == 0);
	}
	@Test(expected=ListEmptyException.class)
	public void removingFromEmptyListThrows() throws Exception {
		list.remove("def");
	}
	@Test(expected=ItemNotInListException.class)
	public void removingUnknownItemsThrows() throws Exception {
		insertTestData();
		list.remove("zzz");
	}
	@Test
	public void firstItemCanBeFound() throws ListEmptyException, ItemNotInListException {
		insertTestData();
		assertEquals("First item not found","abc",list.get(0));
	}
	@Test
	public void lastItemCanBeFound() throws ListEmptyException, ItemNotInListException {
		insertTestData();
		assertEquals("Last item not found","ghi",list.get(2));
	}
	@Test
	public void itemsCanBeFoundInMiddle() throws ListEmptyException, ItemNotInListException {
		insertTestData();
		assertEquals("Middle item not found","def",list.get(1));
	}
	@Test(expected=ItemNotInListException.class)
	public void invalidIndexThrows() throws Exception {
		insertTestData();
		list.get(100);
	}
	@Test(expected=ListEmptyException.class)
	public void getOnEmptyListThrows() throws Exception {
		//no elements added to list
		list.get(100);
	}
	private void insertTestData() {
		insertTestData("abc","def","ghi");
	}
	private void insertTestData(String ... items) {
		for(String str: items) {
			list.add(str);
		}
	}
	private LinkedList list;
}
