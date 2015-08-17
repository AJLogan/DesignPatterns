package demos.swing.flying.saucer.tabbed;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
		tabbedPane = new JTabbedPane();
		urlBox = new JTextField(30);
	}
	private void initComponents(InputStream input) throws Exception {
		threadPool = Executors.newFixedThreadPool(10);
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
		pane.add(tabbedPane);
	}
	private class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			XHTMLPanel saucerPanel = new XHTMLPanel();
			JComponent content = new FSScrollPane(saucerPanel);
			tabbedPane.addTab(urlBox.getText(), content);
			threadPool.submit(new PageLoadingTask(urlBox.getText(),saucerPanel));
		}
	}
	private JButton loadButton;
	private JTextField urlBox;
	private JTabbedPane tabbedPane;
	private ExecutorService threadPool;
}
