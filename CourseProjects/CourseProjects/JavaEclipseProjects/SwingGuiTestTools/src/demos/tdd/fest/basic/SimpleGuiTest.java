package demos.tdd.fest.basic;

import org.fest.swing.fixture.FrameFixture;
import org.junit.*;

public class SimpleGuiTest {
	@Before
	public void start() {
		fixture = new FrameFixture(new SimpleGui("GUI Under Test"));
		fixture.show();
	}
	@Test
	public void buttonSetsTextField() {
		fixture.textBox("myTextField").requireText("");
		fixture.button("myButton").click();
		fixture.textBox("myTextField").requireText("Button Pushed");
	}
	@After
	public void end() {
		fixture.cleanUp();
	}
	private FrameFixture fixture;
}
