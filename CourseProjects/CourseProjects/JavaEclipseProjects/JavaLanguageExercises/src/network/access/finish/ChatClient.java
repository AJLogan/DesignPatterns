package network.access.finish;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	public static void main(String[] args) throws IOException {
		// Connect to the server machine
		Socket soc = new Socket("127.0.0.1", 9123);
		BufferedReader input = new BufferedReader(new InputStreamReader(soc.getInputStream()));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
		Scanner console = new Scanner(System.in);
		
		// Do the chat loop
		System.out.println("Write message to server [XXXX to end]");
		while(true) {
			String message = console.nextLine();
			output.write(message);
			output.newLine();
			output.flush();
			if(message.equals("XXXX")) {
				break;
			} else {
				String response = input.readLine();
				System.out.println(">> " + response);
			}
		}
		soc.close();
	}
}
