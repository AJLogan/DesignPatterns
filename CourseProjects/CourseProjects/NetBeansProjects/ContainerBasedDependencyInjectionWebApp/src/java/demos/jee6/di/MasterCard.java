package demos.jee6.di;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

@Target({FIELD,METHOD,PARAMETER,TYPE})
@Retention(RUNTIME)
@Qualifier
public @interface MasterCard {
    
}
