package demos.swing.labels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;

public class MainFrame extends JFrame {
	public MainFrame() {
		super("Event Handling Exercise");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		content = Box.createVerticalBox();
		
		JLabel label1 = new JLabel("A label using a Font object");
		label1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
		content.add(label1);
		
		JLabel label2 = new JLabel("<html><div style='color:blue;font-size:16pt'>A label using HTML</div></html>");
		content.add(label2);
		
		ImageIcon icon = null;
		try {
			URL url = new File("./images/tomcat.gif").toURI().toURL();
			icon = new ImageIcon(url);
		} catch (Exception e) {
			System.out.println("Cant load image!");
		}
		JLabel label3 = new JLabel("A label using an Icon",icon,SwingConstants.LEFT);
		content.add(label3);
		
		final JLabel label4 = new JLabel("A blinking label");
		label4.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
		content.add(label4);
		
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(count++ % 2 == 0) {
					if(count > 20) {
						((Timer)e.getSource()).stop();
					} else {
						label4.setText("");
					}
				}
				else {
					label4.setText("A blinking label");
				}
			}
			int count;
		};
		timer = new Timer(500,listener);
		timer.start();
		
		add(content,BorderLayout.CENTER);
	}
	private Box content;
	private Timer timer;
}
