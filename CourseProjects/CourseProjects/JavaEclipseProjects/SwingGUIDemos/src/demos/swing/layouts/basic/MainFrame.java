package demos.swing.layouts.basic;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        super("A Demo Of the Different Layout Managers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        setFrameLayout();
    }
    private void setFrameLayout() {
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(gridLayoutPanel);
        c.add(flowLayoutPanel);
        c.add(borderLayoutPanel);
        c.add(boxLayoutOne);
        c.add(boxLayoutTwo);
    }
    private void initComponents() {
        initGridDemo();
        initFlowDemo();
        initBorderDemo();
        initBoxDemos();
    }
    private void initBoxDemos() {
        boxLayoutOne = Box.createHorizontalBox();
        addButtons(boxLayoutOne,5);
        addBorder(boxLayoutOne,"Horizontal Box");
        boxLayoutTwo = Box.createVerticalBox();
        addButtons(boxLayoutTwo,5);
        addBorder(boxLayoutTwo,"Vertical Box");
    }
    private void initBorderDemo() {
        borderLayoutPanel = new JPanel();
        borderLayoutPanel.setLayout(new BorderLayout());
        borderLayoutPanel.add(new JButton("North Button"),BorderLayout.NORTH);
        borderLayoutPanel.add(new JButton("South Button"),BorderLayout.SOUTH);
        borderLayoutPanel.add(new JButton("West Button"),BorderLayout.WEST);
        borderLayoutPanel.add(new JButton("East Button"),BorderLayout.EAST);
        borderLayoutPanel.add(new JButton("Center Button"),BorderLayout.CENTER);
        addBorder(borderLayoutPanel,"BorderLayout");
    }
    private void initFlowDemo() {
        flowLayoutPanel = new JPanel();
        flowLayoutPanel.setLayout(new FlowLayout());
        addButtons(flowLayoutPanel,5);
        addBorder(flowLayoutPanel,"FlowLayout");
    }
    private void initGridDemo() {
        gridLayoutPanel = new JPanel();
        gridLayoutPanel.setLayout(new GridLayout(3,4));
        addButtons(gridLayoutPanel,10);
        addBorder(gridLayoutPanel,"GridLayout (3 by 4)");
    }
    private void addButtons(JComponent widget, int noButtons) {
        for(int i=0;i<noButtons;i++) {
            widget.add(new JButton("Button " + i));
        }
    }
    private void addBorder(JComponent widget,String msg) {
        widget.setBorder(new TitledBorder(LineBorder.createBlackLineBorder(),msg));
    }
    private JPanel gridLayoutPanel;
    private JPanel flowLayoutPanel;
    private JPanel borderLayoutPanel;
    private Box boxLayoutOne;
    private Box boxLayoutTwo;
}
