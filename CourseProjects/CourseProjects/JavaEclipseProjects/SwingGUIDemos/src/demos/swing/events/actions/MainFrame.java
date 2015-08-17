package demos.swing.events.actions;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class MainFrame extends JFrame {
	public MainFrame() {
		super("Demo of Actions");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		myAction = new MyAction();
		changesButton = new JButton("Make Changes");
		changesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myAction.makeChanges();
			}
		});
		createWidgets();
		layoutWidgets();
	}
	private void createWidgets() {
		sampleButton = new JButton(myAction);
		sampleButton.setActionCommand("Sample Button");
		sampleRadioButton = new JRadioButton(myAction);
		sampleRadioButton.setActionCommand("Sample Radio Button");
		sampleToggleButton = new JToggleButton(myAction);
		sampleToggleButton.setActionCommand("Sample Toggle Button");
	}
	private void layoutWidgets() {
		widgetsUsingAction = Box.createVerticalBox();
		widgetsUsingAction.add(sampleButton);
		widgetsUsingAction.add(sampleRadioButton);
		widgetsUsingAction.add(sampleToggleButton);
		widgetsUsingAction.setBorder(new TitledBorder("Buttons Using Action"));
		add(widgetsUsingAction,BorderLayout.CENTER);
		add(changesButton,BorderLayout.SOUTH);
	}
	private JButton changesButton;
	private Box widgetsUsingAction;
	private MyAction myAction;
	private JButton sampleButton;
	private JRadioButton sampleRadioButton;
	private JToggleButton sampleToggleButton;
}
