package demos.swing.events.basic;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.EventObject;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainFrame extends JFrame {
	public MainFrame(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		listener1 = new SampleActionListener();
		listener2 = new SampleMouseListener();
		listener3 = new SampleChangeListener();
		
		button1 = new JButton("First Button");
		button2 = new JButton("Second Button");
		textArea = new JTextArea(5,20);
		
		button1.setActionCommand("No1");
		button2.setActionCommand("No2");
		
		button1.addActionListener(listener1);
		button1.addMouseListener(listener2);
		button1.addChangeListener(listener3);
		button2.addActionListener(listener1);
		button2.addMouseListener(listener2);
		button2.addChangeListener(listener3);
		
		Box box = Box.createVerticalBox();
		box.add(button1);
		box.add(Box.createVerticalStrut(10));
		box.add(button2);
		getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
		getContentPane().add(box);
		getContentPane().add(new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
	}
	private String buildMessageForButton(ActionEvent e) {
		String name;
		if(e.getActionCommand().equals("No1")) {
			name = "first button";
		} else if(e.getActionCommand().equals("No2")) {
			name = "second button";
		} else {
			name = "unknown";
		}
		return name;
	}
	private String buildMessageForButton(EventObject e) {
		String name;
		if(e.getSource() == button1) {
			name = "first button";
		} else if(e.getSource() == button2) {
			name = "second button";
		} else {
			name = "unknown";
		}
		return name;
	}
	private JButton button1;
	private JButton button2;
	private JTextArea textArea;
	private SampleActionListener listener1;
	private SampleMouseListener listener2;
	private SampleChangeListener listener3;
	
	private class SampleActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String name = buildMessageForButton(e);
			textArea.append(name + " pushed\n");	
		}
	}
	private class SampleChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			String name = buildMessageForButton(e);
			textArea.append(name + " has changed state\n");
		}	
	}
	private class SampleMouseListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			String name = buildMessageForButton(e);
			textArea.append(name + " clicked\n");
		}
		public void mousePressed(MouseEvent e) {
			String name = buildMessageForButton(e);
			textArea.append(name + " pressed\n");
		}
		public void mouseReleased(MouseEvent e) {
			String name = buildMessageForButton(e);
			textArea.append(name + " released\n");
		}
		public void mouseEntered(MouseEvent e) {
			String name = buildMessageForButton(e);
			textArea.append(name + " entered\n");
		}
		public void mouseExited(MouseEvent e) {
			String name = buildMessageForButton(e);
			textArea.append(name + " exited\n");
		}
	}
}
