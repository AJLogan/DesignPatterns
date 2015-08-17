package demos.tdd;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	demos.tdd.junit.v3.basic.SkeletonTest.class,
	demos.tdd.junit.v3.basic.MathTest.class,
	demos.tdd.junit.v4.basic.SkeletonTest.class,
	demos.tdd.junit.v4.basic.MathTest.class,
	demos.tdd.self.shunt.ItemsManagerTest.class,
	demos.tdd.easymock.basic.ShopTest.class,
	demos.tdd.easymock.advanced.ShopTest.class,
	demos.tdd.jmock.basic.ShopTest.class,
	demos.tdd.jmock.advanced.ShopTest.class,
	demos.tdd.mockito.basic.ShopTest.class,
	demos.tdd.mockito.advanced.ShopTest.class,
})
public class AllTests {

}
