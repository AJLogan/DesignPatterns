package demos.tdd.junit.v4.basic;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	demos.tdd.junit.v4.basic.MathTest.class,
	demos.tdd.junit.v4.basic.SkeletonTest.class
})
public class AllTests {

}
