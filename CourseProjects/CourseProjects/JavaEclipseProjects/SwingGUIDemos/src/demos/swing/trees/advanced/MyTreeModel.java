package demos.swing.trees.advanced;

import java.util.ArrayList;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class MyTreeModel implements TreeModel {
	public MyTreeModel() {
		nodes = new MyTreeNode[15];
		nodes[0] = new MyTreeNode(false,0,null,"root");
		nodes[1] = new MyTreeNode(false,0,nodes[0],"child1");
		nodes[2] = new MyTreeNode(false,1,nodes[0],"child2");
		nodes[3] = new MyTreeNode(false,0,nodes[1],"child3");
		nodes[4] = new MyTreeNode(false,1,nodes[1],"child4");
		nodes[5] = new MyTreeNode(false,0,nodes[2],"child5");
		nodes[6] = new MyTreeNode(false,1,nodes[2],"child6");
		nodes[7] = new MyTreeNode(true,0,nodes[3],"child7");
		nodes[8] = new MyTreeNode(true,1,nodes[3],"child8");
		nodes[9] = new MyTreeNode(true,0,nodes[4],"child9");
		nodes[10] = new MyTreeNode(true,1,nodes[4],"child10");
		nodes[11] = new MyTreeNode(true,0,nodes[5],"child11");
		nodes[12] = new MyTreeNode(true,1,nodes[5],"child12");
		nodes[13] = new MyTreeNode(true,0,nodes[6],"child13");
		nodes[14] = new MyTreeNode(true,1,nodes[6],"child14");
		
		nodes[0].setChildren(nodes[1], nodes[2]);
		nodes[1].setChildren(nodes[3], nodes[4]);
		nodes[2].setChildren(nodes[5], nodes[6]);
		nodes[3].setChildren(nodes[7], nodes[8]);
		nodes[4].setChildren(nodes[9], nodes[10]);
		nodes[5].setChildren(nodes[11], nodes[12]);
		nodes[6].setChildren(nodes[13], nodes[14]);
	}

	public Object getChild(Object obj, int index) {
		TreeNode node = findNode(obj);
		return node.getChildAt(index);
	}

	public int getChildCount(Object obj) {
		TreeNode node = findNode(obj);
		return node.getChildCount();
	}

	public int getIndexOfChild(Object parent, Object child) {
		TreeNode node = findNode(parent);
		return node.getIndex((TreeNode)child);
	}

	public Object getRoot() {
		return nodes[0];
	}

	public boolean isLeaf(Object obj) {
		TreeNode node = findNode(obj);
		return node.isLeaf();
	}
	private TreeNode findNode(Object obj) {
		for(TreeNode n : nodes) {
			if(n == obj) {
				return n;
			}
		}
		return null;
	}
	public TreePath lowestPath() {
		ArrayList<TreeNode> path = new ArrayList<TreeNode>();
		TreeNode tmp = nodes[0];
		do {
			path.add(tmp);
			tmp = tmp.getChildAt(1);
		} while(!tmp.isLeaf());
		
		return new TreePath(path.toArray());
	}
	public void removeTreeModelListener(TreeModelListener arg0) {
	}
	public void valueForPathChanged(TreePath arg0, Object arg1) {
	}
	public void addTreeModelListener(TreeModelListener arg0) {
	}
	private MyTreeNode [] nodes;
}
