package exercise.tdd.classreader.finish;

import java.io.*;

public class ClassFileReader {
	public ClassFileReader(String fileName) {
		super();
		this.fileName = fileName;
	}
	public boolean isValidClassFile() throws IOException {
		DataInputStream dis = createReader(fileName);
		int magic = dis.readInt();
		dis.close();
		return 0xCAFEBABE == magic;
	}
	public double readClassFileVersion() throws IOException {
		DataInputStream dis = createReader(fileName);
		dis.skip(4);
		double minor = dis.readShort();
		double major = dis.readShort();
		dis.close();
		return major + (minor / 10);
	}
	public String readClassName() throws IOException {
		DataInputStream dis = beginAtEndOfConstantPool();
		skipOverFlags(dis);
		short positionOfClassNameInPool = dis.readShort();
		dis.close();
		short classInfoIndex = fetchClassInfoFromConstantPool(positionOfClassNameInPool);
		return fetchStringFromConstantPool(classInfoIndex);
	}
	public String readBaseClassName() throws IOException {
		DataInputStream dis = beginAtEndOfConstantPool();
		skipOverFlags(dis);
		skipOverClassName(dis);
		short positionOfBaseClassNameInPool = dis.readShort();
		dis.close();
		short classInfoIndex = fetchClassInfoFromConstantPool(positionOfBaseClassNameInPool);
		return fetchStringFromConstantPool(classInfoIndex);
	}
	
	public String [] readNamesOfInterfaces() throws IOException {
		DataInputStream dis = beginAtEndOfConstantPool();
		skipOverFlags(dis);
		skipOverClassName(dis);
		skipOverBaseClassName(dis);
		short numInterfaces = dis.readShort();
		short [] interfaceIndices  = new short[numInterfaces];
		for(int i =0;i<numInterfaces;i++) {
			interfaceIndices[i] = dis.readShort();
		}
		dis.close();
		String [] results = new String[numInterfaces];
		for(int i =0;i<numInterfaces;i++) {
			short classInfoIndex = fetchClassInfoFromConstantPool(interfaceIndices[i]);
			results[i] = fetchStringFromConstantPool(classInfoIndex);	
		}
		return results;
	}
	private void skipOverFlags(DataInputStream dis) throws IOException {
		dis.skip(2);
	}
	private void skipOverClassName(DataInputStream dis) throws IOException {
		dis.skip(2);
	}
	private void skipOverBaseClassName(DataInputStream dis) throws IOException {
		dis.skip(2);
	}
	private Short fetchClassInfoFromConstantPool(int position) throws IOException {
		DataInputStream dis = beginAtStartOfConstantPool();
		int before = position - 1;
		for(int i=0;i<before;i++) {
			skipEntry(dis);
		}
		dis.readUnsignedByte();
		short retval = dis.readShort();
		dis.close();
		return retval;
	}
	private String fetchStringFromConstantPool(int position) throws IOException {
		DataInputStream dis = beginAtStartOfConstantPool();
		for(int i=1;i< position;i++) {
			skipEntry(dis);
		}
		dis.readUnsignedByte();
		short length = dis.readShort();
		byte [] data = new byte[length];
		dis.read(data);
		return new String(data);
	}
	private DataInputStream beginAtStartOfConstantPool() throws IOException {
		DataInputStream dis = createReader(fileName);
		dis.skip(10);
		return dis;
	}
	private DataInputStream beginAtEndOfConstantPool() throws IOException {
		DataInputStream dis = createReader(fileName);
		dis.skip(8);
		int numEntries = dis.readShort();
		for(int entryIndex=1; entryIndex<numEntries; entryIndex++) {
			skipEntry(dis);
		}
		return dis;
	}
	private void skipEntry(DataInputStream dis) throws IOException {
		
		int tag = dis.readUnsignedByte();
		switch(tag) {
		case 7:
		case 8:
			skipOverBaseClassName(dis);
			break;
		case 3:
		case 4:
		case 9:
		case 10:
		case 11:
		case 12:
			dis.skip(4);
			break;
		case 5:
		case 6:
			dis.skip(8);
			break;
		case 1:
			dis.skip(dis.readShort());
			break;
		}
	}
	private DataInputStream createReader(String fileName) {
		ClassLoader cl = ClassFileReader.class.getClassLoader();
		return new DataInputStream(cl.getResourceAsStream(fileName));
	}
	private String fileName;
}
