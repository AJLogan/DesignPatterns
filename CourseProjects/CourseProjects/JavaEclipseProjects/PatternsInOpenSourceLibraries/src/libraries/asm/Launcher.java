package libraries.asm;


import org.objectweb.asm.ClassReader;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Enumeration;
import java.util.jar.JarFile;
import java.util.jar.JarEntry;

public class Launcher {
    public static void main(String [] args) throws IOException {
        String classPathProperty = System.getProperty("java.class.path");
        String [] entriesOnClasspath = classPathProperty.split(File.pathSeparator);
        printClasspathEntries(entriesOnClasspath);
        int choice = readChoiceFromConsole(entriesOnClasspath.length);
        String entry = entriesOnClasspath[choice];
        if(entry.endsWith(".jar")) {
            visitJarFile(entry);
        } else {
            System.out.printf("%1$s is not a JAR\n",entry);
        }
    }

    private static void visitJarFile(String jarFileName) throws IOException {
        SimpleClassVisitor visitor = new SimpleClassVisitor();
        JarFile jarFile = new JarFile(jarFileName);
        Enumeration<JarEntry> entries = jarFile.entries();
        while(entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            if(entry.getName().endsWith(".class")) {
                ClassReader reader = new ClassReader(jarFile.getInputStream(entry));
                reader.accept(visitor,false);
            }
        }
        jarFile.close();
    }

    private static int readChoiceFromConsole(int numChoices) {
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while(scanner.hasNext()) {
            if(scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if(choice < numChoices) {
                    break;
                }
            } else {
                scanner.next();
            }
            System.out.println("Not a valid choice - try again");
        }
        return choice;
    }

    private static void printClasspathEntries(String[] entriesOnClasspath) {
        System.out.println("Classpath contents are:");
        for(int i=0;i<entriesOnClasspath.length;i++) {
            System.out.printf("[%1$3d]\t%2$s\n",i,entriesOnClasspath[i]);
        }
        System.out.println("Please select a JAR:");
    }
}

