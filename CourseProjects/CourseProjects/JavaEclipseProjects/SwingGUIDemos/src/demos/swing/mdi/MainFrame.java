package demos.swing.mdi;

import java.net.*;
import java.io.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class MainFrame extends JFrame {
	private static final int PORT_NUMBER = 8123;
	public MainFrame() {
		super("Simple Chat Application");
		buildGUI();
		chatSessionsList = new ArrayList<ChatSession>();
		startReceivingChatRequests();
	}
	private void buildGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		eventHandler = new ActionHandler();
		desktopPane = new JDesktopPane();

		setupMenus();

		add(desktopPane);
		setSize(500,500);
	}

	private void setupMenus() {
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		setupFileMenu();
		connectMenu = new JMenu("Connections");
		setupConnectionsMenu();
		menuBar.add(fileMenu);
		menuBar.add(connectMenu);
		setJMenuBar(menuBar);
	}
	private void setupFileMenu() {
		exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(eventHandler);
		exitMenuItem.setActionCommand("Exit");
		fileMenu.add(exitMenuItem);
	}
	private void setupConnectionsMenu() {
		newConnectionMenuItem = new JMenuItem("Make New Connection");
		newConnectionMenuItem.addActionListener(eventHandler);
		newConnectionMenuItem.setActionCommand("Connect");
		connectMenu.add(newConnectionMenuItem);
	}

	private void startNewOutgoingChatSession(String location) {
		try {
			initializeNewOutgoingChatSession(location);
		} catch(IOException ex){
			System.out.println("Cannot start client: " + ex);
		}
	}
	private void startNewOutgoingChatSession() {
		try {
			String s = (String)JOptionPane.showInputDialog(MainFrame.this,"Choose Host","Title", JOptionPane.PLAIN_MESSAGE);
			initializeNewOutgoingChatSession(s);
			addNewConnectMenuItem(s);
		} catch(IOException ex){
			System.out.println("Cannot start client: " + ex);
		}
	}
	private void initializeNewOutgoingChatSession(String s)
		throws UnknownHostException, IOException {
		InetAddress host;
		if(s.equals("")) {
			System.out.println("Using Localhost");
			host = InetAddress.getLocalHost();
		}
		else {
			System.out.println("Using " + s);
			host = InetAddress.getByName(s);
		}
		Socket socket = new Socket(host,PORT_NUMBER);
		ChatSession sc = new ChatSession(socket);
		chatSessionsList.add(sc);
		desktopPane.add(sc);
	}
	private void addNewConnectMenuItem(String location) {
		if(location.equals("")) {
			location = "127.0.0.1";
		}
		JMenuItem newItem = new JMenuItem(location);
		newItem.addActionListener(eventHandler);
		newItem.setActionCommand(location);
		connectMenu.add(newItem);
	}
	private void startNewIncomingChatSession(Socket socket) {
		ChatSession sc = new ChatSession(socket);
		chatSessionsList.add(sc);
		desktopPane.add(sc);
	}
	private void startReceivingChatRequests() {
		try {
			if(server == null) {
				server = new ChatServer(PORT_NUMBER);
				server.start();
				System.out.println("Server started OK");
			}
		} catch (BindException ex) {
			JOptionPane.showMessageDialog(MainFrame.this,"Server socket already in use","Exit Dialog",JOptionPane.WARNING_MESSAGE);
			System.exit(1);
		} catch(IOException ex){
			System.out.println("Cannot start server: " + ex);
			System.exit(1);
		}
	}
	private final class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			System.out.println("Event handler called for: " + cmd);
			if(cmd.equals("Connect")) {
				startNewOutgoingChatSession();
			}
			else if(cmd.equals("Exit")) {
				System.exit(0);
			} else {
				startNewOutgoingChatSession(cmd);
			}
		}
	}
	private final class ChatServer extends Thread {

		public ChatServer(int port) throws IOException {
			serverSocket = new ServerSocket(port);
		}
		public void run() {
			System.out.println("SocketServer Running");
			try {
				while(true) {
					Socket s = serverSocket.accept();
					String confirmMsg = "Do you want to chat to: " + s.getRemoteSocketAddress() + " ?";
					int confirm = JOptionPane.showConfirmDialog(MainFrame.this,confirmMsg,"Accept Connection",JOptionPane.YES_NO_OPTION);
					if(confirm == JOptionPane.YES_OPTION) {
						System.out.println("New server side socket on port " + s.getLocalPort() + " connecting to " + s.getPort());
						startNewIncomingChatSession(s);
					} else {
						s.close();
					}
				}
			} catch(IOException e){
				System.out.println("SocketServer::run " + e);
			}
		}
		private ServerSocket serverSocket;
	}
	private JDesktopPane desktopPane;
	private ArrayList<ChatSession> chatSessionsList;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu connectMenu;
	private JMenuItem newConnectionMenuItem;
	private JMenuItem exitMenuItem;
	private ChatServer server;
	private ActionListener eventHandler;
}

