package demos.swing.trees.basic;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.tree.*;

public class Launcher {
	public static void main(String[] args) {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Movies");
		addActionMovies(root);
		addComedyMovies(root);
		addRomanceMovies(root);
		JTextField tf = new JTextField(10);
		JTree tree = new JTree(new DefaultTreeModel(root));
		tree.addTreeSelectionListener(new SampleTreeSelectionListener(tf));
		displayControls(tree,tf);
	}
	private static void addActionMovies(DefaultMutableTreeNode root) {
		DefaultMutableTreeNode actionMovies = new DefaultMutableTreeNode("Action");
		actionMovies.add(new DefaultMutableTreeNode("The Bourne Identity"));
		actionMovies.add(new DefaultMutableTreeNode("The Interpreter"));
		actionMovies.add(new DefaultMutableTreeNode("The Day Of The Jackal"));
		actionMovies.add(new DefaultMutableTreeNode("Predator"));
		actionMovies.add(new DefaultMutableTreeNode("Fight Club"));
		root.add(actionMovies);
	}
	private static void addRomanceMovies(DefaultMutableTreeNode root) {
		DefaultMutableTreeNode romanceMovies = new DefaultMutableTreeNode("Romance");
		romanceMovies.add(new DefaultMutableTreeNode("Pretty Woman"));
		romanceMovies.add(new DefaultMutableTreeNode("Youve Got Mail"));
		romanceMovies.add(new DefaultMutableTreeNode("Sleepless in Seattle"));
		romanceMovies.add(new DefaultMutableTreeNode("Wimbledon"));
		romanceMovies.add(new DefaultMutableTreeNode("Made in Manhattan"));
		root.add(romanceMovies);
	}
	private static void addComedyMovies(DefaultMutableTreeNode root) {
		DefaultMutableTreeNode comedyMovies = new DefaultMutableTreeNode("Comedy");
		comedyMovies.add(new DefaultMutableTreeNode("The Birdcage"));
		comedyMovies.add(new DefaultMutableTreeNode("Meet the Fockers"));
		comedyMovies.add(new DefaultMutableTreeNode("Dodgeball"));
		comedyMovies.add(new DefaultMutableTreeNode("Fifty First Dates"));
		comedyMovies.add(new DefaultMutableTreeNode("Good Morning Vietnam"));
		root.add(comedyMovies);
	}
	private static void displayControls(JTree tree, JTextField tf) {
		final JFrame window  = new JFrame("JTree Demo");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(tf,BorderLayout.NORTH);
		window.add(tree,BorderLayout.CENTER);
		window.setSize(300,500);
		window.setVisible(true);
		
		Runnable r = new Runnable() {
			public void run() {
				window.setVisible(true);
			}
		};
		SwingUtilities.invokeLater(r);
	}
}
