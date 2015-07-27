package geeks4Geeks.BinaryTree;


public class SumTree {

	private static int convertSumTree(TreeNode node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null) {
			int res = node.val;
			node.val = 0;
			return res;
		}
		int left = convertSumTree(node.left);
		int right = convertSumTree(node.right);
		int sum = left + right + node.val;
		node.val = left + right;
		return sum;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(10);
		TreeNode n2 = new TreeNode(-2);
		TreeNode n3 = new TreeNode(6);
		TreeNode n4 = new TreeNode(8);
		TreeNode n5 = new TreeNode(-4);
		TreeNode n6 = new TreeNode(7);
		TreeNode n7 = new TreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		convertSumTree(n1);
		
	}

	private static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
}
