package geeks4Geeks.BinaryTree;

public class BinaryTreeDiameter {

	private static int getDiameter(TreeNode root) {
		if (root == null)
			return 0;

		int lh = getDiameter(root.left);
		int rh = getDiameter(root.right);

		int ldiameter = getDiameter(root.left);
		int rdiameter = getDiameter(root.right);

		return Math.max(lh + rh + 1, Math.max(ldiameter, rdiameter));
	}

	private static int getHeight(TreeNode node) {
		if (node == null)
			return 0;
		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode node1 = new TreeNode(0);
		TreeNode node2 = new TreeNode(0);
		TreeNode node3 = new TreeNode(0);
		TreeNode node4 = new TreeNode(0);
		TreeNode node5 = new TreeNode(0);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		System.out.println(getDiameter(root));
	}
}
