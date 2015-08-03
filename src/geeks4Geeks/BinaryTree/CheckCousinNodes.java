package geeks4Geeks.BinaryTree;

public class CheckCousinNodes {

	private static boolean checkCousin(TreeNode root, TreeNode node1,
			TreeNode node2) {
		// same level
		if(checkSibling(root, node1, node2))
			return false;
		
		return checkLv(root, node1, 0)==checkLv(root, node2, 0);
	}

	private static boolean checkSibling(TreeNode root, TreeNode node1,
			TreeNode node2) {
		if (root == null)
			return false;
		if (root.left == node1 && root.right == node2)
			return true;
		else if (root.left == node2 && root.right == node1)
			return true;
		return checkSibling(root.left, node1, node2)
				|| checkSibling(root.right, node1, node2);
	}

	private static int checkLv(TreeNode root, TreeNode node, int levl) {
		if (root == null)
			return 0;
		if (root == node)
			return levl;

		int left = checkLv(root.left, node, levl + 1);
		if (left != 0)
			return left;
		return checkLv(root.right, node, levl + 1);
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n4.left = n6;
		n5.right = n7;
		System.out.println(checkCousin(n1, n4, n5));
	}
}
