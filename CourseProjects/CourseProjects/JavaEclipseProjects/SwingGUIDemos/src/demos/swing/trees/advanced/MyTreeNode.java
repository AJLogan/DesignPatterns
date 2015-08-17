package demos.swing.trees.advanced;

import java.util.Enumeration;

import javax.swing.tree.TreeNode;

public class MyTreeNode implements TreeNode {
	public MyTreeNode(boolean isLeaf, int index, TreeNode parent, String value) {
		this.isLeaf = isLeaf;
		this.index = index;
		this.parent = parent;
		this.value = value;
	}
	public void setChildren(TreeNode child1, TreeNode child2) {
		this.child1 = child1;
		this.child2 = child2;
	}
	public Enumeration children() {
		return new Enumeration() {
						public boolean hasMoreElements() {
							return index < 2;
						}
						public Object nextElement() {
							Object ref;
							if(index == 0) {
								ref = child1;
							} else if(index == 1) {
								ref = child2;
							} else {
								ref = null;
							}
							index++;
							return ref;
						}
						private int index;
					};
	}
	public boolean getAllowsChildren() {
		return true;
	}
	public TreeNode getChildAt(int index) {
		if(index == 0) {
			return child1;
		} else if(index == 1) {
			return child2;
		} else {
			throw new RuntimeException("Invalid index: " + index);
		}
	}
	public int getChildCount() {
		if(isLeaf) {
			return 0;
		} else {
			return 2;
		}
	}
	public int getIndex(TreeNode arg0) {
		return index;
	}
	public TreeNode getParent() {
		return parent;
	}
	public boolean isLeaf() {
		return isLeaf;
	}
	public String toString() {
		return value;
	}
	private boolean isLeaf;
	private int index;
	private TreeNode parent;
	private String value;
	private TreeNode child1;
	private TreeNode child2;
}
