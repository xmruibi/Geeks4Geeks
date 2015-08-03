package geeks4Geeks.BinaryTree;

public class DeepestLeftNode {

	static int maxLv = 0;
	static TreeNode res;

	private static void findDeepestLeftNode(TreeNode node, int lv,
			boolean isLeft) {
		if (node == null)
			return;
		if (node.left == null && node.right == null && lv >= maxLv && isLeft) {
			res = node;
			return;
		}
		findDeepestLeftNode(node.left, lv + 1, true);
		findDeepestLeftNode(node.right, lv + 1, false);
	}

	public static void inorder(TreeNode node) {
		if (node == null)
			return;
		inorder(node.left);
		System.out.print(node.val + " ");
		inorder(node.right);
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
		TreeNode n9 = new TreeNode(9);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.right = n5;
		n4.left = n6;
		n5.left = n7;
		n5.right = n8;
		n8.right = n9;
		findDeepestLeftNode(n1, 0, false);
		System.out.println(res.val);
	}
}
