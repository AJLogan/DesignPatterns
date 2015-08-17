package demos.swing.borders;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.*;

public class MainFrame extends JFrame {
	public MainFrame() {
		super("Demo of Borders");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,4));
		add(buildPanelWithBorder("Bevel Border (Lowered)", new BevelBorder(BevelBorder.LOWERED)));
		add(buildPanelWithBorder("Bevel Border (Raised)", new BevelBorder(BevelBorder.RAISED)));
		add(buildPanelWithBorder("Soft Bevel Border (Lowered)", new SoftBevelBorder(BevelBorder.LOWERED)));
		add(buildPanelWithBorder("Soft Bevel Border (Raised)", new SoftBevelBorder(BevelBorder.RAISED)));
		add(buildPanelWithBorder("Empty Border (10px insets)", new EmptyBorder(10,10,10,10)));
		add(buildPanelWithBorder("Empty Border (20px insets)", new EmptyBorder(20,20,20,20)));
		add(buildPanelWithBorder("Line Border (BLUE)", new LineBorder(Color.BLUE)));
		add(buildPanelWithBorder("Line Border (Rounded)", new LineBorder(Color.BLACK,2,true)));
		add(buildPanelWithBorder("Etched Border", new EtchedBorder()));
		add(buildPanelWithBorder("Matte Border", new MatteBorder(2,2,2,2,Color.GREEN)));
		add(buildPanelWithBorder("Titled Border", new TitledBorder("TITLE GOES HERE")));
		add(buildPanelWithBorder("Compound Border (Line and Bevel)", new CompoundBorder(new LineBorder(Color.BLUE),new BevelBorder(BevelBorder.RAISED))));
	}
	private JPanel buildPanelWithBorder(String title, Border border) {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(new JButton(title),BorderLayout.CENTER);
		p.setBorder(border);
		return p;
	}
}
