package demos.enums;

public class MyShape {
	private MyShape() {
		super();
	}
	public static final MyShape CIRCLE = new MyShape();
	public static final MyShape SQUARE = new MyShape();
	public static final MyShape DIAMOND = new MyShape();
	public static final MyShape OVAL = new MyShape();
}
