package demos.swing.tables;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class Launcher {
	public static void main(String[] args) {
		final JTextField tf = new JTextField(10);
		final JTable table = new JTable(new SampleTableModel());
		table.addMouseListener(new MouseAdapter() {
									public void mouseClicked(MouseEvent e) {
										int row = table.getSelectedRow();
										int column = table.getSelectedColumn();
										tf.setText("You just selected " + row + "," + column);
									}
								});
		displayControls(tf, table);
	}

	private static void displayControls(final JTextField tf, final JTable table) {
		final JFrame window = new JFrame("JTable demo");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(tf,BorderLayout.NORTH);
		window.add(table,BorderLayout.CENTER);
		window.pack();
		
		Runnable r = new Runnable() {
			public void run() {
				window.setVisible(true);
			}
		};
		SwingUtilities.invokeLater(r);
	}
}
