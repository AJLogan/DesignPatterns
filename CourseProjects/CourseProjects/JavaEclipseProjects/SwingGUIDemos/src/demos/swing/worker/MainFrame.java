package demos.swing.worker;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class MainFrame extends JFrame {
	public MainFrame() {
		super("SwingWorker Demo");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new MigLayout());
		
		btDemoOne = new JButton("Demo 1");
		tfDemoOne = new JTextField(15);
		btDemoTwo = new JButton("Demo 2");
		cboDemoTwo = new JComboBox(new Object[] {"zzz"});
		lblMessage = new JLabel("---");
		lblMessage.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
		
		add(btDemoOne);
		add(tfDemoOne, "wrap");
		add(btDemoTwo);
		add(cboDemoTwo, "wrap");
		add(lblMessage, "cell 1 2");
		
		addEventHandlers();
	}
	private void addEventHandlers() {
		btDemoOne.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingWorker<String,Object> sw = new BasicSwingWorker(tfDemoOne);
				sw.execute();
			}
		});
		btDemoTwo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingWorker<String,String> sw = new IncrementalSwingWorker(cboDemoTwo,lblMessage);
				sw.execute();
			}
		});
	}
	private JButton btDemoOne;
	private JTextField tfDemoOne;
	private JButton btDemoTwo;
	private JComboBox cboDemoTwo;
	private JLabel lblMessage;
}
