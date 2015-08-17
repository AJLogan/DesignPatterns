package concurrency.finish.part1;

import java.io.*;
import java.net.URL;
import java.util.concurrent.LinkedBlockingQueue;

public class LoadingThread extends Thread {
	public LoadingThread(LinkedBlockingQueue<URL> queue) {
		super();
		setDaemon(true);
		this.queue = queue;
		count = 1;
	}
	public void run() {
		while(true) {
			BufferedWriter bw = null;
			BufferedReader br = null;
			try {
				URL url = queue.take();
				File path = new File("output" + File.separator + "out" + (count++) + ".html");
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
	}
	private LinkedBlockingQueue<URL> queue;
	private int count;
}
