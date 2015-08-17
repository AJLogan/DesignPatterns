package demos.classloaders.custom;

import java.io.*;

public class CustomClassLoader extends ClassLoader {
    public CustomClassLoader(File[] classPath) {
        super();
        this.classPath = classPath;
    }
    public Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("Trying to find: " + name);
        String transformedName = name.replace('.',File.separatorChar);
        try {
	        for(int i=0;i<classPath.length;i++) {
	            File f = new File(classPath[i].getAbsolutePath() + File.separator + transformedName + ".class");
	            System.out.println("Trying: " + f.getAbsolutePath());
	            if(f.canRead()) {
	                RandomAccessFile raf = new RandomAccessFile(f,"r");
	                byte[] data = new byte[(int)raf.length()];
	                raf.readFully(data);
	                return defineClass(name, data, 0, data.length);
	            }
	        }
	        return null;
        } catch(Exception ex) {
            System.out.println("Exception in classloader " + ex);
            return null;
        }
    }
    private File[] classPath;
}
