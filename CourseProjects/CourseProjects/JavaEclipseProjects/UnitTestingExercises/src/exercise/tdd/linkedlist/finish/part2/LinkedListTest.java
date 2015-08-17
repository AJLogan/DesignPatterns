package exercise.tdd.linkedlist.finish.part2;

import static org.junit.Assert.*;

import org.junit.*;

public class LinkedListTest {
	@Before
	public void setUp() {
		list = new LinkedList();
	}
	@Test
	public void newList() {
		assertTrue("List should have 0 size",list.size() == 0);
	}
	@Test
	public void addingSingleItem() {
		list.add("abc");
		assertEquals("Size should be 1",1,list.size());
	}
	@Test
	public void addingMultipleItems() {
		insertTestData();
		assertEquals("Size should be 3",3,list.size());
	}
	@Test
	public void removingFirstElement() throws Exception {
		list.add("abc");
		list.remove("abc");
		assertEquals("Size should be 0",0,list.size());
	}
	@Test
	public void removingLastElement() throws Exception {
		insertTestData();
		list.remove("ghi");
		assertEquals("Size should be 2",2,list.size());
	}
	@Test
	public void removeMiddleElement() throws Exception {
		insertTestData();
		list.remove("def");
		assertTrue("List should have 2 size",list.size() == 2);
	}
	@Test
	public void clearingContents() {
		insertTestData();
		list.clear();
		assertTrue("List should have 0 size",list.size() == 0);
	}
	@Test(expected=ListEmptyException.class)
	public void removeThrowsOnEmptyList() throws Exception {
		list.remove("def");
	}
	@Test(expected=ItemNotInListException.class)
	public void removeThrowsOnBadItemName() throws Exception {
		insertTestData();
		list.remove("zzz");
	}
	@Test
	public void getFirstItem() throws Exception {
		insertTestData();
		assertEquals("First item not found","abc",list.get(0));
	}
	@Test
	public void getLastItem() throws Exception {
		insertTestData();
		assertEquals("Last item not found","ghi",list.get(2));
	}
	@Test
	public void getMiddleItem() throws Exception {
		insertTestData();
		assertEquals("Middle item not found","def",list.get(1));
	}
	@Test(expected=ItemNotInListException.class)
	public void getThrowsOnInvalidIndex() throws Exception {
		insertTestData();
		list.get(100);
	}
	@Test(expected=ListEmptyException.class)
	public void testListEmptyExceptionForGet() throws Exception {
		list.get(100);
	}
	//helper method to populate list
	// NB multiple tests depend on the
	//  number and type of items added
	private void insertTestData() {
		list.add("abc");
		list.add("def");
		list.add("ghi");
	}
	private LinkedList list;
}
