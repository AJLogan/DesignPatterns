package demos.java6.grouplayout;

import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class ParentFrame extends JFrame {
	public ParentFrame() {
		super("Demo of Group Layout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Box b = Box.createVerticalBox();
		setupTopDemos(b);
		setupBottomDemo(b);
		add(b);
	}
	private void setupTopDemos(Box b) {
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(2,3));
		topPanel.add(demoOne());
		topPanel.add(demoTwo());
		topPanel.add(demoThree());
		topPanel.add(demoFour());
		topPanel.add(demoFive());
		topPanel.add(demoSix());
		b.add(topPanel);
	}
	private JPanel demoOne() {
		JPanel p = new JPanel();
		p.setBorder(new TitledBorder("Demo One"));
		GroupLayout layout = new GroupLayout(p);
		p.setLayout(layout);

		JButton b1 = new JButton("b1");
		JButton b2 = new JButton("b2");
		JButton b3 = new JButton("b3");
		JButton b4 = new JButton("b4");
		JButton b5 = new JButton("b5");

		SequentialGroup g1 = layout.createSequentialGroup();
		g1.addComponent(b1);
		g1.addComponent(b2);
		g1.addComponent(b3);
		g1.addComponent(b4);
		g1.addComponent(b5);

		ParallelGroup g2 = layout.createParallelGroup();
		g2.addComponent(b1);
		g2.addComponent(b2);
		g2.addComponent(b3);
		g2.addComponent(b4);
		g2.addComponent(b5);

		layout.setHorizontalGroup(g1);
		layout.setVerticalGroup(g2);

		return p;
	}
	private JPanel demoTwo() {
		JPanel p = new JPanel();
		p.setBorder(new TitledBorder("Demo Two"));
		GroupLayout layout = new GroupLayout(p);
		p.setLayout(layout);

		JButton b1 = new JButton("b1");
		JButton b2 = new JButton("b2");
		JButton b3 = new JButton("b3");
		JButton b4 = new JButton("b4");
		JButton b5 = new JButton("b5");

		SequentialGroup g1 = layout.createSequentialGroup();
		g1.addComponent(b1);
		g1.addComponent(b2);
		g1.addComponent(b3);
		g1.addComponent(b4);
		g1.addComponent(b5);

		ParallelGroup g2 = layout.createParallelGroup();
		g2.addComponent(b1);
		g2.addComponent(b2);
		g2.addComponent(b3);
		g2.addComponent(b4);
		g2.addComponent(b5);

		layout.setHorizontalGroup(g2);
		layout.setVerticalGroup(g1);

		return p;
	}
	private JPanel demoThree() {
		JPanel p = new JPanel();
		p.setBorder(new TitledBorder("Demo Three"));
		GroupLayout layout = new GroupLayout(p);
		p.setLayout(layout);

		JButton b1 = new JButton("b1");
		JButton b2 = new JButton("b2");
		JButton b3 = new JButton("b3");
		JButton b4 = new JButton("b4");
		JButton b5 = new JButton("b5");

		SequentialGroup g1 = layout.createSequentialGroup();
		g1.addComponent(b1);
		g1.addComponent(b2);
		g1.addComponent(b3);
		g1.addComponent(b4);
		g1.addComponent(b5);

		SequentialGroup g2 = layout.createSequentialGroup();
		g2.addComponent(b1);
		g2.addComponent(b2);
		g2.addComponent(b3);
		g2.addComponent(b4);
		g2.addComponent(b5);

		layout.setHorizontalGroup(g1);
		layout.setVerticalGroup(g2);

		return p;
	}
	private JPanel demoFour() {
		JPanel p = new JPanel();
		p.setBorder(new TitledBorder("Demo Four"));
		GroupLayout layout = new GroupLayout(p);
		p.setLayout(layout);

		JButton b1 = new JButton("b1");
		JButton b2 = new JButton("b2");
		JButton b3 = new JButton("b3");
		JButton b4 = new JButton("b4");
		JButton b5 = new JButton("b5");

		ParallelGroup g1 = layout.createParallelGroup();
		g1.addComponent(b1);
		g1.addComponent(b2);
		g1.addComponent(b3);

		SequentialGroup g2 = layout.createSequentialGroup();
		g2.addGroup(g1);
		g2.addComponent(b4);
		g2.addComponent(b5);

		ParallelGroup g3 = layout.createParallelGroup();
		g3.addComponent(b1);
		g3.addComponent(b4);
		g3.addComponent(b5);

		SequentialGroup g4 = layout.createSequentialGroup();
		g4.addGroup(g3);
		g4.addComponent(b2);
		g4.addComponent(b3);

		layout.setHorizontalGroup(g2);
		layout.setVerticalGroup(g4);

		return p;
	}
	private JPanel demoFive() {
		JPanel p = new JPanel();
		p.setBorder(new TitledBorder("Demo Five"));
		GroupLayout layout = new GroupLayout(p);
		p.setLayout(layout);

		JButton b1 = new JButton("b1");
		JButton b2 = new JButton("b2");
		JButton b3 = new JButton("b3");
		JButton b4 = new JButton("b4");
		JButton b5 = new JButton("b5");

		ParallelGroup g1 = layout.createParallelGroup();
		g1.addComponent(b2);
		g1.addComponent(b3);
		g1.addComponent(b4);

		SequentialGroup g2 = layout.createSequentialGroup();
		g2.addComponent(b1);
		g2.addGroup(g1);
		g2.addComponent(b5);

		ParallelGroup g3 = layout.createParallelGroup();
		g3.addComponent(b1);
		g3.addComponent(b2);
		g3.addComponent(b5);

		SequentialGroup g4 = layout.createSequentialGroup();
		g4.addGroup(g3);
		g4.addComponent(b3);
		g4.addComponent(b4);

		layout.setHorizontalGroup(g2);
		layout.setVerticalGroup(g4);

		return p;
	}
	private JPanel demoSix() {
		JPanel p = new JPanel();
		p.setBorder(new TitledBorder("Demo Six"));
		GroupLayout layout = new GroupLayout(p);
		p.setLayout(layout);

		JButton b1 = new JButton("b1");
		JButton b2 = new JButton("b2");
		JButton b3 = new JButton("b3");
		JButton b4 = new JButton("b4");
		JButton b5 = new JButton("b5");

		ParallelGroup g1 = layout.createParallelGroup();
		g1.addComponent(b3);
		g1.addComponent(b4);
		g1.addComponent(b5);

		SequentialGroup g2 = layout.createSequentialGroup();
		g2.addComponent(b1);
		g2.addComponent(b2);
		g2.addGroup(g1);

		ParallelGroup g3 = layout.createParallelGroup();
		g3.addComponent(b1);
		g3.addComponent(b2);
		g3.addComponent(b3);

		SequentialGroup g4 = layout.createSequentialGroup();
		g4.addGroup(g3);
		g4.addComponent(b4);
		g4.addComponent(b5);

		layout.setHorizontalGroup(g2);
		layout.setVerticalGroup(g4);

		return p;
	}
	private void setupBottomDemo(Box b) {
		JPanel p = new JPanel();
		p.setBorder(new TitledBorder("Demo Seven"));
		GroupLayout layout = new GroupLayout(p);
		layout.setAutoCreateGaps(true);
		p.setLayout(layout);

		JButton b1 = new JButton("+++ Long button +++");
		JButton b2 = new JButton("Short Button");
		JButton b3 = new JButton("+++ Long button +++");
		JTextField t1 = new JTextField(10);
		JTextField t2 = new JTextField(10);
		JTextField t3 = new JTextField(10);

		ParallelGroup g1 = layout.createParallelGroup();
		g1.addComponent(b1);
		g1.addComponent(b2,GroupLayout.Alignment.TRAILING);
		g1.addComponent(b3);

		ParallelGroup g2 = layout.createParallelGroup();
		g2.addComponent(t1);
		g2.addComponent(t2);
		g2.addComponent(t3);

		SequentialGroup g3 = layout.createSequentialGroup();
		g3.addGroup(g1);
		g3.addGroup(g2);

		layout.setHorizontalGroup(g3);

		ParallelGroup g4 = layout.createParallelGroup();
		g4.addComponent(b1);
		g4.addComponent(t1);

		ParallelGroup g5 = layout.createParallelGroup();
		g5.addComponent(b2);
		g5.addComponent(t2);

		ParallelGroup g6 = layout.createParallelGroup();
		g6.addComponent(b3);
		g6.addComponent(t3);

		SequentialGroup g7 = layout.createSequentialGroup();
		g7.addGroup(g4);
		g7.addGroup(g5);
		g7.addGroup(g6);

		layout.setVerticalGroup(g7);

		b.add(p);
	}
}
