package demos.tdd.xunit.testtool;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestCase {
	String value() default "Anonymous";
}
