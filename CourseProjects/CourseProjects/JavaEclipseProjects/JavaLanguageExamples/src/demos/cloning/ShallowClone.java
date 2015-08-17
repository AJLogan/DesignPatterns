package demos.cloning;

/**
 * @author Garth Gilmour
 *
 */
class ShallowClone implements Cloneable {

	public ShallowClone(String s) {
		super();
		buffer = new StringBuffer(s);
	}
	public void change(String str) {
		buffer.append(str);
	}

	protected Object clone() throws CloneNotSupportedException {
		ShallowClone myclone = (ShallowClone)super.clone();
		//do deep copy here
		return myclone;
	}

	public String toString() {
		return "state is " + buffer;
	}

	private StringBuffer buffer;
}
