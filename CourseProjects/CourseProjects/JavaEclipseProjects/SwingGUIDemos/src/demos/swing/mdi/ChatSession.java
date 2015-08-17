package demos.swing.mdi;

import javax.swing.*;
import java.util.Random;
import java.io.*;
import java.net.*;
import java.awt.event.*;
import java.awt.*;


class ChatSession extends JInternalFrame implements Runnable{
	public ChatSession(Socket socket) {
		super(buildTitleString(socket));
		random = new Random();
		buildGUI();
		this.socket = socket;
		myThread = new Thread(this);
		myThread.start();
	}
	public void run() {
		try {
			readAndPrintMessages();
		} catch(Exception ex) {
			System.out.println("Exception triggered in internal frame - hopefully because of shutdown");
		} finally {
			finishSession();
		}
	}
	private void buildGUI() {
		buildButtons();
		buildMessageDisplayBox();
		buildMessageEntryBox();
		JPanel messageEntryPanel = buildMessageEntryPanel();
		Box b = buildComponentBox(messageEntryPanel);
		getContentPane().add(b);
		pack();
		show();
		reshape(addOffset(getX()), addOffset(getY()), getWidth(),getHeight());
	}
	private int addOffset(int pos) {
		return pos += random.nextInt(100);
	}
	private void buildMessageEntryBox() {
		messageEntryBox = new JTextField(20);
		ActionListener action = new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String text = messageEntryBox.getText();
								System.out.println("Sending: " + text);
								sendMessage(text);
							}
						};
		messageEntryBox.addActionListener(action);
	}
	private void buildMessageDisplayBox() {
		messageDisplayBox = new JTextArea(10,30);
		messageDisplayBox.setEditable(false);
	}
	private Box buildComponentBox(JPanel messageEntryPanel) {
		Box b = Box.createVerticalBox();
		b.add(messageEntryPanel);
		b.add(new JScrollPane(messageDisplayBox));
		b.add(closeButton);
		return b;
	}
	private JPanel buildMessageEntryPanel() {
		JPanel messageEntryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		messageEntryPanel.add(messageEntryBox);
		messageEntryPanel.add(sendMessageButton);
		return messageEntryPanel;
	}
	private void buildButtons() {
		closeButton = new JButton("Close Connection");
		closeButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									initiatedShutdown = true;
									try {
										if(socket.isConnected()) {
											socket.close();
										}
									} catch(IOException ex) {
										System.out.println("Cant close socket!");
									}
								}
							});
		sendMessageButton = new JButton("Send Message");
		sendMessageButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										sendMessage(messageEntryBox.getText());
									}
								});
	}
	private void finishSession() {
		SwingUtilities.invokeLater(new Runnable() {
										public void run() {
											if(!initiatedShutdown) {
												JOptionPane.showInternalMessageDialog(getContentPane(),"The other party has closed the connection","Session Closed",JOptionPane.WARNING_MESSAGE);
											}
											dispose();
										}
									});
		
	}
	private void readAndPrintMessages() throws Exception {
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		while(true) {
			String newMessage = dis.readUTF();
			printMessage(newMessage);
		}
	}
	private void printMessage(final String newMessage) {
		Runnable r = new Runnable() {
			public void run() {
				messageDisplayBox.setForeground(Color.black);
				messageDisplayBox.append(newMessage + "\n");
			}
		};
		try {
			SwingUtilities.invokeAndWait(r);
		} catch(Exception ex) {
			System.out.println("Cant post new message because: " + ex);
		}

	}
	private void sendMessage(String newMessage) {
		try {
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(newMessage);
		} catch(IOException ex) {
			System.out.println("Cant send new message because: " + ex);
		}
		messageEntryBox.setText("");
		messageDisplayBox.setForeground(Color.blue);
		messageDisplayBox.append(">>" + newMessage + "\n");
	}
	private static String buildTitleString(Socket socket) {
		return "Talking to " + socket.getInetAddress() + " on port " + socket.getPort();
	}
	private boolean initiatedShutdown;
	private JTextArea messageDisplayBox;
	private Socket socket;
	private JTextField messageEntryBox;
	private JButton closeButton;
	private JButton sendMessageButton;
	private Random random;
	private Thread myThread;

}

