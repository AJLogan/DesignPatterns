package patterns.composite;

public class Launcher {
    public static void main(String[] args) {
        Node n = buildFileSystem();
        System.out.println("Total size is: " + n.length());
        n.print();
    }
    private static Node buildFileSystem() {
        Directory d1 = new Directory("C");
        Directory d2 = new Directory("usr");
        Directory d3 = new Directory("bin");
        Directory d4 = new Directory("dave");
        Directory d5 = new Directory("fred");
        Directory d6 = new Directory("java");
        
        d1.add(d2);
        d1.add(d3);
        d2.add(d4);
        d2.add(d5);
        d3.add(d6);
        d3.add(new File("vi.exe",2000));
        d3.add(new File("emacs.exe",5000));
        d4.add(new File("a.txt",20));
        d4.add(new File("b.txt",30));
        d5.add(new File("c.txt",50));
        d6.add(new File("java.exe",8000));
        d6.add(new File("javac.exe",6000));
        
        return d1;        
    }
}
