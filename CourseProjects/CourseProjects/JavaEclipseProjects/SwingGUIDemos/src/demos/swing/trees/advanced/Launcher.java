package demos.swing.trees.advanced;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.SwingUtilities;

public class Launcher {
	public static void main(String[] args) {
		final JFrame window = new JFrame("Tree Model Demo");
		MyTreeModel model = new MyTreeModel();
		JTree tree = new JTree(model);
		tree.expandPath(model.lowestPath());
		
		window.add(tree);
		window.setSize(300,200);
		
		Runnable r = new Runnable() {
			public void run() {
				window.setVisible(true);
			}
		};
		SwingUtilities.invokeLater(r);
		
	}

}
