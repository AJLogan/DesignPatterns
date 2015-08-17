package demos.swing.layouts.mig;

import java.awt.Color;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;

public class MainFrame extends JFrame {
	public MainFrame() {
		super("Demo of MIG Layout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Box b = Box.createVerticalBox();
		setupTopDemos(b);
		setupBottomDemo(b);
		add(b);
	}
	private void setupTopDemos(Box b) {
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new MigLayout());
		topPanel.add(demoOne());
		topPanel.add(demoTwo());
		topPanel.add(demoThree(),"wrap");
		topPanel.add(demoFour());
		topPanel.add(demoFive());
		b.add(topPanel);
	}
	private JPanel demoOne() {
		JPanel p = new JPanel();
		p.setBorder(new TitledBorder("Demo One"));
		MigLayout layout = new MigLayout();
		p.setLayout(layout);
		
		JButton b1 = new JButton("b1");
		JButton b2 = new JButton("b2");
		JButton b3 = new JButton("b3");
		JButton b4 = new JButton("b4");
		JButton b5 = new JButton("b5");
		JButton b6 = new JButton("b6");
		
		p.add(b1, "cell 0 0");
		p.add(b2, "cell 1 0");
		p.add(b3, "cell 2 0");
		p.add(b4, "cell 1 1");
		p.add(b5, "cell 2 1");
		p.add(b6, "cell 2 2");
		
		return p;
	}
	private JPanel demoTwo() {
		JPanel p = new JPanel();
		p.setBorder(new TitledBorder("Demo Two"));
		MigLayout layout = new MigLayout();
		p.setLayout(layout);
		
		JButton b1 = new JButton("b1");
		JButton b2 = new JButton("b2");
		JButton b3 = new JButton("b3");
		JButton b4 = new JButton("b4");
		JButton b5 = new JButton("b5");
		JButton b6 = new JButton("b6");
		
		p.add(b1);
		p.add(b2);
		p.add(b3, "wrap");
		p.add(b4);
		p.add(b5, "wrap");
		p.add(b6);
		
		return p;
	}
	private JPanel demoThree() {
		JPanel p = new JPanel();
		p.setBorder(new TitledBorder("Demo Three"));
		MigLayout layout = new MigLayout();
		p.setLayout(layout);
		
		JButton b1 = new JButton("b1");
		JButton b2 = new JButton("b2");
		JButton b3 = new JButton("b3");
		JButton b4 = new JButton("b4");
		JButton b5 = new JButton("b5");
		JButton b6 = new JButton("b6");
		
		p.add(b1, "dock west");
		p.add(b2, "dock north");
		p.add(b3, "dock north");
		p.add(b4, "dock center");
		p.add(b5, "dock east");
		p.add(b6, "dock south");
		
		return p;
	}
	private JPanel demoFour() {
		JPanel p = new JPanel();
		p.setBorder(new TitledBorder("Demo Four"));
		MigLayout layout = new MigLayout();
		p.setLayout(layout);
		
		JTextArea tf = new JTextArea(5,10);
		tf.setBorder(new LineBorder(Color.BLACK));
		JButton b1 = new JButton("b1");
		JButton b2 = new JButton("b2");
		JButton b3 = new JButton("b3");
		JButton b4 = new JButton("b4");
		JButton b5 = new JButton("b5");
		JButton b6 = new JButton("b6");
		JButton b7 = new JButton("b7");
		JButton b8 = new JButton("b8");
		JButton b9 = new JButton("b9");
		JButton b10 = new JButton("b10");
		
		p.add(b1);
		p.add(tf, "span 2 2"); 
		p.add(b2, "wrap"); 
		p.add(b3);
		p.add(b4); 
		p.add(b5, "wrap");
		p.add(b6);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(b10);
		
		return p;
	}
	private JPanel demoFive() {
		JPanel p = new JPanel();
		p.setBorder(new TitledBorder("Demo Five"));
		MigLayout layout = new MigLayout();
		p.setLayout(layout);
		
		JButton b1 = new JButton("b1");
		JButton b2 = new JButton("b2");
		JButton b3 = new JButton("b3");
		JButton b4 = new JButton("b4");
		JButton b5 = new JButton("b5");
		JButton b6 = new JButton("b6");
		
		JTextField tf1 = new JTextField(10);
		JTextField tf2 = new JTextField(10);
		JTextField tf3 = new JTextField(10);
		
		p.add(b1);
		p.add(tf1, "growx, span 2 ");
		p.add(b2);
		p.add(b3, "wrap");
		p.add(b4);
		p.add(tf2, "growx, span 3");
		p.add(b5, "wrap");
		p.add(b6);
		p.add(tf3, "growx, span");
		
		return p;
	}
	private void setupBottomDemo(Box b) {
		JPanel p = new JPanel();
		p.setBorder(new TitledBorder("Demo Six"));
		MigLayout layout = new MigLayout("","[][grow]","");
		p.setLayout(layout);
		
		JButton bt1 = new JButton("+++ Long button +++");
		JButton bt2 = new JButton("Short Button");
		JButton bt3 = new JButton("+++ Long button +++");
		JTextField tf1 = new JTextField(10);
		JTextField tf2 = new JTextField(10);
		JTextField tf3 = new JTextField(10);
		
		p.add(bt1);
		p.add(tf1, "growx, wrap");
		p.add(bt2, "align right");
		p.add(tf2, "growx, wrap");
		p.add(bt3);
		p.add(tf3, "growx, wrap");
		
		b.add(p);
	}
}
