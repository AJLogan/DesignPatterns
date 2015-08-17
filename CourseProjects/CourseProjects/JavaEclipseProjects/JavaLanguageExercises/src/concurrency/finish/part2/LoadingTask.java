package concurrency.finish.part2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;

public class LoadingTask implements Runnable {
	public LoadingTask(URL url, int i) {
		this.url = url;
		path = new File("output" + File.separator + "out" + i + ".html");
	}
	public void run() {
		BufferedWriter bw = null;
		BufferedReader br = null;
		try {
			bw = new BufferedWriter(new FileWriter(path));
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			
			String current = null;
			while(null !=(current = br.readLine())) {
				bw.write(current);
				bw.newLine();
			}
		} catch(Exception ex) {
			System.out.println("Loading thread crashed! " + ex);
		} finally {
			try {
				if(bw != null) {
					bw.close();
				}
				if(br != null) {
					br.close();
				}
			} catch(Exception ex) {
				System.out.println("Cant close streams...");
			}
		}
	}
	private URL url;
	private File path;
}
