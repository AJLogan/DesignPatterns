package roman.numerals.finish.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	roman.numerals.finish.ok.MyTest.class,
	roman.numerals.finish.better.MyTest.class,
	roman.numerals.finish.best.MyTest.class,
	roman.numerals.finish.best.enums.MyTest.class
})
public class AllTests {
}
