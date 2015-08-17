package exercise.tdd.mocking.finish;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	exercise.tdd.mocking.finish.easymock.TravelAllowanceCalculatorTest.class,
	exercise.tdd.mocking.finish.jmock.TravelAllowanceCalculatorTest.class,
	exercise.tdd.mocking.finish.mockito.TravelAllowanceCalculatorTest.class
})
public class AllTests {

}
