package demos.swing.events.properties;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class MainFrame extends JFrame {
	public MainFrame() {
		super("Property Events Demo");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setupListModel();
		createWidgets();
		arrangeWidgets();
		setupButtons();
		formattedTextField.addPropertyChangeListener(new MyListener(listModel));
	}
	private void setupListModel() {
		listModel = new MyListModel();
		listModel.add("Messages appear here...");
	}
	private void setupButtons() {
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object source = e.getSource();
				if(source == bt1) {
					formattedTextField.setBackground(Color.CYAN);
				}else if(source == bt2) {
					formattedTextField.setEditable(false);
				}else if(source == bt3) {
					formattedTextField.setValue("ABCDE");
				}else if(source == bt4) {
					formattedTextField.setBackground(Color.WHITE);
					formattedTextField.setEditable(true);
					formattedTextField.setValue("-----");
				}else {
					throw new IllegalStateException("Unknown event Source!");
				}
			}
		};
		bt1.addActionListener(listener);
		bt2.addActionListener(listener);
		bt3.addActionListener(listener);
		bt4.addActionListener(listener);
	}
	private void arrangeWidgets() {
		Box b = Box.createVerticalBox();
		b.add(formattedTextField);
		b.add(new JScrollPane(list));
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1,4));
		p.add(bt1);
		p.add(bt2);
		p.add(bt3);
		p.add(bt4);
		this.add(b,BorderLayout.NORTH);
		this.add(p,BorderLayout.CENTER);
	}
	private void createWidgets() {
		try {
			MaskFormatter f = new MaskFormatter("#####");
			f.setCommitsOnValidEdit(true);
			formattedTextField = new JFormattedTextField();
			formattedTextField.setValue("-----");
		} catch (ParseException e) {
			throw new IllegalStateException("Bad Mask Format!");
		}
		list = new JList(listModel);
		bt1 = new JButton("Change Background");
		bt2 = new JButton("Make Non-Editable");
		bt3 = new JButton("Change Text");
		bt4 = new JButton("Reset");
	}
	private MyListModel listModel;
	private JFormattedTextField formattedTextField;
	private JList list;
	private JButton bt1;
	private JButton bt2;
	private JButton bt3;
	private JButton bt4;
}
