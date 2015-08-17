package demos.tdd.testng.advanced;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LinkedListTest {
	private static final int NUM_VALUES = 10000;
	
	@BeforeMethod(alwaysRun=true)
	public void start() {
		values = new String[NUM_VALUES];
		list = new LinkedList<String>();
		populatedList = new LinkedList<String>();
		for(int i=0;i<NUM_VALUES;i++) {
			values[i] = "test " + i;
			populatedList.add("initial " + i);
		}
	}
	@Test(groups={"basic"})
	public void newList() {
		assertTrue(list.size() == 0);
	}
	@Test(groups={"basic","inserts"})
	public void addSingleItem() {
		list.add("abc");
		assertEquals(1,list.size());
	}
	@Test(groups={"basic","inserts"})
	public void addMultipleItems() {
		insertTestData();
		assertEquals(3,list.size());
	}
	@Test(groups={"basic","inserts"})
	public void addViaVarArg() {
		list.addAll("aaa","bbb","ccc","ddd","eee");
		assertEquals(5,list.size());
	}
	@Test(groups={"basic","deletes"})
	public void removeFirstItem() throws Exception {
		list.add("abc");
		list.remove("abc");
		assertEquals(0,list.size());
	}
	@Test(groups={"basic","deletes"})
	public void removeLastItem() throws Exception {
		insertTestData();
		list.remove("ghi");
		assertEquals(2,list.size());
	}
	@Test(groups={"basic","deletes"})
	public void removeMiddleItem() throws Exception {
		insertTestData();
		list.remove("def");
		assertTrue(list.size() == 2);
	}
	@Test(groups={"basic","deletes"})
	public void clear() {
		insertTestData();
		list.clear();
		assertTrue(list.size() == 0);
	}
	@Test(groups={"errors","deletes"}, expectedExceptions={ListEmptyException.class})
	public void removeFromEmptyListFails() throws Exception {
		list.remove("def");
	}
	@Test(groups={"errors","deletes"}, expectedExceptions={ItemNotInListException.class})
	public void removeUnknownItemFails() throws Exception {
		insertTestData();
		list.remove("zzz");
	}
	@Test(groups={"basic","retrievals"})
	public void getFirstItem() throws ListEmptyException, ItemNotInListException {
		insertTestData();
		assertEquals("abc",list.get(0));
	}
	@Test(groups={"basic","retrievals"})
	public void getLastItem() throws ListEmptyException, ItemNotInListException {
		insertTestData();
		assertEquals("ghi",list.get(2));
	}
	@Test(groups={"basic","retrievals"})
	public void getMiddleItem() throws ListEmptyException, ItemNotInListException {
		insertTestData();
		assertEquals("def",list.get(1));
	}
	@Test(groups={"errors","retrievals"}, expectedExceptions={ItemNotInListException.class})
	public void getAbsentItem() throws Exception {
		insertTestData();
		list.get(100);
	}
	@Test(groups={"errors","retrievals"}, expectedExceptions={ListEmptyException.class})
	public void getOnEmptyList() throws Exception {
		list.get(100);
	}
	@Test(groups={"performance","inserts"}, timeOut=250)
	public void addManyItemsToEmptyList() {
		for(int i=0;i<NUM_VALUES;i++) {
			list.add(values[i]);
		}
	}
	@Test(groups={"performance","inserts"}, timeOut=1000)
	public void addManyItemsToPopulatedList() {
		for(int i=0;i<NUM_VALUES;i++) {
			populatedList.add(values[i]);
		}
	}
	@Test(groups={"performance","deletes"}, timeOut=500)
	public void removeManyItems() throws Exception {
		final int numRemovals = 1000;
		final int startingPoint = 5000;
		for(int i=0;i<numRemovals;i++) {
			populatedList.remove("initial " + (startingPoint + i));
		}
	}
	private void insertTestData() {
		list.add("abc");
		list.add("def");
		list.add("ghi");
	}
	private List<String> list;
	private List<String> populatedList;
	private static String [] values;
}

