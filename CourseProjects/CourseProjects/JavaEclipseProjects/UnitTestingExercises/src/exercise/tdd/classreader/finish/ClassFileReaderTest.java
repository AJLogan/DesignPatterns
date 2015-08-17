package exercise.tdd.classreader.finish;

import static org.junit.Assert.*;

import java.io.File;
import java.io.Serializable;

import org.junit.*;

public class ClassFileReaderTest {
	@Before
	public void start() {
		reader = new ClassFileReader(buildFilePath("exercise","tdd","classreader","finish","MyTest.class"));
	}
	@Test
	public void classFileValid() throws Exception {
		assertTrue(reader.isValidClassFile());
	}
	@Test
	public void fileVersionCorrect() throws Exception {
		assertEquals(50.0,reader.readClassFileVersion(),0.1);
	}
	@Test
	public void classNameCorrect() throws Exception {
		assertEquals(MyTest.class.getName().replace('.','/'),reader.readClassName());
	}
	@Test
	public void baseClassNameCorrect() throws Exception {
		assertEquals(Object.class.getName().replace('.','/'),reader.readBaseClassName());
	}
	@Test
	public void interfaceNamesCorrect() throws Exception {
		String [] names = reader.readNamesOfInterfaces();
		assertEquals(2,names.length);
		assertFalse(names[0].equals(names[1]));
		
		String name1 = Serializable.class.getName().replace('.','/');
		String name2 = Cloneable.class.getName().replace('.','/');
		assertTrue(names[0].equals(name1) || names[0].equals(name2));
		assertTrue(names[1].equals(name1) || names[1].equals(name2));
	}
	private static String buildFilePath(String ... parts) {
		StringBuilder result = new StringBuilder();
		for(String str : parts) {
			result.append(File.separator);
			result.append(str);
		}
		return result.toString();
	}
	private ClassFileReader reader;
}
