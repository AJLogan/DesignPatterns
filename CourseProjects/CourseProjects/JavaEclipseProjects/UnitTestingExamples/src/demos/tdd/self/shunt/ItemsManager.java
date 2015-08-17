package demos.tdd.self.shunt;

public class ItemsManager {
	public ItemsManager(ItemsList list) {
		super();
		this.list = list;
	}
	public void add(String name) {
		Item tmp = new Item(name);
		if(!list.exists(tmp)) {
			list.add(tmp);
		}
	}
	private ItemsList list;
}
