package patterns.decorator;

public class Launcher {
    public static void main(String[] args) {
        
        List myList = new ListImpl();
        List wrapper = ListUtils.makeThreadSafe(myList);
        
        wrapper.add("abc");
        wrapper.add("def");
        wrapper.add("ghi");
        wrapper.add("jkl");
        wrapper.add("mno");
        wrapper.add("pqr");
        
        wrapper.find("ghi");
        wrapper.remove(4);
        
    }
}
