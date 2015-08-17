package concurrency.finish.part1;

import java.io.*;
import java.net.URL;
import java.util.concurrent.LinkedBlockingQueue;

public class Launcher {

	public static void main(String[] args) throws Exception {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		LinkedBlockingQueue<URL> queue = new LinkedBlockingQueue<URL>(10);
		
		LoadingThread thread = new LoadingThread(queue);
		thread.start();
		
		while(true) {
			System.out.println("Enter a URL to load (you dont need the 'http://') or 'X' to end");
			String url = console.readLine();
			if(url.equals("X")) {
				System.out.println("Bye...");
				break;
			} else {
				queue.add(new URL("http://" + url));
			}
		}
	}
}
