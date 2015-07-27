package geeks4Geeks.BinaryTree;

public class ChildrenSum {

	private static boolean checkValid(TreeNode node) {
		if (node == null)
			return true;
		if (node.left == null && node.right == null)
			return true;
		int sum = 0;
		sum += node.left != null ? node.left.val : 0;
		sum += node.right != null ? node.right.val : 0;
		if (node.val != sum)
			return false;
		return checkValid(node.left) && checkValid(node.right);
	}

	private static void convertToChildSumTree(TreeNode node) {
		if (node == null)
			return;
		if(node.left==null&&node.right==null)
			return;
		int diff = node.val;
		diff -= node.left != null ? node.left.val : 0;
		diff -= node.right != null ? node.right.val : 0;
		if(diff!=0)
			node.left.val+=diff;
		convertToChildSumTree(node.left);
		convertToChildSumTree(node.right);
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(11);
		TreeNode n2 = new TreeNode(8);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(3);
		TreeNode n7 = new TreeNode(2);
		TreeNode n8 = new TreeNode(2);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n6.right = n7;
		n6.left = n8;
		convertToChildSumTree(n1);
		System.out.println(checkValid(n1));
	}

	private static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
}
