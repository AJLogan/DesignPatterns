package demos.classloaders.custom;

import java.io.*;
import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) throws Exception {
        File[] paths = new File[]{new File(".." + File.separator + "UnitTestingExercises" + File.separator + "bin")};
        CustomClassLoader loader = new CustomClassLoader(paths);
        
        Class<?> klass = Class.forName("exercise.tdd.videostore.finish.CommandLine",true,loader);
        Method m = klass.getMethod("main", new Class[]{new String[]{}.getClass()});
        String[] data = {"abc"};
        m.invoke(null,new Object[]{data});
    }
}