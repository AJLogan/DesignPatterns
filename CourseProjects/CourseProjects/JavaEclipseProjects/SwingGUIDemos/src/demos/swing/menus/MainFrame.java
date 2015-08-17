package demos.swing.menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MainFrame extends JFrame {
	public MainFrame() {
		super("Menus Demo");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JMenuBar bar= new JMenuBar();
		JMenu menu1 = new JMenu("abc");
		menu1.setMnemonic(KeyEvent.VK_A);
		
		addSubMenus(menu1,"def","ghi","jkl");
		
		JMenu menu2 = new JMenu("mno");
		menu2.setMnemonic(KeyEvent.VK_M);
		addSubMenus(menu2,"pqr","stu","vwx");
		
		JMenu menu3 = new JMenu("ghi");
		menu3.setMnemonic(KeyEvent.VK_G);
		addSubMenus(menu3,"yza","bcd","efg");
		
		JMenu menu4 = new JMenu("last");
		menu4.setMnemonic(KeyEvent.VK_L);
		JMenuItem tmp = new JMenuItem("item",KeyEvent.VK_Z);
		tmp.setAccelerator(KeyStroke.getKeyStroke("F1"));
		tmp.addActionListener(listener);
		menu4.add(tmp);
		
		addMenusToMenuBar(bar, menu1, menu2, menu3, menu4);
		setJMenuBar(bar);
	}
	private void addMenusToMenuBar(JMenuBar bar, JMenu ... items) {
		for(JMenu m : items) {
			bar.add(m);
		}
	}
	private void addSubMenus(JMenu menu, String ... names) {
		for(String s : names) {
			JMenu tmp1 = new JMenu(s);
			
			JMenuItem tmp2 = new JMenuItem("xxx");
			tmp2.addActionListener(listener);
			
			JRadioButtonMenuItem tmp3 = new JRadioButtonMenuItem("yyy");
			tmp3.addActionListener(listener);
			
			JCheckBoxMenuItem tmp4 = new JCheckBoxMenuItem("zzz");
			tmp4.addActionListener(listener);
			
			tmp1.add(tmp2);
			tmp1.addSeparator();
			tmp1.add(tmp3);
			tmp1.addSeparator();
			tmp1.add(tmp4);
			
			menu.add(tmp1);
		}
	}
	private ActionListener listener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Menu item '" + e.getActionCommand() + "' was selected...");
		}
	};
}
