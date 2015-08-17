package demos.swing.flying.saucer.refactored;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.xhtmlrenderer.resource.FSEntityResolver;
import org.xhtmlrenderer.simple.FSScrollPane;
import org.xhtmlrenderer.simple.XHTMLPanel;
import org.xml.sax.SAXException;

public class MainFrame extends JFrame {
	public MainFrame(String name, InputStream input) throws Exception {
		super(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createComponents();
		initComponents(input);
		addComponents();
	}
	private void createComponents() {
		loadButton = new JButton("Load");
		panel = new XHTMLPanel();
		urlBox = new JTextField(30);
	}
	private void initComponents(InputStream input) throws Exception {
		panel.setDocument(input,"http://www.nowhere.com");
		MyActionListener listener = new MyActionListener();
		loadButton.addActionListener(listener);
		urlBox.addActionListener(listener);
	}
	private void addComponents() {
		Container pane = getContentPane();
		Box top = Box.createHorizontalBox();
		top.setBorder(new TitledBorder("Type a URL to load it..."));
		top.add(urlBox);
		top.add(Box.createHorizontalStrut(20));
		top.add(loadButton);
		pane.add(top,BorderLayout.NORTH);
		pane.add(new FSScrollPane(panel));
	}
	private class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Thread t = new LoadingThread(urlBox.getText());
			t.start();
		}
	}
	private class LoadingThread extends Thread {
		LoadingThread(String url) {
			super();
			this.location = url;
		}
		public void run() {
			try {
				loadDocumentAndPassToEDT();
			} catch (Exception ex) {
				buildErrorAndPassToEDT(ex);
			}
		}
		private void buildErrorAndPassToEDT(Exception ex) {
			StringBuilder msg = new StringBuilder();
			msg.append("<html><body><h2>Error: ");
			msg.append(ex.getMessage());
			msg.append("</h2></body></html>");
			final String errorMsg = msg.toString();
			
			Runnable r = new Runnable() {
				public void run() {
					try {
						panel.setDocument(new ByteArrayInputStream(errorMsg.getBytes()),location);
					} catch (Exception e) {
						System.out.println("Cant display error message...");
					}
				}
			};
			SwingUtilities.invokeLater(r);
		}
		private void loadDocumentAndPassToEDT() throws Exception {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			builder.setEntityResolver(FSEntityResolver.instance());
			URL url = new URL(location);
			final Document doc = builder.parse(url.openStream());
			
			Runnable r = new Runnable() {
				public void run() {
					panel.setDocument(doc,location);
				}
			};
			SwingUtilities.invokeLater(r);
		}
		private String location;
	}
	private JButton loadButton;
	private JTextField urlBox;
	private XHTMLPanel panel;
}
