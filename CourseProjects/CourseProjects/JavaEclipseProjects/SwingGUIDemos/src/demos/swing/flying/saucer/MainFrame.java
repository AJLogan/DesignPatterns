package demos.swing.flying.saucer;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import org.xhtmlrenderer.simple.FSScrollPane;
import org.xhtmlrenderer.simple.XHTMLPanel;

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
			panel.setDocument(urlBox.getText());
		}
	}
	private JButton loadButton;
	private JTextField urlBox;
	private XHTMLPanel panel;
}
