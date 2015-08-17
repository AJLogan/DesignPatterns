package demos.java6.ap.processor;

import java.util.Set;

import javax.annotation.processing.*;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import static javax.lang.model.SourceVersion.RELEASE_6; 
import static javax.tools.Diagnostic.Kind.NOTE;

/*
 * To use this annotation processor open a shell / console in the folder 'test/ap' and run the compiler as follows:
 *  'javac -cp ../../bin -processor demos.java6.ap.processor.MyAnnotationProcessor *.java'
 *  
 *  You should get the following output:
 *  
 *  Note: MyAnnotationProcessor called!
 *  Found demos.annotation.processing.FooBar while processing the following types:
 *	    MyClass
 *	    OtherClass
 *  The annotated ones were:
 *	    MyClass
 */

@SupportedAnnotationTypes("demos.java6.ap.processor.FooBar")
@SupportedSourceVersion(RELEASE_6)
public class MyAnnotationProcessor extends AbstractProcessor {
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		if (!roundEnv.processingOver()) {
			processingEnv.getMessager().printMessage(NOTE, "MyAnnotationProcessor called!");
			for(TypeElement te : annotations) {
				System.out.printf("Found %s while processing the following types:\n",te.getQualifiedName());
				for(Element e : roundEnv.getRootElements()) {
					System.out.printf("\t%s\n",e.getSimpleName());
				}
				System.out.printf("The annotated ones were:\n");
				for(Element e : roundEnv.getElementsAnnotatedWith(te)) {
					System.out.printf("\t%s\n",e.getSimpleName());
				}
			}
		}
		return true;
	}
}

