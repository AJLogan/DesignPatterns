package demos.swing.dialogs.refactored;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.*;

import demos.swing.dialogs.refactored.commands.ColorChooserDialogCommand;
import demos.swing.dialogs.refactored.commands.Command;
import demos.swing.dialogs.refactored.commands.ConfirmDialogCommand;
import demos.swing.dialogs.refactored.commands.CustomConfirmDialogCommand;
import demos.swing.dialogs.refactored.commands.CustomDialogCommand;
import demos.swing.dialogs.refactored.commands.FileChooserDialogCommand;
import demos.swing.dialogs.refactored.commands.FreeFormInputDialogCommand;
import demos.swing.dialogs.refactored.commands.InputDialogCommand;
import demos.swing.dialogs.refactored.commands.MessageDialogCommand;

public class MainFrame extends JFrame {
	public MainFrame() {
		super("Demo of Dialogs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createGUI();
		createCommandsMap();
		setListeners();
	}
	private void createCommandsMap() {
		commands = new HashMap<String,Command>();
		commands.put("MessageDialog",new MessageDialogCommand(this));
		commands.put("InputDialog",new InputDialogCommand(this));
		commands.put("ConfirmDialog",new ConfirmDialogCommand(this));
		commands.put("CustomConfirmDialog",new CustomConfirmDialogCommand(this));
		commands.put("FreeFormInputDialog",new FreeFormInputDialogCommand(this));
		commands.put("ColorChooserDialog",new ColorChooserDialogCommand(this,colorChooserButton));
		commands.put("FileChooserDialog",new FileChooserDialogCommand(this));
		commands.put("CustomDialog",new CustomDialogCommand(this));
	}
	private void createGUI() {
		createButtons();
		JPanel p = new JPanel();
		p.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		p.setLayout(new GridLayout(8,1));
		addButtons(p);
		
		Container c = getContentPane();
		c.add(new JLabel("The standard dialogs"),BorderLayout.NORTH);
		c.add(p,BorderLayout.CENTER);
		
	}
	private void createButtons() {
		inputButton = createButton("Asking for Input","InputDialog");
		confirmButton = createButton("Requesting Confirmation","ConfirmDialog");
		messageButton = createButton("Standard Message","MessageDialog");
		customConfirmButton = createButton("Customized Confirmation","CustomConfirmDialog");
		freeFormInputButton = createButton("Asking for Input (Free Form)","FreeFormInputDialog");
		colorChooserButton = createButton("Choosing a Color","ColorChooserDialog");
		fileChooserButton = createButton("Choosing a File","FileChooserDialog");
		customDialogButton = createButton("Custom Dialog","CustomDialog");
	}
	private JButton createButton(String text, String command) {
		JButton tmp = new JButton(text);
		tmp.setActionCommand(command);
		return tmp;
	}
	private void setListeners() {
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = e.getActionCommand();
				Command command = commands.get(key);
				command.execute();
			}
		};
		messageButton.addActionListener(listener);
		inputButton.addActionListener(listener);
		confirmButton.addActionListener(listener);
		customConfirmButton.addActionListener(listener);
		freeFormInputButton.addActionListener(listener);
		colorChooserButton.addActionListener(listener);
		fileChooserButton.addActionListener(listener);
		customDialogButton.addActionListener(listener);
	}
	private void addButtons(JPanel p) {
		p.add(messageButton);
		p.add(confirmButton);
		p.add(customConfirmButton);
		p.add(inputButton);
		p.add(freeFormInputButton);
		p.add(colorChooserButton);
		p.add(fileChooserButton);
		p.add(customDialogButton);
	}
	private JButton inputButton;
	private JButton confirmButton;
	private JButton messageButton;
	private JButton customConfirmButton;
	private JButton freeFormInputButton;
	private JButton colorChooserButton;
	private JButton fileChooserButton;
	private JButton customDialogButton;
	private Map<String,Command> commands;
}

