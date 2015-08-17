package demos.io.files;

import java.io.*;

public class StreamTokenizerDemo {
	public static void main(String[] args) throws IOException {
		File f = new File(("input" + File.separator + "tokens.txt"));
		if (f.canRead()) {
			System.out.println("Found the following tokens:");
			StreamTokenizer st = new StreamTokenizer(new FileReader(f));
			boolean atFileEnd = true;
			while (atFileEnd) {
				st.nextToken();
				switch (st.ttype) {
				case StreamTokenizer.TT_EOF:
					atFileEnd = false;
					break;
				case StreamTokenizer.TT_NUMBER:
					System.out.printf("\tNumber: %f on line %s\n",st.nval,st.lineno());
					break;
				case StreamTokenizer.TT_WORD:
					System.out.printf("\tWord: %s on line %s\n",st.sval,st.lineno());
					break;
				}
			}
		} else {
			System.out.println("Cannot find file");
		}
	}
}
