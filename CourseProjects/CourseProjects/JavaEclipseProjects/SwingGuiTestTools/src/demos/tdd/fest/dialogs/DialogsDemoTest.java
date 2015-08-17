package demos.tdd.fest.dialogs;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DialogsDemoTest {
	@Before
	public void start() {
		fixture = new FrameFixture(new DialogsDemo());
		fixture.show();
	}
	@Test
	public void navigationOne() {
		fixture.button("input").click();
		fixture.optionPane().requireTitle("An input dialog");
		fixture.optionPane().requireMessage("Pick a whisky");
		fixture.optionPane().okButton().click();
		fixture.optionPane().requireMessage("Fair enough");
		fixture.optionPane().okButton().click();	
	}
	@Test
	public void navigationTwo() {
		fixture.button("confirmation").click();
		fixture.optionPane().requireTitle("A confirmation request");
		fixture.optionPane().requireMessage("Do you really want to take the red pill?");
		fixture.optionPane().yesButton().click();
		fixture.optionPane().requireMessage("Follow the white rabbit...");
		fixture.optionPane().okButton().click();	
	}
	@Test
	public void navigationThree() {
		fixture.button("confirmation").click();
		fixture.optionPane().requireTitle("A confirmation request");
		fixture.optionPane().requireMessage("Do you really want to take the red pill?");
		fixture.optionPane().noButton().click();
		fixture.optionPane().requireMessage("Quitter!");
		fixture.optionPane().okButton().click();	
	}
	@After
	public void end() {
		fixture.cleanUp();
	}
	private FrameFixture fixture;
}
