/*
 * Created on Sep 18, 2003
 *
 */
package demos.generics.list;

import junit.framework.TestCase;

/**
 * @author Garth Gilmour
 *
 */
public class TestListForString extends TestCase {
	//called before each test method
	protected void setUp() {
		list = new LinkedList<String>();
	}
	public void testNewList() {
		assertTrue("List should have 0 size",list.size() == 0);
	}
	public void testAddingSingleItem() {
		list.add("abc");
		assertEquals("Size should be 1",1,list.size());
	}
	public void testAddingMultipleItems() {
		insertTestData();
		assertEquals("Size should be 3",3,list.size());
	}
	public void testAddAll() {
		list.addAll("aaa","bbb","ccc","ddd","eee");
		assertEquals("Size should be 5",5,list.size());
	}
	public void testRemovingFirstElement() throws ListEmptyException, ItemNotInListException {
		list.add("abc");
		list.remove("abc");
		assertEquals("Size should be 0",0,list.size());
	}
	public void testRemovingLastElement() throws ListEmptyException, ItemNotInListException {
		insertTestData();
		list.remove("ghi");
		assertEquals("Size should be 2",2,list.size());
	}
	public void testRemoveMiddleElement() throws ListEmptyException, ItemNotInListException {
		insertTestData();
		list.remove("def");
		assertTrue("List should have 2 size",list.size() == 2);
	}
	public void testClear() {
		insertTestData();
		list.clear();
		assertTrue("List should have 0 size",list.size() == 0);
	}
	public void testListEmptyExceptionForRemove() throws ItemNotInListException {
		try {
			list.remove("def");
			fail("ListEmptyException should have been thrown");
		} catch(ListEmptyException ex) {
			//expected - do nothing
		}
	}
	public void testItemNotInListExceptionForRemove() throws ListEmptyException {
		insertTestData();
		try {
			list.remove("zzz");
			fail("ItemNotInListException should have been thrown");
		} catch(ItemNotInListException ex) {
			//expected - do nothing
		}
	}
	public void testGetFirstItem() throws ListEmptyException, ItemNotInListException {
		insertTestData();
		assertEquals("First item not found","abc",list.get(0));
	}
	public void testGetLastItem() throws ListEmptyException, ItemNotInListException {
		insertTestData();
		assertEquals("Last item not found","ghi",list.get(2));
	}
	public void testGetMiddleItem() throws ListEmptyException, ItemNotInListException {
		insertTestData();
		assertEquals("Middle item not found","def",list.get(1));
	}
	public void testItemNotInListExceptionForGet() throws ListEmptyException {
		insertTestData();
		try {
			list.get(100);
			fail("ItemNotInListException should have been thrown");
		} catch(ItemNotInListException ex) {
			//expected - do nothing
		}
	}
	public void testListEmptyExceptionForGet() throws ItemNotInListException {
		try {
			//no elements added to list
			list.get(100);
			fail("ListEmptyException should have been thrown");
		} catch(ListEmptyException ex) {
			//expected - do nothing
		}
	}
	//helper method to populate list
	// NB multiple tests depend on the
	//  number and type of items added
	private void insertTestData() {
		list.add("abc");
		list.add("def");
		list.add("ghi");
	}
	private List<String> list;
}
