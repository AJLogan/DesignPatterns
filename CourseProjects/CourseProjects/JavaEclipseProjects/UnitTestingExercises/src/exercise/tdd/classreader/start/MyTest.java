package exercise.tdd.classreader.start;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MyTest extends Object implements Cloneable, Serializable {

	public void foo() {}
	public int bar() { return 7; }
}
