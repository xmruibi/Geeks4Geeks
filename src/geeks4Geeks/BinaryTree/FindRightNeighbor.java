package geeks4Geeks.BinaryTree;

public class FindRightNeighbor {

	private static TreeNode findRightNeighbor(TreeNode node) {
		int up = 0;
		while (true) {
			TreeNode parent = node.parent;
			while (parent != null
					&& (parent.right == null || parent.right == node)) {
				parent = parent.parent;
				up++;
			}
			if (parent == null)
				return null;
			TreeNode right = parent.right;
			TreeNode rightNeighbor = helper(right, up);
			if (rightNeighbor != null)
				return rightNeighbor;
		}
	}

	private static TreeNode helper(TreeNode node, int lv) {
		if (lv < 0)
			return null;
		if (lv == 0)
			return node;
		else {
			if (node.left != null)
				return helper(node.left, lv - 1);
			else if (node.right != null)
				return helper(node.right, lv - 1);
			else
				return null;
		}
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		n1.left = n2;
		n1.right = n3;
		n2.parent = n1;
		n3.parent = n1;
		n2.left = n4;
		n4.parent = n2;
		n3.right = n5;
		n5.parent = n3;
		n4.right = n6;
		n6.parent = n4;
		n5.left = n7;
		n7.right = n8;
		n8.parent = n7;
		n7.parent = n5;

		System.out.println(findRightNeighbor(n2).val);
	}

	private static class TreeNode {
		int val;
		TreeNode parent;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
}
