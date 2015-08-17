package demos.cloning;

/**
 * @author Garth Gilmour
 *
 */
class DeepClone implements Cloneable {

	public DeepClone(String s) {
		super();
		buffer = new StringBuffer(s);
	}
	public void change(String str) {
		buffer.append(str);
	}

	protected Object clone() throws CloneNotSupportedException {
		DeepClone myclone = (DeepClone)super.clone();
		//do deep copy here
		myclone.buffer = new StringBuffer(buffer.toString());
		return myclone;
	}

	public String toString() {
		return "state is " + buffer;
	}

	private StringBuffer buffer;
}
