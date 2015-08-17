package demos.classloaders.custom.url;

import java.lang.reflect.Method;
import java.net.*;

public class UrlClassLoaderDemo {
    public static void main(String[] args) throws Exception {
        String pathToSwingDemo = "C:\\jdk1.5.0_12\\demo\\jfc\\SwingSet2\\SwingSet2.jar";
        URL path = new URL("file:/" + pathToSwingDemo);
        URLClassLoader loader = new URLClassLoader(new URL[]{path});
        
        Class<?> klass = Class.forName("SwingSet2",true,loader);
        
        Method m = klass.getMethod("main", new Class[]{new String[]{}.getClass()});
        String[] data = {"abc"};
        m.invoke(null,new Object[]{data});
    }
}
