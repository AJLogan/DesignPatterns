package exercise.tdd.pyramid.finish;

import junit.framework.TestCase;
import java.io.*;

public class DrawPyramidTest extends TestCase {
    public void testPyramid() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(out);
        DrawPyramid.printPyramid(ps,6);
        String pyramid = new String(out.toByteArray());
        BufferedReader br = new BufferedReader(new StringReader(pyramid));
        assertEquals("Bad Row1","     #",br.readLine());
        assertEquals("Bad Row2","    ###",br.readLine());
        assertEquals("Bad Row3","   #####",br.readLine());
        assertEquals("Bad Row4","  #######",br.readLine());
        assertEquals("Bad Row5"," #########",br.readLine());
        assertEquals("Bad Row6","###########",br.readLine()); 
        assertNull("End Not Found",br.readLine());
    }
}
