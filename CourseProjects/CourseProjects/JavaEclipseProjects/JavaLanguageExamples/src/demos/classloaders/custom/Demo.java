package demos.classloaders.custom;

import java.io.*;
import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) throws Exception {
        File[] paths = new File[]{new File(".." + File.separator + "GameOfLifeApplication" + File.separator + "bin")};
        CustomClassLoader loader = new CustomClassLoader(paths);
        
        Class<?> klass = Class.forName("gameoflife.Launcher",true,loader);
        Method m = klass.getMethod("main", new Class[]{new String[]{}.getClass()});
        String[] data = {"abc"};
        m.invoke(null,new Object[]{data});
    }
}
