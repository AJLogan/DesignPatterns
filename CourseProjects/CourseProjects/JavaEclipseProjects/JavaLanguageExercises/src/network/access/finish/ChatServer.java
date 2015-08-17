package network.access.finish;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatServer {
	public static void main(String[] args) throws IOException {
		// Create an object to listen on port 9123
		ServerSocket ss = new ServerSocket(9123);
		System.out.println("Server Running!");

		System.out.println("Waiting...");
		Socket soc = ss.accept();
		System.out.println("Connected to: " + soc.getRemoteSocketAddress());

		// Set up streams
		BufferedReader input = new BufferedReader(new InputStreamReader(soc.getInputStream()));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
		Scanner console = new Scanner(System.in);
		
		// Do the chat loop
		String currentLine;
		while (!(currentLine = input.readLine()).equals("XXXX")) {
			System.out.println(">> " + currentLine);
			String response = console.nextLine();
			output.write(response);
			output.newLine();
			output.flush();
		}
		System.out.println("Client finished conversation...");
		soc.close();
	}
}
