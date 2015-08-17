package concurrency.finish.part2;

import java.io.*;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Launcher {

	public static void main(String[] args) throws Exception {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		ExecutorService executor = Executors.newFixedThreadPool(10);
		int count = 1;
		
		while(true) {
			System.out.println("Enter a URL to load (you dont need the 'http://') or 'X' to end");
			String url = console.readLine();
			if(url.equals("X")) {
				System.out.println("Bye...");
				executor.shutdown();
				break;
			} else {
				executor.submit(new LoadingTask(new URL("http://" + url),count++));
			}
		}
	}
}
