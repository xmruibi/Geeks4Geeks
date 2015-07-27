package geeks4Geeks.BinaryTree;

public class TreeBoundaryTraversal {

	private static void leftBoundary(TreeNode node) {
		if (node == null)
			return;

		if (node.left != null){
			System.out.println(node.val);
			leftBoundary(node.left);
		}else if (node.right != null){
			System.out.println(node.val);
			leftBoundary(node.right);
		}
		// no output for leaves
	}

	private static void checkLeaves(TreeNode node) {
		if (node == null)
			return;
		if (node.left == null && node.right == null) {
			System.out.println(node.val);
			return;
		}
		checkLeaves(node.left);
		checkLeaves(node.right);
	}

	private static void rightBoundary(TreeNode node) {
		if (node == null)
			return;
		if (node.right != null) {
			rightBoundary(node.right);
			System.out.println(node.val);
		} else if (node.left != null) {
			rightBoundary(node.left);
			System.out.println(node.val);
		}
		// no output for leaves
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
		n2.left = n4;
		n3.right = n5;
		n4.right = n6;
		n5.left = n7;
		n7.right = n8;
		leftBoundary(n1);
		checkLeaves(n1);
		rightBoundary(n1);
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
}
